package com.example.filestoreapi.controller;

import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.service.user.UserService;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;
    @Autowired
    void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping
    public ResponseObject getAllUser() {
        return userService.getAllUser();
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
