package com.example.filestoreapi.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObject extends Response {

    @JsonProperty("data")
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
