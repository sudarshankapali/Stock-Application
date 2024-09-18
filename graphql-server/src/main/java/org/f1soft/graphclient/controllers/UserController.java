package org.f1soft.graphclient.controllers;

import org.f1soft.graphclient.entity.Accounts;
import org.f1soft.graphclient.entity.User;
import org.f1soft.graphclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //get all users
    @QueryMapping
    public List<User> getUsers(){
        return userService.findAll();
    }
    //get user by id
    @QueryMapping
    public User getUserById(@Argument String id){
        return userService.findById(id);
    }
    @QueryMapping
    public List<String> getAllUserIds(){
        return userService.getAllUserIds();
    }
    @QueryMapping
    public List<Accounts> getAccountsByUserId(@Argument String userId){
        return userService.getAccountsByUserId(userId);
    }

    @QueryMapping
    public List<String> getAllIssueId(){
        return userService.getAllUserIds();
    }

}
