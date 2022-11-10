package com.example.filestoreapi.service.user;

import com.example.filestoreapi.domain.user.User;
import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.utils.ResponseObject;

import java.time.LocalDate;

public class UserServiceImpl implements UserService{

    ResponseObject response = new ResponseObject();
    LocalDate now = LocalDate.now();

    @Override
    public ResponseObject insertUser(UserRequest userRequest) {
        User user = User.builder()
                .fullName(userRequest.getFullName())
                .username(userRequest.getFullName())
                .email(userRequest.getEmail())
                .createdDate(now)
                .modifiedDate(now)
                .profile(userRequest.getProfile())
                .build();
        response.setData(user);
        response.setStatus(true);
        response.setMessage("Add new user success");
        return response;
    }
}
