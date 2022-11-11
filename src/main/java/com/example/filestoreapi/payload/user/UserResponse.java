package com.example.filestoreapi.payload.user;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String fullName;
    private String username;
    private String email;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String profile;

    @Builder
    public UserResponse(Integer id, String fullName, String username, String email, LocalDate createdDate, LocalDate modifiedDate, String profile) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profile = profile;
    }
}
