package com.example.filestoreapi.service.company;

import com.example.filestoreapi.domain.company.Company;
import com.example.filestoreapi.domain.company.CompanyRepository;
import com.example.filestoreapi.payload.company.CompanyRequest;
import com.example.filestoreapi.payload.company.CompanyResponse;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    @Autowired
    void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    ResponseObject response = new ResponseObject();

    @Override
    public ResponseObject addCompany(CompanyRequest companyRequest) {

        Company company = Company.builder()
                .name(companyRequest.getName())
                .companySize(companyRequest.getCompanySize())
                .category(companyRequest.getCategory())
                .location(companyRequest.getLocation())
                .foundedDate(companyRequest.getFoundedDate())
                .logo(companyRequest.getLogo())
                .website(companyRequest.getWebsite())
                .status(1L)
                .build();
        companyRepository.save(company);

        CompanyResponse companyResponse = CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .companySize(company.getCompanySize())
                .category(company.getCategory())
                .location(company.getLocation())
                .foundedDate(company.getFoundedDate())
                .logo(company.getLogo())
                .website(company.getWebsite())
                .status(company.getStatus())
                .build();

        response.setData(companyResponse);
        response.setStatus(true);
        response.setMessage("Add Company Success!");
        return response;
    }

    @Override
    public ResponseObject getAllCompany() {

        List<Company> company = companyRepository.findAll();

        List<CompanyResponse> companyResponse = company.stream().map(
                x -> CompanyResponse.builder()
                        .id(x.getId())
                        .name(x.getName())
                        .location(x.getLocation())
                        .logo(x.getLogo())
                        .category(x.getCategory())
                        .foundedDate(x.getFoundedDate())
                        .companySize(x.getCompanySize())
                        .website(x.getWebsite())
                        .status(x.getStatus())
                        .build()
        ).collect(Collectors.toList());

        response.setData(companyResponse);
        response.setStatus(true);
        response.setMessage("Found company!");
        return response;
    }
}
