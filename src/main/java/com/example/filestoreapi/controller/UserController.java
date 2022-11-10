package com.example.filestoreapi.controller;

import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.service.user.UserService;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    private UserService userService;
    @Autowired
    void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public ResponseObject addUser(@RequestBody UserRequest userRequest) {
        return userService.insertUser(userRequest);
    }
}
