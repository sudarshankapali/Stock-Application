package org.f1soft.currentissue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.f1soft.currentissue.dto.ServerResponse;
import org.f1soft.currentissue.model.Issue;
import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    private final InventoryClient inventoryClient;

    @Autowired
    public IssueService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public ServerResponse getAllIssues() {
        List<Issue> issuesList = inventoryClient.getAllIssue();
        if (issuesList.isEmpty()) {
            return new ServerResponse("No issues are currently opened", null);
        }
        return new ServerResponse("Issues has been fetched", issuesList);
    }

    public ServerResponse getIssueById(String id, String issueRequestFor) {
        Optional<Issue> issue = inventoryClient.getIssueById(id);
        if (issue.isPresent()) {
            if (issueRequestFor.equals("opened")) {
                return new ServerResponse("Issue is currently opened", issue);
            }
            if (issueRequestFor.equals("specific")) {
                return new ServerResponse("Issue detail fetched successfully.", issue);
            }
        } else {
            if (issueRequestFor.equals("opened")) {
                return new ServerResponse("Issue is not opened", null);
            }
        }
        return new ServerResponse("Issue does not exist", null);
    }

    public List<String> getAllIssuesId() {
        return inventoryClient.getAllIssueIds();
    }

}
