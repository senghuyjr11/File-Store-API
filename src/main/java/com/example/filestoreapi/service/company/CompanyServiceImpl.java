package com.example.filestoreapi.service.company;

import com.example.filestoreapi.domain.company.Company;
import com.example.filestoreapi.domain.company.CompanyRepository;
import com.example.filestoreapi.domain.user.UserRepository;
import com.example.filestoreapi.payload.company.CompanyRequest;
import com.example.filestoreapi.payload.company.CompanyResponse;
import com.example.filestoreapi.utils.FormatUtils;
import com.example.filestoreapi.utils.Message;
import com.example.filestoreapi.utils.ResponseError;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{

    private UserRepository userRepository;
    @Autowired
    void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private CompanyRepository companyRepository;

    @Autowired
    void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    ResponseObject response = new ResponseObject();
    List<Integer> emptyIntArr = new ArrayList<>();
    Message message = new Message();

    @Override
    public ResponseObject addCompany(CompanyRequest companyRequest) {

        Company company = Company.builder()
                .name(companyRequest.getName())
                .companySize(companyRequest.getCompanySize())
                .category(companyRequest.getCategory())
                .location(companyRequest.getLocation())
                .createdDate(FormatUtils.dateTimeFormat())
                .modifiedDate(FormatUtils.dateTimeFormat())
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
                .createdDate(company.getCreatedDate())
                .modifiedDate(company.getModifiedDate())
                .foundedDate(company.getFoundedDate())
                .logo(company.getLogo())
                .website(company.getWebsite())
                .status(company.getStatus())
                .usersId(emptyIntArr)
                .build();

        response.setData(companyResponse);
        response.setStatus(true);
        response.setMessage("Add Company Success!");
        return response;
    }

    @Override
    public ResponseObject getAllCompanies() {

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

    @Override
    public ResponseEntity<?> deleteCompany(Integer id) {
        Company company = companyRepository.findById(id);
        List<Integer> usersId = userRepository.getUsersByCompanyId(id);
        CompanyResponse companyResponse = new CompanyResponse();

        if (ObjectUtils.isEmpty(company)) {
            ResponseError responseError = ResponseError.builder()
                    .status(false)
                    .message(message.getFailNotFound("Company"))
                    .build();
           return ResponseEntity.ok(responseError);
        } else {
            companyResponse.setCategory(company.getCategory());
            companyResponse.setCategory(company.getCreatedDate());
            companyResponse.setModifiedDate(company.getModifiedDate());
            companyResponse.setStatus(company.getStatus());
            companyResponse.setLocation(company.getLocation());
            companyResponse.setLogo(company.getLogo());
            companyResponse.setFoundedDate(company.getFoundedDate());
            companyResponse.setWebsite(company.getWebsite());
            companyResponse.setId(company.getId());
            companyResponse.setCompanySize(company.getCompanySize());
            companyResponse.setName(company.getName());

            if (ObjectUtils.isEmpty(usersId)) {
                companyResponse.setUsersId(emptyIntArr);
            } else {
                companyResponse.setUsersId(usersId);
            }

            response.setData(companyResponse);
            companyRepository.deleteById(id);
            response.setStatus(true);
            response.setMessage(message.deleteSuccess("Company"));
        }
        return ResponseEntity.ok(response);
    }
}
