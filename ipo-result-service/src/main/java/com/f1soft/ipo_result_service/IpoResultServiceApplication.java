package com.f1soft.ipo_result_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class IpoResultServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpoResultServiceApplication.class, args);
	}

}
