package com.example.filestoreapi.controller;

import com.example.filestoreapi.payload.company.CompanyRequest;
import com.example.filestoreapi.service.company.CompanyService;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseObject addCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.addCompany(companyRequest);
    }
}
