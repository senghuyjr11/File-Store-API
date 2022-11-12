package com.example.filestoreapi.domain.company;

import com.example.filestoreapi.domain.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "companies")
@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String logo;
    private String website;
    private String category;
    private String companySize;
    private String location;
    private String foundedDate;
    private String createdDate;
    private String modifiedDate;
    private Long status;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<User> users;

    @Builder
    public Company(Integer id, String name, String logo, String website, String category, String companySize,
                   String location, String foundedDate, Long status, String createdDate, String modifiedDate) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.website = website;
        this.category = category;
        this.companySize = companySize;
        this.location = location;
        this.foundedDate = foundedDate;
        this.status = status;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
