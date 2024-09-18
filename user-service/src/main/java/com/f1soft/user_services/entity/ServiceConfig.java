package com.f1soft.user_services.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ResponseMessage responseMessage() {
        return new ResponseMessage();

    }
}