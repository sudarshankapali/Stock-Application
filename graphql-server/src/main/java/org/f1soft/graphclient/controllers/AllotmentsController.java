package org.f1soft.graphclient.controllers;

import org.f1soft.graphclient.entity.Allotments;
import org.f1soft.graphclient.entity.AllotmentsInput;
import org.f1soft.graphclient.service.AllotmentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AllotmentsController {
    private final AllotmentService allotmentService;
    public AllotmentsController(final AllotmentService allotmentService) {
        this.allotmentService = allotmentService;
    }

    @MutationMapping
    public Allotments createAllotment(@Argument AllotmentsInput input) {
        Allotments allotment = new Allotments();
        allotment.setApplicationId(input.getApplicationId());
        allotment.setIssueId(input.getIssueId());
        allotment.setNoOfAllotments(input.getNoOfAllotments());
        return allotmentService.saveAllotment(allotment);
    }

    @QueryMapping
    public int getNoOfAllotments(@Argument String applicationId, @Argument String issueId) {
        return allotmentService.getNoOfAllotments(applicationId, issueId);
    }

    @QueryMapping
    public Boolean existsById(@Argument String applicationId) {
        return allotmentService.existsById(applicationId);
    }

    @QueryMapping
    public Optional<Allotments> getAllotmentById(@Argument String applicationId) {
        return allotmentService.getAllotmentById(applicationId);
    }
}
