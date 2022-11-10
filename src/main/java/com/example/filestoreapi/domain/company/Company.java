package com.example.filestoreapi.domain.company;

import com.example.filestoreapi.domain.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "company_user")
@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortName;
    private String overview;
    private String coverImage;
    private String logo;
    private String website;
    private String category;
    private String companySize;
    private String location;
    private String foundedDate;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private Integer status;

/*    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<User> users;*/
}
