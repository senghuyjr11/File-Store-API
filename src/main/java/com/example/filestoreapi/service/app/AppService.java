package com.example.filestoreapi.service.app;

import com.example.filestoreapi.payload.app.AppRequest;
import org.springframework.http.ResponseEntity;

public interface AppService {
    ResponseEntity<?> addApp(AppRequest appRequest);
}
