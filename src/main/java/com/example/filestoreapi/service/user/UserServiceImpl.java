package com.example.filestoreapi.service.user;

import com.example.filestoreapi.domain.company.Company;
import com.example.filestoreapi.domain.company.CompanyRepository;
import com.example.filestoreapi.domain.user.User;
import com.example.filestoreapi.domain.user.UserRepository;
import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.payload.user.UserResponse;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    ResponseObject response = new ResponseObject();
    LocalDate now = LocalDate.now();
    List<String> emptyArr = new ArrayList<>();

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

    @Override
    public ResponseObject addUser(UserRequest userRequest) {

        Company company = companyRepository.findById(userRequest.getCompanyId());

        if (ObjectUtils.isEmpty(company)) {
            response.setData(emptyArr);
            response.setStatus(false);
            response.setMessage("Company ID not found!");
        } else {
            User user = User.builder()
                    .fullName(userRequest.getFullName())
                    .username(userRequest.getFullName())
                    .email(userRequest.getEmail())
                    .createdDate(now)
                    .modifiedDate(now)
                    .profile(userRequest.getProfile())
                    .company(company)
                    .build();
            userRepository.save(user);

            UserResponse userResponse = UserResponse.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .createdDate(user.getCreatedDate())
                    .modifiedDate(user.getModifiedDate())
                    .profile(user.getProfile())
                    .companyId(company.getId())
                    .build();

            response.setData(userResponse);
            response.setStatus(true);
            response.setMessage("Add new user success");
        }
        return response;
    }
}
