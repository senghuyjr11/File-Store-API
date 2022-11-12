package com.example.filestoreapi.service.user;

import com.example.filestoreapi.domain.company.Company;
import com.example.filestoreapi.domain.company.CompanyRepository;
import com.example.filestoreapi.domain.user.User;
import com.example.filestoreapi.domain.user.UserRepository;
import com.example.filestoreapi.payload.user.UserRequest;
import com.example.filestoreapi.payload.user.UserResponse;
import com.example.filestoreapi.utils.FormatUtils;
import com.example.filestoreapi.utils.Message;
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
    Message message = new Message();
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
            response.setMessage(message.notExist("Company"));
        } else {
            User user = User.builder()
                    .fullName(userRequest.getFullName())
                    .username(userRequest.getFullName())
                    .email(userRequest.getEmail())
                    .createdDate(FormatUtils.dateTimeFormat())
                    .modifiedDate(FormatUtils.dateTimeFormat())
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
            response.setMessage(message.insertSuccess("User"));
        }
        return response;
    }

    @Override
    public ResponseObject getAllUser() {
        List<User> users = userRepository.findAll();
        if (ObjectUtils.isEmpty(users)) {
            response.setData(emptyArr);
            response.setStatus(false);
            response.setMessage(message.getFailNotFound("Users"));
        } else {
            response.setData(users);
            response.setStatus(true);
            response.setMessage(message.getFoundSuccess("Users"));
        }
        return response;
    }

    @Override
    public ResponseObject deleteUser(Integer id) {
        User user = userRepository.findById(id);
        if (ObjectUtils.isEmpty(user)) {
            response.setMessage(message.getFailNotFound("User"));
            response.setStatus(false);
            response.setData(emptyArr);
        } else {
            response.setData(user);
            userRepository.deleteById(id);
            response.setStatus(true);
            response.setMessage(message.deleteSuccess("User"));
        }
        return response;
    }
}
