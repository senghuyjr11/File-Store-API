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
public class AppVersionRequest {
    private Integer appId;
    private String fileName;
    private String osType;
    private String environmentType;
    private String description;

    @Builder
    public AppVersionRequest(Integer appId, String osType, String environmentType, String description, String fileName) {
        this.appId = appId;
        this.osType = osType;
        this.environmentType = environmentType;
        this.description = description;
        this.fileName = fileName;
    }
}
