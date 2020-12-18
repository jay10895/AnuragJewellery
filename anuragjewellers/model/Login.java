package com.example.anuragjewellers.model;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private Details details;

    @SerializedName("cookie")
    private String cookie;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
