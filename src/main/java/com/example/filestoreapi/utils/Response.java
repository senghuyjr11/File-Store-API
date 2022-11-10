package com.example.filestoreapi.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
