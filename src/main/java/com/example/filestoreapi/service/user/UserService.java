package com.example.filestoreapi.service.user;

import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> addUser(UserRequest userRequest);

    ResponseObject getAllUser();

    ResponseObject deleteUser(Integer id);
}
