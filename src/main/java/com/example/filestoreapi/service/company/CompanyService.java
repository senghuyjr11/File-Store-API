package com.example.filestoreapi.service.company;

import com.example.filestoreapi.payload.company.CompanyRequest;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface CompanyService {
    ResponseObject addCompany(CompanyRequest companyRequest);
    ResponseObject getAllCompanies();

    ResponseEntity<?> deleteCompany(Integer id);
}
