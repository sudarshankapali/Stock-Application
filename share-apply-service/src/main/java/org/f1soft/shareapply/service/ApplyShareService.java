package org.f1soft.shareapply.service;

import org.f1soft.shareapply.client.ShareApplyFeignClient;
import org.f1soft.shareapply.exception.IdNotFoundException;
import org.f1soft.shareapply.exception.TableEmptyException;
import org.f1soft.shareapply.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.random.RandomGenerator;

@Service
public class ApplyShareService {

    private static final Logger logger = LoggerFactory.getLogger(ApplyShareService.class);

//    private final ApiResponse apiResponse;
    private final ResponseData data;
    private final RandomGenerator randomGenerator = RandomGenerator.getDefault();
    private final GraphqlApplyShareService graphqlApplyShareService;
    private final ShareApplyFeignClient shareApplyFeignClient;

    public ApplyShareService( ResponseData data,
                             ShareApplyFeignClient shareApplyFeignClient,
                             GraphqlApplyShareService graphqlApplyShareService) {
//        this.apiResponse = apiResponse;
        this.data = data;
        this.shareApplyFeignClient = shareApplyFeignClient;
        this.graphqlApplyShareService = graphqlApplyShareService;
    }

    public ApiResponse applyShare(ApplyShare applyShare) {
        ApiResponse apiResponse=new ApiResponse();
        validatePresence(shareApplyFeignClient.getIssueId(), applyShare.getIssueId(), "IssueId not found", IdNotFoundException.class);
        validatePresence(shareApplyFeignClient.getAccountNumber(applyShare.getUserId()), applyShare.getAccountNumber(), "AccountNumber not found", IdNotFoundException.class);

        if (!checkQuantity(applyShare.getAppliedQuantity(), apiResponse)) {
            return apiResponse;
        }

        String applicationId = generateApplicationId(applyShare);
        applyShare.setApplicationId(applicationId);

        graphqlApplyShareService.createShareApplication(applyShare);

        data.setApplicationId(applicationId);
        data.setIssueId(applyShare.getIssueId());
        data.setUserId(applyShare.getUserId());
        data.setStatus(setStatus());

        apiResponse.setMessage("IPO has been applied successfully");
        apiResponse.setData(data);

        return apiResponse;
    }

    private <T extends RuntimeException> void validatePresence(List<String> list, String value, String errorMessage, Class<T> exceptionClass) {
        logger.info("Validating presence of value: {}", value);
        if (list.isEmpty()) {
            throw new TableEmptyException("UserId Not Found");
        }
        if (!list.contains(value)) {
            throw createException(errorMessage, exceptionClass);
        }
    }

    private <T extends RuntimeException> T createException(String message, Class<T> exceptionClass) {
        try {
            return exceptionClass.getConstructor(String.class).newInstance(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateApplicationId(ApplyShare applyShare) {
        return applyShare.getUserId() + "-" + applyShare.getIssueId() + "-" + randomGenerator.nextInt(101);
    }

    public boolean checkQuantity(Integer quantity, ApiResponse apiResponse) {
        if (quantity % 10 != 0) {
            apiResponse.setMessage("Applied quantity should be multiple of 10");
            apiResponse.setData(null);
            return false;
        }
        return true;
    }

    public Status setStatus() {
        int num = randomGenerator.nextInt(3);
        switch (num) {
            case 0: return Status.VERIFICATION_PENDING;
            case 1: return Status.VERIFIED;
            default: return Status.REJECTED;
        }
    }

    public List<ApplyShare> getAppliedShareById(String userId) {
        return graphqlApplyShareService.getAppliedShareById(userId);
    }

    public List<String> getApplicationId(String userId) {
        return graphqlApplyShareService.getApplicationId(userId);
    }
}
