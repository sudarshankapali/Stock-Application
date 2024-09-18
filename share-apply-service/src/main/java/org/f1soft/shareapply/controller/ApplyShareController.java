package org.f1soft.shareapply.controller;

import org.f1soft.shareapply.model.ApiResponse;
import org.f1soft.shareapply.model.ApplyShare;
import org.f1soft.shareapply.service.ApplyShareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ipo")
public class ApplyShareController {

    private ApplyShareService applyShareService;

    public ApplyShareController(ApplyShareService applyShareService) {
        this.applyShareService = applyShareService;
    }

    @PostMapping("/apply")
    public ApiResponse applyIPO(@RequestBody ApplyShare model) {
        return applyShareService.applyShare(model);
    }

    @GetMapping("/user/{userId}")
    public List<ApplyShare> getApplyShareById(@PathVariable String userId){
        return applyShareService.getAppliedShareById(userId);
    }

    @GetMapping("/applicationId/{userId}")
    public List<String> getApplicationIdByUserId(@PathVariable String userId){
        return applyShareService.getApplicationId(userId);
    }
}
