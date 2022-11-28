package com.example.filestoreapi.service.appversion;

import com.example.filestoreapi.payload.appversion.AppVersionRequest;
import org.springframework.http.ResponseEntity;

public interface AppVersionService {
    ResponseEntity<?> addAppVersion(AppVersionRequest appVersionRequest);
}
