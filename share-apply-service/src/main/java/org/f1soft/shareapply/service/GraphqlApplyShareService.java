package org.f1soft.shareapply.service;

import org.f1soft.shareapply.model.ApplyShare;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class GraphqlApplyShareService {
    private final HttpGraphQlClient httpGraphQlClient;

    public GraphqlApplyShareService(HttpGraphQlClient httpGraphQlClient) {
        this.httpGraphQlClient = httpGraphQlClient;
    }

    public ApplyShare createShareApplication(ApplyShare shareApply) {
        String mutation = String.format(
                "mutation CreateShareApplication {\n" +
                        "    createShareApplication(input: {\n" +
                        "        userId: \"%s\"\n" +
                        "        accountNumber: \"%s\"\n" +
                        "        issueId: \"%s\"\n" +
                        "        appliedQuantity: %d\n" +
                        "        crn: \"%s\"\n" +
                        "        applicationId: \"%s\"\n" +
                        "    }) {\n" +
                        "        id\n" +
                        "        userId\n" +
                        "        accountNumber\n" +
                        "        issueId\n" +
                        "        appliedQuantity\n" +
                        "        crn\n" +
                        "        applicationId\n" +
                        "    }\n" +
                        "}",
                shareApply.getUserId(),
                shareApply.getAccountNumber(),
                shareApply.getIssueId(),
                shareApply.getAppliedQuantity(),
                shareApply.getCrn(),
                shareApply.getApplicationId()
        );

        return httpGraphQlClient.document(mutation)
                .retrieve("createShareApplication")
                .toEntity(ApplyShare.class)
                .block();
    }

    public List<ApplyShare> getAppliedShareById(String userId) {
        String query = String.format("query GetAppliedShareById {\n" +
                "    getAppliedShareById(userId: \"%s\") {\n" +
                "        id\n" +
                "        userId\n" +
                "        accountNumber\n" +
                "        issueId\n" +
                "        appliedQuantity\n" +
                "        crn\n" +
                "        applicationId\n" +
                "    }\n" +
                "}", userId);

        return httpGraphQlClient.document(query)
                .retrieve("getAppliedShareById")
                .toEntityList(ApplyShare.class)
                .block();
    }

    public List<String> getApplicationId(String userId) {

        String query = String.format("query GetApplicationId {\n" +
                "    getApplicationId(userId: \"%s\")\n" +
                "}", userId);
        System.out.println(httpGraphQlClient.document(query)
                .retrieve("getApplicationId")
                .toEntityList(String.class)
                .block());
        return httpGraphQlClient.document(query)
                .retrieve("getApplicationId")
                .toEntityList(String.class)
                .block();
    }
}
