package org.f1soft.currentissue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    @Bean
    public HttpGraphQlClient httpGraphQlClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9000/graphql")
                .build();
        return HttpGraphQlClient.builder(webClient).build();
    }
}
