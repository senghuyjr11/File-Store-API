package com.example.filestoreapi.payload.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CompanyRequest {
    private String name;
    private String logo;
    private String website;
    private String category;
    private String companySize;
    private String location;
    private String foundedDate;
    private Long userId;
}
