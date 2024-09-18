package org.f1soft.shareapply.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "GATEWAY")
public interface ShareApplyFeignClient {

    @GetMapping("/api/current-issues/getIssueId")
    List<String> getIssueId();

    @GetMapping("/api/user/{userId}/getAccountNumber")
    List<String> getAccountNumber(@PathVariable("userId") String userId);
}
