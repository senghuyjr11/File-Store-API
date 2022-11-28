package com.example.filestoreapi.payload.appversion;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AppVersionResponse {
    private Integer id;
    private Integer appId;
    private String appName;
    private String fileName;
    private String versionNumber;
    private String osType;
    private String environmentType;
    private String description;
    private String createdDate;
    private String modifiedDate;
    private Integer status;
    private String fileSizeApp;

    @Builder

    public AppVersionResponse(Integer id, Integer appId, String appName, String fileName, String versionNumber,
                              String osType, String environmentType, String description, String createdDate,
                              String modifiedDate, Integer status, String fileSizeApp) {
        this.id = id;
        this.appId = appId;
        this.appName = appName;
        this.fileName = fileName;
        this.versionNumber = versionNumber;
        this.osType = osType;
        this.environmentType = environmentType;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.fileSizeApp = fileSizeApp;
    }
}
