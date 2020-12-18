package com.example.anuragjewellers.model;

import com.google.gson.annotations.SerializedName;

public class Register {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String registerDetails;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRegisterDetails() {
        return registerDetails;
    }

    public void setRegisterDetails(String registerDetails) {
        this.registerDetails = registerDetails;
    }
}
