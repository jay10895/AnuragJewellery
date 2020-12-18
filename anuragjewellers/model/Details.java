package com.example.anuragjewellers.model;


import com.google.gson.annotations.SerializedName;

public class Details {

    @SerializedName("displayname")
    private String displayname;

    @SerializedName("ID")
    private String ID;

    @SerializedName("email")
    private String email;
    @SerializedName("phone_number")
    private String phone_number;

    public Details(String displayname, String ID, String email, String phone_number) {
        this.displayname = displayname;
        this.ID = ID;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
