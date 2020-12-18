package com.example.anuragjewellers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class For_AddVepari {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("ID")
    @Expose
    private String ID;

    public For_AddVepari(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getID() {
        return ID;
    }

    public void setID(String  ID) {
        this.ID = ID;
    }
}
