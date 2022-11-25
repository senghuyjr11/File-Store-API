package com.example.filestoreapi.controller;

import com.example.filestoreapi.payload.app.AppRequest;
import com.example.filestoreapi.service.app.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/app")
public class AppController {

    private AppService appService;

    @Autowired
    void setAppService(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/add-app")
    public ResponseEntity<?> addApp(@RequestBody AppRequest appRequest) {
        return appService.addApp(appRequest);
    }

}
