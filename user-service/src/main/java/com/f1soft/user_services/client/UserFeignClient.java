package com.f1soft.user_services.client;

import com.f1soft.user_services.entity.ApplyShare;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "GATEWAY")
public interface UserFeignClient {
    @GetMapping("/api/ipo/user/{userId}")
    List<ApplyShare> getApplyShare(@PathVariable("userId") String userId);
}
