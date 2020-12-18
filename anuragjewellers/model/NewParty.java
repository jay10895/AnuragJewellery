package com.example.anuragjewellers.model;

import com.google.gson.annotations.SerializedName;

public class NewParty {
    @SerializedName("user_id")
    private String user_id;

    @SerializedName("salesman_id")
    private String salesman_id;

    @SerializedName("name")
    private String name;

    @SerializedName("city")
    private String city;

    @SerializedName("number")
    private String number;

    public NewParty(String user_id,String salesman_id,String name,String city,String number)
    {
        this.user_id = user_id;
        this.salesman_id = salesman_id;
        this.name = name;
        this.city = city;
        this.number = number;
    }

    public String getUser_id(){return user_id;}

    public void setUser_id(String user_id){this.user_id=user_id;}

    public String getSalesman_id(){return salesman_id;}

    public void setSalesman_id(String salesman_id){this.salesman_id=salesman_id;}

    public String getName(){return name;}

    public void setName(String name){this.name=name;}

    public String getCity(){return city;}

    public void setCity(String city){this.city=city;}

    public String getNumber(){return number;}

    public void setNumber(String number){this.number=number;}
}
