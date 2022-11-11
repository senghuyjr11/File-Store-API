package com.example.filestoreapi.payload.company;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyRequest {
    private String name;
    private String logo;
    private String website;
    private String category;
    private String companySize;
    private String location;
    private String foundedDate;
}
