package com.example.filestoreapi.service.user;

import com.example.filestoreapi.domain.user.User;
import com.example.filestoreapi.domain.user.UserRepository;
import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.payload.user.UserResponse;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService{

    ResponseObject response = new ResponseObject();
    LocalDate now = LocalDate.now();

    private UserRepository userRepository;

    @Autowired
    void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseObject addUser(UserRequest userRequest) {

        User user = User.builder()
                .fullName(userRequest.getFullName())
                .username(userRequest.getFullName())
                .email(userRequest.getEmail())
                .createdDate(now)
                .modifiedDate(now)
                .profile(userRequest.getProfile())
                .build();
        userRepository.save(user);

        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdDate(user.getCreatedDate())
                .modifiedDate(user.getModifiedDate())
                .profile(user.getProfile())
                .build();

        response.setData(userResponse);
        response.setStatus(true);
        response.setMessage("Add new user success");
        return response;
    }
}
