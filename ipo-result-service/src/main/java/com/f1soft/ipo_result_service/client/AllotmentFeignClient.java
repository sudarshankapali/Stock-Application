package com.f1soft.ipo_result_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "GATEWAY")
public interface AllotmentFeignClient {
    @GetMapping("/api/current-issues/getIssueId")
    List<String> getCurrentIssueId();

    @GetMapping("/api/ipo/applicationId/{userId}")
    List<String> getApplicationId(@PathVariable("userId") String userId);
}
