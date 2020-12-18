package com.example.anuragjewellers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalesManData {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("ID")
    @Expose
    private int ID;

    @SerializedName("credit")
    @Expose
    private String credit;

    @SerializedName("debit")
    @Expose
    private String debit;


    @SerializedName("payment")
    @Expose
    private String payment;

    @SerializedName("phone_number")
    @Expose
    private String phone_number;

    @SerializedName("date")
    @Expose
    private String date;


    public SalesManData(String name, int ID, String credit, String debit, String payment,String phone_number,String date) {
        this.name = name;
        this.ID = ID;
        this.credit = credit;
        this.debit = debit;
        this.payment = payment;
        this.phone_number=phone_number;
        this.date=date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getID() {
        return ID;
    }



    public String getCredit() {
        return credit;
    }

    public String getDebit() {
        return debit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
