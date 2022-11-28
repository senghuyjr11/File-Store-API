package com.example.filestoreapi.service.file;

import com.example.filestoreapi.utils.Const;
import com.example.filestoreapi.utils.Message;
import com.example.filestoreapi.utils.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@MultipartConfig(maxFileSize = 314572800, maxRequestSize = 314572800)
public class FileServiceImpl implements FileService {
    ResponseObject responseObject = new ResponseObject();
    Message message = new Message();
    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file) {
        try {
            System.out.println("++++++ MultipartController ++++++");
            System.out.println("--> "+file.getName());
            System.out.println("--> "+file.getOriginalFilename());
            System.out.println("--> "+file.getSize());
            System.out.println("--> "+file.getContentType());
            System.out.println("++++++++++++++++++++++++++++++++++");

            String strPathFile      = Const.OS_FOLDER_PATH + "/" + Const.TEMPORARY + "/";
            String strPathImage     = Const.OS_FOLDER_PATH + "/" + Const.STORAGE + "/" + Const.IMAGE + "/";

            String uuid             = UUID.randomUUID().toString();
            String strExt           = getFileExtension(file.getOriginalFilename());
            String strFullNamePath  = "";
            String strFileName      = "";

            switch (strExt) {
                case "jpg": {
                    strFileName         = uuid + ".jpg";
                    strFullNamePath     = strPathImage + strFileName;
                    break;
                }
                case "png":{
                    strFileName         = uuid + ".png";
                    strFullNamePath     = strPathImage + strFileName;
                    break;
                }
                case "ipa":{
                    strFileName         = uuid + ".ipa";
                    strFullNamePath     = strPathFile + strFileName;
                    break;
                }
                case "apk":{
                    strFileName         = uuid + ".apk";
                    strFullNamePath     = strPathFile + strFileName;
                    break;
                }
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(strFullNamePath);
            Files.write(path, bytes);

            // Set Permission Full
            try{
                Set<PosixFilePermission> perms = new HashSet<>();
                perms.add(PosixFilePermission.OWNER_READ);
                perms.add(PosixFilePermission.OWNER_WRITE);
                perms.add(PosixFilePermission.OWNER_EXECUTE);

                perms.add(PosixFilePermission.OTHERS_READ);
                perms.add(PosixFilePermission.OTHERS_WRITE);
                perms.add(PosixFilePermission.OTHERS_EXECUTE);

                perms.add(PosixFilePermission.GROUP_READ);
                perms.add(PosixFilePermission.GROUP_WRITE);
                perms.add(PosixFilePermission.GROUP_EXECUTE);

                Files.setPosixFilePermissions(path, perms);

            }catch (Exception e){

                System.out.println("Error FilePermission :" + e.getMessage());
                System.out.println("Error FilePermission class :" + e.getMessage());

            }

            HashMap<String, Object> map = new HashMap<>();
            map.put("file_name",strFileName);

            responseObject.setMessage(message.uploadSuccess());
            responseObject.setStatus(true);
            responseObject.setData(map);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(responseObject);
    }

    private String getFileExtension(String strFileName) {
        try {
            return strFileName.substring(strFileName.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
