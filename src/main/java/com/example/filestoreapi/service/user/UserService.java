package com.example.filestoreapi.service.user;

import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.utils.ResponseObject;


public interface UserService {
    ResponseObject addUser(UserRequest userRequest);
}
