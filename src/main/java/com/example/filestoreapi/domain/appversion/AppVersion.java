package com.example.filestoreapi.domain.appversion;

import com.example.filestoreapi.domain.app.App;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "app_versions")
@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AppVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String fileName;
    private String versionNumber;
    private String osType;
    private String environmentType;
    private String description;
    private String createdDate;
    private String modifiedDate;
    private Integer status;
    private String fileSizeApp;
    private Integer fileId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "app_id")
    private App app;

    @Builder
    public AppVersion(Integer id, String fileName, String versionNumber, String osType, String environmentType,
                      String description, String createdDate, String modifiedDate, Integer status, String fileSizeApp, Integer fileId, App app) {
        this.id = id;
        this.fileName = fileName;
        this.versionNumber = versionNumber;
        this.osType = osType;
        this.environmentType = environmentType;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.fileSizeApp = fileSizeApp;
        this.fileId = fileId;
        this.app = app;
    }
}
