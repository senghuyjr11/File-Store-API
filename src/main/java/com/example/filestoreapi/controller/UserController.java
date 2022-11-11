package com.example.filestoreapi.controller;

import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.service.user.UserService;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    @Autowired
    void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseObject addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }
}
