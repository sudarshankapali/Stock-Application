package org.f1soft.currentissue.service;

import org.f1soft.currentissue.model.Issue;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InventoryClient {
    private HttpGraphQlClient graphQlClient;

    public InventoryClient(HttpGraphQlClient graphQlClient) {
        this.graphQlClient = graphQlClient;
    }

    public List<Issue> getAllIssue(){
        String query = "query GetIssues {\n" +
                "    getIssues {\n" +
                "        id\n" +
                "        name\n" +
                "        description\n" +
                "    }\n" +
                "}\n";
        return graphQlClient.document(query)
                .retrieve("getIssues")
                .toEntityList(Issue.class)
                .block();
    }

    public Optional<Issue> getIssueById(String id){
        String query = String.format("query GetIssueById {\n" +
                "    getIssueById(id: \"%s\") {\n" +
                "        id\n" +
                "        name\n" +
                "        description\n" +
                "    }\n" +
                "}",id);
        Issue issue = graphQlClient.document(query)
                .retrieve("getIssueById")
                .toEntity(Issue.class)
                .block();
        return Optional.ofNullable(issue);
    }

    public List<String> getAllIssueIds() {
        String query = String.format("query MyQuery {\n" +
                "  getAllIssueId\n" +
                "}");
        return graphQlClient.document(query)
                .retrieve("getAllIssueId")
                .toEntityList(String.class)
                .block();
    }

}
