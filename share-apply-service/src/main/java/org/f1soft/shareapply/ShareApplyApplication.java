package org.f1soft.shareapply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

@EnableDiscoveryClient
public class ShareApplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareApplyApplication.class, args);
	}

}
