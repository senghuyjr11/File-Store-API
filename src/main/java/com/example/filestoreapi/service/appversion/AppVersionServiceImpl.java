package com.example.filestoreapi.service.appversion;

import com.example.filestoreapi.domain.app.App;
import com.example.filestoreapi.domain.app.AppRepository;
import com.example.filestoreapi.domain.appversion.AppVersion;
import com.example.filestoreapi.domain.appversion.AppVersionRepository;
import com.example.filestoreapi.domain.fileapp.FileApp;
import com.example.filestoreapi.domain.fileapp.FileAppRepository;
import com.example.filestoreapi.payload.appversion.AppVersionRequest;
import com.example.filestoreapi.payload.appversion.AppVersionResponse;
import com.example.filestoreapi.utils.*;
import com.example.filestoreapi.utils.FileManager.FileInformationResponse;
import com.example.filestoreapi.utils.FileManager.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppVersionServiceImpl implements AppVersionService {

    ResponseObject responseObject = new ResponseObject();
    ResponseError responseError = new ResponseError();
    Message message = new Message();
    private FileAppRepository fileAppRepository;

    @Autowired
    void setFileAppRepository(FileAppRepository fileAppRepository) {
        this.fileAppRepository = fileAppRepository;
    }

    private AppVersionRepository appVersionRepository;

    @Autowired
    void setAppVersionRepository(AppVersionRepository appVersionRepository) {
        this.appVersionRepository = appVersionRepository;
    }

    private AppRepository appRepository;

    @Autowired
    void setAppRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public ResponseEntity<?> addAppVersion(AppVersionRequest appVersionRequest) {

        String strTempPath = Const.OS_FOLDER_PATH + "/" + Const.TEMPORARY + "/" + appVersionRequest.getFileName();

        // Move file to server
        FileManager fileManager = new FileManager();
        if (fileManager.checkFileExist(strTempPath)) {
            // appInfo for ios or aos
            Map<String, String> appInfo = appVersionRequest.getOsType().equals("aos") ? AOSUtils.getAPKInfo(strTempPath) : iOSUtils.getIPAInfo(strTempPath);

            // for os
            String appVersionAos = appInfo != null ? appInfo.get("version") : "";
            String appVersionIos = appInfo != null ? appInfo.get("Version") : "";

            // get app version ios or aos
            String appVersionNumber = (appVersionRequest.getOsType().equals("aos")) ? appVersionAos : appVersionIos;

            App app = appRepository.findById(appVersionRequest.getAppId());

            // Get file Information
            FileInformationResponse fileInfo = fileManager.getFileInformation(strTempPath);

            FileApp fileApp = FileApp.builder()
                    .size(fileInfo.getFileSize())
                    .extension(fileInfo.getFileExtension())
                    .status(1)
                    .build();

            fileAppRepository.save(fileApp);

            AppVersion appVersion = AppVersion.builder()
                    .app(app)
                    .fileName(appVersionRequest.getFileName())
                    .osType(appVersionRequest.getOsType())
                    .environmentType(appVersionRequest.getEnvironmentType())
                    .description(appVersionRequest.getDescription())
                    .versionNumber(appVersionNumber)
                    .fileId(fileApp.getId())
                    .fileSizeApp(fileApp.getSize())
                    .createdDate(FormatUtils.dateTimeFormat())
                    .modifiedDate(FormatUtils.dateTimeFormat())
                    .status(1)
                    .build();

            appVersionRepository.save(appVersion);

            AppVersionResponse appVersionResponse = AppVersionResponse.builder()
                    .id(appVersion.getId())
                    .appId(appVersion.getApp().getId())
                    .appName(appVersion.getApp().getName())
                    .createdDate(appVersion.getCreatedDate())
                    .modifiedDate(appVersion.getModifiedDate())
                    .description(appVersion.getDescription())
                    .environmentType(appVersion.getEnvironmentType())
                    .fileName(appVersion.getFileName())
                    .fileSizeApp(appVersion.getFileSizeApp())
                    .osType(appVersion.getOsType())
                    .status(appVersion.getStatus())
                    .versionNumber(appVersion.getVersionNumber())
                    .build();

            responseObject.setData(appVersionResponse);
            responseObject.setMessage(message.insertSuccess("App Version"));
            responseObject.setStatus(true);
        } else {
            responseError.setStatus(false);
            responseError.setMessage(message.insertFail("App Version"));
            return ResponseEntity.ok(responseError);
        }

        return ResponseEntity.ok(responseObject);
    }
}
