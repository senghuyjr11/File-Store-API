package com.example.filestoreapi.payload.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRequest {
    private String fullName;
    private String username;
    private String email;
    private String profile;

    @Builder
    public UserRequest(String fullName, String username, String email, String profile) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }
}
