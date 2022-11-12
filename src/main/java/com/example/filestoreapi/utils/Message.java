package com.example.filestoreapi.utils;

public class Message {

    public String getFoundSuccess(String tableName) {
        return tableName + " have found successfully.";
    }

    public String getFailNotFound(String tableName)
    {
        return tableName + " not found.";
    }

    public String insertSuccess(String tableName)
    {
        return tableName + " has inserted successfully.";
    }

    public String insertFail(String tableName)
    {
        return tableName + " failed to inserted.";
    }

    public String deleteSuccess(String tableName)
    {
        return tableName + " has deleted successfully.";
    }

    public String deleteFail(String tableName)
    {
        return tableName + " failed to delete.";
    }

    public String updateSuccess(String tableName)
    {
        return tableName + " has updated successfully";
    }

    public String updateFail(String tableName)
    {
        return tableName + " failed to update.";
    }

    public String loginSuccess(){
        return  "Login Success";
    }

    public String loginFail(){
        return "Wrong username and password";
    }

    public String uploadSuccess(){return "Upload success.";}

    public String uploadFail(){return "failed to upload.";}

    public String notAllow(){return "Unauthorized : Your role not allow to do this action!!";}

    public String alreadyExist(String tableName){return tableName+ " is already exists!!";}

    public String notExist(String tableName){return tableName+ " is not exists!!";}

    public String idNoFound(String idName){return idName+ " not found.";}

    public String changePassword() {
        return "Password has changed successfully.";
    }

    public String wrongEmail() {
        return "Wrong Email!";
    }

    public String wrongRecoveryCode() {
        return "Wrong recovery code!";
    }

    public String emailSuccess() {
        return "Email has sent successfully.";
    }

    public String emailError() {
        return "Email has sent error!";
    }

}
