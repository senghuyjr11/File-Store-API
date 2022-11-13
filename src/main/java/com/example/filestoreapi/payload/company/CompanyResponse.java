package com.example.filestoreapi.payload.company;

import com.example.filestoreapi.domain.user.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyResponse {
    private Integer id;
    private String name;
    private String logo;
    private String website;
    private String category;
    private String companySize;
    private String location;
    private String createdDate;
    private String modifiedDate;
    private String foundedDate;
    private Long status;
    private List<Integer> users;

    @Builder
    public CompanyResponse(Integer id, String name, String logo, String website,
                           String category, String companySize, String location,
                           String foundedDate, Long status, String createdDate,
                           String modifiedDate, List<Integer> users) {
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
        this.users = users;
    }
}
