package com.example.anuragjewellers.model;

import com.google.gson.annotations.SerializedName;

public class Party {

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private String jewellerDetails;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(int code) {
        this.status = status;
    }

    public String getJewellerDetails() {
        return jewellerDetails;
    }

    public void setJewellerDetails(String jewellerDetails) {
        this.jewellerDetails = jewellerDetails;
    }
}
