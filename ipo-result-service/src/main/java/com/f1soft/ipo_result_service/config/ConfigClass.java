package com.f1soft.ipo_result_service.config;

import com.f1soft.ipo_result_service.entity.ResponseMessage;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigClass{

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpGraphQlClient httpGraphQlClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9000/graphql")
                .build();
        return HttpGraphQlClient.builder(webClient).build();
    }
}
