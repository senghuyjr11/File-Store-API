package com.example.filestoreapi.service.company;

import com.example.filestoreapi.payload.company.CompanyRequest;
import com.example.filestoreapi.utils.ResponseObject;

public interface CompanyService {
    ResponseObject addCompany(CompanyRequest companyRequest);
    ResponseObject getAllCompanies();

    ResponseObject deleteCompany(Integer id);
}
