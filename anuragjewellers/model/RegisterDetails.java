package com.example.anuragjewellers.model;

import com.google.gson.annotations.SerializedName;

public class RegisterDetails {

    @SerializedName("role")
    private String role;
    public RegisterDetails(String username, String email, String password, String confirm_password, String phone_number, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.phone_number = phone_number;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("confirm_password")
    private String confirm_password;

    @SerializedName("phone_number")
    private String phone_number;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
