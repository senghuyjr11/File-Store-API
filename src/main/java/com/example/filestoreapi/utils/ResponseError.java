package com.example.filestoreapi.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseError {
    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;
}
