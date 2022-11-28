package com.example.filestoreapi.utils;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AOSUtils {

    public static synchronized Map<String, String> getAPKInfo(String apkFilePath) {
        Map<String, String> apkInfo = new HashMap<>();
        try (ApkFile apkFile = new ApkFile(new File(apkFilePath))) {
            ApkMeta apkMeta = apkFile.getApkMeta();

            apkInfo.put("name",apkMeta.getLabel());
            apkInfo.put("version", apkMeta.getVersionName());


            return apkInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
