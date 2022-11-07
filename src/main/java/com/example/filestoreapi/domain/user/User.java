package com.example.filestoreapi.domain.user;

import com.example.filestoreapi.domain.company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "users")
@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String phoneNumber;
    private String gender;
    private String email;
    private int type;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private int status;
    private String profile;
    private String recovery;
    private String device_token;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private Company company;

}
