package com.example.filestoreapi.payload.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
    private Integer id;
    private String fullName;
    private String username;
    private String email;
    private String createdDate;
    private String modifiedDate;
    private String profile;
    private Integer companyId;
}
