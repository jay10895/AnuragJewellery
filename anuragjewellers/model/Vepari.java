package com.example.anuragjewellers.model;

import com.google.gson.annotations.SerializedName;

public class Vepari {

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private Details details;


    public boolean getStatus() {
        return status;
    }

    public void setCode(int code) {
        this.status = status;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

}
