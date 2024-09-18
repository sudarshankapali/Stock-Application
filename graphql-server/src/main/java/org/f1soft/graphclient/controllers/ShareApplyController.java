package org.f1soft.graphclient.controllers;

import org.f1soft.graphclient.entity.ShareApply;
import org.f1soft.graphclient.entity.ShareApplyInput;
import org.f1soft.graphclient.service.ApplyShareService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShareApplyController {
    private ApplyShareService applyShareService;

    public ShareApplyController(ApplyShareService applyShareService) {
        this.applyShareService = applyShareService;
    }
    @MutationMapping
    public ShareApply createShareApplication(@Argument ShareApplyInput input) {
        System.out.println(input);
        ShareApply shareApply = new ShareApply();
        shareApply.setUserId(input.getUserId());
        shareApply.setAccountNumber(input.getAccountNumber());
        shareApply.setIssueId(input.getIssueId());
        shareApply.setAppliedQuantity(input.getAppliedQuantity());
        shareApply.setCrn(input.getCrn());
        shareApply.setApplicationId(input.getApplicationId());
        return applyShareService.save(shareApply);
    }

    @QueryMapping
    public List<ShareApply> getAppliedShareById(@Argument String userId){
        return applyShareService.getAppliedShareById(userId);
    }

    @QueryMapping
    public List<String> getApplicationId(@Argument String userId){
        return applyShareService.getApplicationId(userId);
    }
}
