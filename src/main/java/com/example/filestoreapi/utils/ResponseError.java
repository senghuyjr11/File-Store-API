package com.example.filestoreapi.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseError {
    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;
}
