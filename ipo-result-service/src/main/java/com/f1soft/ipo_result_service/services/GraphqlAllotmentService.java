package com.f1soft.ipo_result_service.services;

import com.f1soft.ipo_result_service.entity.Allotments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GraphqlAllotmentService {
    @Autowired
    HttpGraphQlClient httpGraphQlClient;

    public Allotments createAllotment(Allotments allotment) {
        String mutation = String.format(
                "mutation CreateAllotment {\n" +
                        "    createAllotment(input: {\n" +
                        "        applicationId: \"%s\"\n" +
                        "        issueId: \"%s\"\n" +
                        "        noOfAllotments: %d\n" +
                        "    }) {\n" +
                        "        applicationId\n" +
                        "        issueId\n" +
                        "        noOfAllotments\n" +
                        "    }\n" +
                        "}",
                allotment.getApplicationId(),
                allotment.getIssueId(),
                allotment.getNoOfAllotments()
        );

        return httpGraphQlClient.document(mutation)
                .retrieve("createAllotment")
                .toEntity(Allotments.class)
                .block();
    }

    public int getNoOfAllotments(String applicationId, String issueId) {
        String query = String.format(
                "query GetNoOfAllotments {\n" +
                        "    getNoOfAllotments(applicationId: \"%s\", issueId: \"%s\")\n" +
                        "}",
                applicationId,
                issueId
        );

        return httpGraphQlClient.document(query)
                .retrieve("getNoOfAllotments")
                .toEntity(Integer.class)
                .block();
    }

    public Optional<Allotments> getAllotmentById(String applicationId) {
        String query = String.format(
                "query GetAllotmentById {\n" +
                        "    getAllotmentById(applicationId: \"%s\") {\n" +
                        "        applicationId\n" +
                        "        issueId\n" +
                        "        noOfAllotments\n" +
                        "    }\n" +
                        "}",
                applicationId
        );

        Allotments allotment = httpGraphQlClient.document(query)
                .retrieve("getAllotmentById")
                .toEntity(Allotments.class)
                .block();

        return Optional.ofNullable(allotment);
    }

    public Boolean existsById(String applicationId) {
        String query = String.format(
                "query ExistsById {\n" +
                        "    existsById(applicationId: \"%s\")\n" +
                        "}",
                applicationId
        );

        return httpGraphQlClient.document(query)
                .retrieve("existsById")
                .toEntity(Boolean.class)
                .block();
    }
}
