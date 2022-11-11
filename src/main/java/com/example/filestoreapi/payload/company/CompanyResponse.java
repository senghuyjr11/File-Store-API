package com.example.filestoreapi.payload.company;

import com.example.filestoreapi.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CompanyResponse {
    private Integer id;
    private String name;
    private String logo;
    private String website;
    private String category;
    private String companySize;
    private String location;
    private String foundedDate;
    private Integer status;
    private List<User> users;

    @Builder
    public CompanyResponse(Integer id, String name, String logo, String website, String category, String companySize, String location, String foundedDate, Integer status, List<User> users) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.website = website;
        this.category = category;
        this.companySize = companySize;
        this.location = location;
        this.foundedDate = foundedDate;
        this.status = status;
        this.users = users;
    }
}
