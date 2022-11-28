package com.example.filestoreapi.utils;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import com.example.filestoreapi.utils.FileManager.FileManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class iOSUtils {
    public static synchronized Map<String, String> getIPAInfo(String ipaFilePath) {
        Map<String, String> ipaInfo = new HashMap<>();
        UnzipUtility unzipUtility = new UnzipUtility();

        File ipaFile = new File(ipaFilePath);
        String ipaAbsPath = ipaFile.getAbsolutePath();
        String ipaDirectory = new File(ipaAbsPath).getParent();
        String fullPath = ipaDirectory + "/Payload";

        // unzip ipa zip file
        try {
            unzipUtility.unzip(ipaAbsPath, ipaDirectory);
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        // fetch app file name, after unzip ipa
        String appFileName = "";
        outer: for (File file : new File(ipaDirectory + "/Payload").listFiles()) {
            if (file.toString().endsWith(".app")) {
                appFileName = new File(file.toString()).getAbsolutePath();
                break outer;
            }
        }

        String plistFilePath = appFileName + "/Info.plist";
        // parse info.plist
        File plistFile = new File(plistFilePath);

        NSDictionary rootDict = null;
        try {
            rootDict = (NSDictionary) PropertyListParser.parse(plistFile);

            // get bundle id
            NSString parameter = (NSString) rootDict.objectForKey("CFBundleIdentifier");
            ipaInfo.put("BundleID", parameter.toString());

            // get application name
            parameter = (NSString) rootDict.objectForKey("CFBundleName");
            ipaInfo.put("BundleName", parameter.toString());

            // get version
            parameter = (NSString) rootDict.objectForKey("CFBundleShortVersionString");
            ipaInfo.put("Version", parameter.toString());

            // get ios mini. version
            parameter = (NSString) rootDict.objectForKey("MinimumOSVersion");
            ipaInfo.put("MinimumOSVersion", parameter.toString());

        } catch (IOException e) {
            System.out.println("---1 Error IOException----");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("---2 Error ParseException----");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("---3 Error SAXException----");
            e.printStackTrace();
        } catch (PropertyListFormatException e) {
            System.out.println("---4 Error PropertyListFormatException----");
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("---5 Error ParserConfigurationException----");
            e.printStackTrace();
        }

        // remove unzip folder
        try {
            FileManager.deleteDirectoryAtPath(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ipaInfo;
    }


}
