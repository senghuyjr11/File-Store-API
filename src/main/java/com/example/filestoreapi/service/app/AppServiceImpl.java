package com.example.filestoreapi.service.app;

import com.example.filestoreapi.domain.app.App;
import com.example.filestoreapi.domain.app.AppRepository;
import com.example.filestoreapi.domain.company.Company;
import com.example.filestoreapi.domain.company.CompanyRepository;
import com.example.filestoreapi.domain.user.User;
import com.example.filestoreapi.domain.user.UserRepository;
import com.example.filestoreapi.payload.app.AppRequest;
import com.example.filestoreapi.payload.app.AppResponse;
import com.example.filestoreapi.utils.FormatUtils;
import com.example.filestoreapi.utils.Message;
import com.example.filestoreapi.utils.ResponseError;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AppServiceImpl implements AppService {
    ResponseObject responseObject = new ResponseObject();
    ResponseError responseError = new ResponseError();
    Message message = new Message();
    private AppRepository appRepository;

    @Autowired
    void setAppRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
    private CompanyRepository companyRepository;

    @Autowired
    void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    private UserRepository userRepository;

    @Autowired
    void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> addApp(AppRequest appRequest) {

        Company company = companyRepository.findById(appRequest.getCompanyId());
        User user = userRepository.findById(appRequest.getUserId());

        if (ObjectUtils.isEmpty(company)) {
            responseError.setMessage(message.getFailNotFound("Company Id"));
            responseError.setStatus(false);
            return ResponseEntity.ok(responseError);
        } else if (ObjectUtils.isEmpty(user)) {
            responseError.setMessage(message.getFailNotFound("User Id"));
            responseError.setStatus(false);
            return ResponseEntity.ok(responseError);
        } else {
            App app = App.builder()
                    .companyId(company.getId())
                    .userId(appRequest.getUserId())
                    .name(appRequest.getAppName())
                    .createdDate(FormatUtils.dateTimeFormat())
                    .modifiedDate(FormatUtils.dateTimeFormat())
                    .icon(appRequest.getIcon())
                    .isPublic(false)
                    .status(1)
                    .build();
            appRepository.save(app);

            AppResponse appResponse = AppResponse.builder()
                    .id(app.getId())
                    .appName(app.getName())
                    .icon(app.getIcon())
                    .createdAt(app.getCreatedDate())
                    .modifyAt(app.getModifiedDate())
                    .appOfCompany(company.getName())
                    .companyId(app.getCompanyId())
                    .userId(app.getUserId())
                    .userName(user.getUsername())
                    .isPublic(app.getIsPublic())
                    .status(app.getStatus())
                    .build();
            responseObject.setStatus(true);
            responseObject.setMessage(message.insertSuccess("App"));
            responseObject.setData(appResponse);
        }

        return ResponseEntity.ok(responseObject);
    }
}
