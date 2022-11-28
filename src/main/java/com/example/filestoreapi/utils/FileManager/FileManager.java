package com.example.filestoreapi.utils.FileManager;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import static org.apache.catalina.startup.ExpandWar.delete;

public class FileManager {

    public Boolean copyFileToDestination(String fileType,String source,String name,String destination) {

        File resource = new File(source);
        File tempDest = new File(destination + "/" + name + fileType);

        // move file to temp folder
        return canMoveFile(resource, tempDest);

    }

    private Boolean canMoveFile(File tempResource, File storageDest) {
        try {
            copyFileUsingChannel(tempResource,storageDest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            FilePermission(dest.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error Messge :"+e.getMessage());
//            System.out.println("Error Type :"+e.getClass());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    public void createAPlistAtDirectory(String path, String pathURL, String bundleID, String versionName, String bundleName, String newFileName) throws IOException {

        String fullFilePath = path + newFileName + ".plist";

        File file = new File(fullFilePath);

        if (file.createNewFile()) {
            System.out.println("Plist is created.");
        } else {
            System.out.println("Something wrong, During ipa uploading");
        }

        // to create plist format for iOS upload ipa file
        String plistBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "                    <!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "                    <plist version=\"1.0\">\n" +
                "                    <dict>\n" +
                "                        <key>items</key>\n" +
                "                        <array>\n" +
                "                            <dict>\n" +
                "                                <key>assets</key>\n" +
                "                                <array>\n" +
                "                                    <dict>\n" +
                "                                        <key>kind</key>\n" +
                "                                        <string>software-package</string>\n" +
                "                                        <key>url</key>\n" +
                "                                        <string>"+pathURL+"</string>\n" +
                "                                    </dict>\n" +
                "                                </array>\n" +
                "                                <key>metadata</key>\n" +
                "                                <dict>\n" +
                "                                    <key>bundle-identifier</key>\n" +
                "                                    <string>"+bundleID+"</string>\n" +
                "                                    <key>bundle-version</key>\n" +
                "                                    <string>"+versionName+"</string>\n" +
                "                                    <key>kind</key>\n" +
                "                                    <string>software</string>\n" +
                "                                    <key>title</key>\n" +
                "                                    <string>"+bundleName+"</string>\n" +
                "                                </dict>\n" +
                "                            </dict>\n" +
                "                        </array>\n" +
                "                    </dict>\n" +
                "                    </plist>";


        PrintWriter writer = new PrintWriter(fullFilePath, "UTF-8");
        writer.println(plistBody);
        writer.close();

        FilePermission(fullFilePath);
    }

    public static void deleteDirectoryAtPath (String path) throws IOException{

        File directory = new File(path);
        if (directory.exists()) {
            if(directory.isDirectory()){

                //directory is empty, then delete it
                if(directory.list().length==0){

                    directory.delete();
                    System.out.println("Directory is deleted : " + directory.getAbsolutePath());

                }else{

                    //list all the directory contents
                    String files[] = directory.list();

                    for (String temp : files) {
                        //construct the file structure
                        File fileDelete = new File(directory, temp);

                        //recursive delete
                        delete(fileDelete);
                    }

                    //check the directory again, if empty then delete it
                    if(directory.list().length==0){
                        directory.delete();
                        System.out.println("Directory is deleted : " + directory.getAbsolutePath());
                    }
                }

            }else{
                //if file, then delete it
                directory.delete();
                System.out.println("File is deleted : " + directory.getAbsolutePath());
            }
        }
    }
    public Boolean checkFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();

    }

    public static void deleteEverythingInADirectory(File directory) throws IOException{
        FileUtils.cleanDirectory(directory);
    }

    public Boolean createADirectoryAtPath(String directoryName, String path) {
        String directoryAndPath = path + "/" + directoryName;

        File file = new File(directoryAndPath);
        try {
            file.mkdirs();
        } catch (Exception e) {
            System.out.println(" Error create directory and path :"+e.getMessage());
            System.out.println("Error create directory and path class :"+e.getMessage());
            return false;
        }
        FilePermission(directoryAndPath);

        return true;
    }

    public void FilePermission(String strPath){
        try {
            Path path = Paths.get(strPath);

            // set full permission for all file - 777
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
        }catch (Exception e) {
            System.out.println("Error FilePermission :"+e.getMessage());
            System.out.println("Error FilePermission class :"+e.getMessage());
        }
    }
    public FileInformationResponse getFileInformation(String filePath) {
        FileInformationResponse obj = new FileInformationResponse();
        Path path = Paths.get(filePath);
        try {

            // Size of a file (in bytes)
            long bytes = Files.size(path);

            obj.setFileSize(getSizeLabel(bytes)); // convert size to MB or GB
            obj.setFileName(path.getFileName().toString());

            if (path.toString().toLowerCase().endsWith(".ipa")){
                obj.setFileExtension("ipa");
            }else if (path.toString().toLowerCase().endsWith(".apk")){
                obj.setFileExtension("apk");
            }else {
                obj.setFileExtension("unknow");
            }

            return obj;
        } catch (IOException e) {
            obj.setFileSize("Error");
            obj.setFileName("Error");
            obj.setFileExtension("Error");
            return obj;
        }

    }
    private static String getSizeLabel(long size) {

        String cnt_size = "0";
        double size_kb = size / 1024;
        double size_mb = size_kb / 1024;
        double size_gb = size_mb / 1024;

        if (Math.floor(size_gb) > 0) {
            try {
                String[] snplit = String.valueOf((size_gb)).split("\\.");
                cnt_size = snplit[0] + "." + snplit[1].substring(0, 2) + "GB";
            } catch (Exception e) {

                cnt_size = String.valueOf(Math.round(size_gb)) + "GB";
            }
        } else if (Math.floor(size_mb) > 0) {
            try {
                String[] snplit = String.valueOf((size_mb)).split("\\.");
                cnt_size = snplit[0] + "." + snplit[1].substring(0, 2) + "MB";

            } catch (Exception e) {

                cnt_size = String.valueOf(Math.round(size_mb)) + "MB";
            }
        } else {
            cnt_size = String.valueOf(Math.round(size_kb)) + "KB";
        }

        return cnt_size;
    }
}
