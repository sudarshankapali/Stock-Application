package com.f1soft.user_services.controller;

import com.f1soft.user_services.entity.ResponseMessage;
import com.f1soft.user_services.services.UserServices;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/{id}")
    private ResponseMessage getUserDetails(@PathVariable String id){
        return userServices.getUserDetails(id);
    }


    @GetMapping("/{userId}/accounts")
    private ResponseMessage getAccountDetails(@PathVariable String userId){
        return userServices.getAccountDetails(userId);
    }

    @GetMapping("/getUserId")
    private List<String> getAllUser(){
        return userServices.getAllUserId();
    }

    @GetMapping("/{userId}/getAccountNumber")
    private List<String> getUserAccountNumbers(@PathVariable String userId){
        return userServices.getAllAccountIdOfUser(userId);
    }

    @GetMapping("")
    private ResponseMessage getAllUsers(){
        return userServices.getAllUser();
    }

}
