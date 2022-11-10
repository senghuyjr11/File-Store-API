package com.example.filestoreapi.service.user;

import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseObject insertUser(UserRequest userRequest);
}
