package com.example.filestoreapi.payload.app;

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
public class AppResponse {
    private Integer id;
    private String appName;
    private String createdAt;
    private String modifyAt;
    private String icon;
    private Integer userId;
    private String userName;
    private Integer companyId;
    private String appOfCompany;
    private Boolean isPublic;
    private Integer status;

    @Builder
    public AppResponse(Integer id, String appName, String createdAt, String modifyAt, String icon,
                       Integer userId, String userName, Integer companyId, String appOfCompany,
                       Boolean isPublic, Integer status) {
        this.id = id;
        this.appName = appName;
        this.createdAt = createdAt;
        this.modifyAt = modifyAt;
        this.icon = icon;
        this.userId = userId;
        this.userName = userName;
        this.companyId = companyId;
        this.appOfCompany = appOfCompany;
        this.isPublic = isPublic;
        this.status = status;
    }
}
