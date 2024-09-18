package org.f1soft.graphclient.service;

import org.f1soft.graphclient.entity.Issue;
import org.f1soft.graphclient.repository.IssusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    final IssusRepository issusRepository;
    @Autowired
    public IssueService(IssusRepository issusRepository) {
        this.issusRepository = issusRepository;
    }

    public List<Issue> getAllIssues() {
        List<Issue> issues = issusRepository.findAll();
        return issues;
    }

    public Issue getIssueById(String id) {
        Optional<Issue> issue = issusRepository.findById(id);
        return issue.orElse(null);
    }
    public List<String> getAllIssueIds() {
        return issusRepository.getAllIssueId();
    }
}
