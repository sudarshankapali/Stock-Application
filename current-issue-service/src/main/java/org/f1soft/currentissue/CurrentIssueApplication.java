package org.f1soft.currentissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrentIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrentIssueApplication.class, args);
	}

}
