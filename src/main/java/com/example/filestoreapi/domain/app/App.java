package com.example.filestoreapi.domain.app;

import com.example.filestoreapi.domain.appversion.AppVersion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "apps")
@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer userId;
    private Integer companyId;
    private String name;
    private Integer status;
    private String icon;
    private String createdDate;
    private String modifiedDate;
    private Boolean isPublic;

    @OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<AppVersion> appVersions;

    @Builder
    public App(Integer id, Integer userId, Integer companyId, String name, Integer status, String icon,
               String createdDate, String modifiedDate, Boolean isPublic) {
        this.id = id;
        this.userId = userId;
        this.companyId = companyId;
        this.name = name;
        this.status = status;
        this.icon = icon;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.isPublic = isPublic;
    }
}
