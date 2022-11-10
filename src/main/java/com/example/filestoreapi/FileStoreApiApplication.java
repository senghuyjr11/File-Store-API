package com.example.filestoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FileStoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileStoreApiApplication.class, args);
    }


}
