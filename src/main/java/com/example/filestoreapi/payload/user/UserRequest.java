package com.example.filestoreapi.payload.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String phoneNumber;
    private String gender;
    private String email;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String profile;

    @Builder
    public UserRequest(Long id, String fullName, String username, String password,
                       String phoneNumber, String gender, String email, LocalDate createdDate,
                       LocalDate modifiedDate, String profile, String recovery, String device_token) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profile = profile;
    }
}
