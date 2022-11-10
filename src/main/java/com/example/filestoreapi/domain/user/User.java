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
    private String email;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String profile;

/*    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private Company company;*/

    @Builder
    public User(Long id, String fullName, String username, String email, LocalDate createdDate, LocalDate modifiedDate, String profile) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profile = profile;
    }
}
