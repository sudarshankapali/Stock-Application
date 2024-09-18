package com.f1soft.ipo_result_service.controller;

import com.f1soft.ipo_result_service.entity.Allotments;
import com.f1soft.ipo_result_service.entity.ResponseMessage;
import com.f1soft.ipo_result_service.services.AllotmentServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AllotmentController {
    private AllotmentServices allotmentServices;

    public AllotmentController(AllotmentServices allotmentServices) {
        this.allotmentServices = allotmentServices;
    }

    @PostMapping("/addAllotment/{userId}")
    private void addAllotment(@RequestBody Allotments allotments, @PathVariable String userId){
        allotmentServices.addAllotments(allotments,userId);
    }

    @PostMapping("/allotment-result")
    private ResponseMessage getAllotmentResult(@RequestBody Allotments allotments){
        return allotmentServices.getAllotmentResult(allotments);
    }
}
