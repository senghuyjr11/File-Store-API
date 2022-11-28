package com.example.filestoreapi.domain.fileapp;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "file_apps")
@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FileApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String size;
    private String extension;
    private Integer status;

    @Builder
    public FileApp(Integer id, String size, String extension, Integer status) {
        this.id = id;
        this.size = size;
        this.extension = extension;
        this.status = status;
    }
}
