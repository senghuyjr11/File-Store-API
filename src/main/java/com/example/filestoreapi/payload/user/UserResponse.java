package com.example.filestoreapi.payload.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
    private Integer id;
    private String fullName;
    private String username;
    private String email;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String profile;
    private Integer companyId;
}
