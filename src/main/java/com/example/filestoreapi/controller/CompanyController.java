package com.example.filestoreapi.controller;

import com.example.filestoreapi.payload.company.CompanyRequest;
import com.example.filestoreapi.service.company.CompanyService;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
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

    @GetMapping
    public ResponseEntity<?> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Integer id) {
        return companyService.deleteCompany(id);
    }
}
