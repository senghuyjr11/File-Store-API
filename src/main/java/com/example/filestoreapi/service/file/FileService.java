package com.example.filestoreapi.service.file;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResponseEntity<?> uploadFile(MultipartFile file);
}
