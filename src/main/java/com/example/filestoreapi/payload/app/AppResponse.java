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
    private Boolean isPublic;
    private Integer userId;
    private String userName;
    private Integer companyId;
    private String appOfCompany;

    @Builder

    public AppResponse(Integer id, String appOfCompany, String appName, String createdAt,
                       String modifyAt, String icon, Boolean isPublic, Integer userId, String userName,
                       Integer companyId) {
        this.id = id;
        this.appOfCompany = appOfCompany;
        this.appName = appName;
        this.createdAt = createdAt;
        this.modifyAt = modifyAt;
        this.icon = icon;
        this.isPublic = isPublic;
        this.userId = userId;
        this.userName = userName;
        this.companyId = companyId;
    }
}
