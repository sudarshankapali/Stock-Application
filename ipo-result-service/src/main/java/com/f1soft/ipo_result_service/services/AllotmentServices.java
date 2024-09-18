package com.f1soft.ipo_result_service.services;

import com.f1soft.ipo_result_service.client.AllotmentFeignClient;
import com.f1soft.ipo_result_service.entity.Allotments;
import com.f1soft.ipo_result_service.entity.ResponseMessage;
import com.f1soft.ipo_result_service.exception.IssueIdNotFoundException;
import com.f1soft.ipo_result_service.exception.TableEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllotmentServices {


    private AllotmentFeignClient allotmentFeignClient;

    public AllotmentServices(AllotmentFeignClient allotmentFeignClient) {
        this.allotmentFeignClient = allotmentFeignClient;
//        this.responseMessage = responseMessage;
    }

    private final Logger logger = LoggerFactory.getLogger(AllotmentServices.class);
    @Autowired
    private GraphqlAllotmentService graphqlAllotmentService;

    public void addAllotments(Allotments allotments, String userId) {
        List<String> issueIds = allotmentFeignClient.getCurrentIssueId();
        logger.info("Fetched issueIds: {}", issueIds);
        if (issueIds == null || issueIds.isEmpty()) {
            throw new TableEmptyException("The value is yet to be entered");
        }

        if (!issueIds.contains(allotments.getIssueId())) {
            throw new IssueIdNotFoundException("IssueId not found");
        }

        List<String> applicationIds = allotmentFeignClient.getApplicationId(userId);
        logger.info("Fetched applicationIds: {}", applicationIds);
        if (applicationIds == null || applicationIds.isEmpty()) {
            throw new TableEmptyException("The value is yet to be entered");
        }

        if (!applicationIds.contains(allotments.getApplicationId())) {
            throw new IssueIdNotFoundException("ApplicationId not found");
        }

        graphqlAllotmentService.createAllotment(allotments);
        logger.info("Allotments saved successfully for applicationId: {}", allotments.getApplicationId());
    }

    public ResponseMessage getAllotmentResult(Allotments allotments) {
        ResponseMessage responseMessage=new ResponseMessage();
        String applicationId = allotments.getApplicationId();
        String issueId = allotments.getIssueId();

        if (graphqlAllotmentService.existsById(applicationId)) {
            Allotments savedAllotments = graphqlAllotmentService.getAllotmentById(applicationId)
                    .orElseThrow(() -> new TableEmptyException("IPO has not been allotted"));

            if (issueId.equals(savedAllotments.getIssueId())) {
                responseMessage.setMessage("IPO has been allotted");
                responseMessage.setAllottedQuantity(graphqlAllotmentService.getNoOfAllotments(applicationId, issueId));
            } else {
                throw new TableEmptyException("IPO has not been allotted");
            }
        } else {
            throw new TableEmptyException("IPO has not been allotted");
        }
        return responseMessage;
    }
}