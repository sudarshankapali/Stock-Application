package com.f1soft.user_services.services;

import com.f1soft.user_services.entity.Accounts;
import com.f1soft.user_services.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GraphqlUserService {
    @Autowired
    private HttpGraphQlClient httpGraphQlClient;

        public List<User> getAllUsers(){
        String query = "query GetUsers {\n" +
                "    getUsers {\n" +
                "        userId\n" +
                "        name\n" +
                "    }\n" +
                "}";
        return httpGraphQlClient.document(query)
                .retrieve("getUsers")
                .toEntityList(User.class)
                .block();
    }

    public Optional<User> getUserById(String id){
        String query = String.format("query MyQuery {\n" +
                "  getUserById(id: \"%s\") {\n" +
                "    name\n" +
                "    userId\n" +
                "    accounts {\n" +
                "      accountHolderName\n" +
                "      accountNumber\n" +
                "    }\n" +
                "  }\n" +
                "}", id);
        User user = httpGraphQlClient.document(query)
                .retrieve("getUserById")
                .toEntity(User.class)
                .block();
        return Optional.ofNullable(user);
    }
    public List<String> getAllUserIds(){
            String query = "query MyQuery {\n" +
                    "  getAllUserIds\n" +
                    "}";
        return httpGraphQlClient.document(query)
                .retrieve("getAllUserIds")
                .toEntityList(String.class)
                .block();
    }

    public List<Accounts> getAccountsByUserId(String userId) {
        String query = String.format("query GetAccountsByUserId {\n" +
                "    getAccountsByUserId(userId: \"%s\") {\n" +
                "        accountNumber\n" +
                "        accountHolderName\n" +
                "        branch {\n" +
                "            branchId\n" +
                "            branchName\n" +
                "            bank {\n" +
                "                bankId\n" +
                "                bankName\n" +
                "            }\n" +
                "        }\n" +
                "        user {\n" +
                "            name\n" +
                "        }\n" +
                "    }\n" +
                "}", userId);

        return httpGraphQlClient.document(query)
                .retrieve("getAccountsByUserId")
                .toEntityList(Accounts.class)
                .block();
    }
}