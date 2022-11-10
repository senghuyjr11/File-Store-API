package com.example.filestoreapi.enums;

public enum Status {
    TRUE(true),
    FALSE(false);

    private final boolean value;

    Status(boolean value){
        this.value = value;
    }

    public boolean value(){
        return this.value;
    }
}