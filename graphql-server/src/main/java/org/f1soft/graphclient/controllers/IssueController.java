package org.f1soft.graphclient.controllers;

import org.f1soft.graphclient.entity.Issue;
import org.f1soft.graphclient.service.IssueService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IssueController {
    private final IssueService issueService;
    public IssueController(final IssueService issueService) {
        this.issueService = issueService;
    }
    @QueryMapping
    public List<Issue> getIssues() {
        return issueService.getAllIssues();
    }

    @QueryMapping
    public Issue getIssueById(@Argument String id) {
        return issueService.getIssueById(id);
    }
}
