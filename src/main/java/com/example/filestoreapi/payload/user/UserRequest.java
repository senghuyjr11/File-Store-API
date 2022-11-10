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
    private String email;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String profile;

    @Builder
    public UserRequest(Long id, String fullName, String username, String email, LocalDate createdDate,
                       LocalDate modifiedDate, String profile) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profile = profile;
    }
}
