package com.example.filestoreapi.utils.FileManager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileInformationResponse {
    private String fileSize;
    private String fileExtension;
    private String fileName;
}



