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

@Entity(name = "users")
@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String username;
    private String email;
    private String createdDate;
    private String modifiedDate;
    private String profile;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder
    public User(Integer id, String fullName, String username, String email, String createdDate,
                String modifiedDate, String profile, Company company) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profile = profile;
        this.company = company;
    }
}
