package com.example.anuragjewellers.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Angularjewellary", context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLoginDetails(String username, String password, boolean isLogin){                    //login details save karva
        editor.putString("Username", username);
        editor.putString("Password", password);
        editor.putBoolean("isLogin", isLogin);
        editor.commit();
        editor.apply();
    }

    public void saveRegisterDetails(String register_username, String phone_number, String email){               //register user details
        editor.putString("Username", register_username);
        editor.putString("Phone", phone_number);
        editor.putString("Email", email);
        editor.commit();
        editor.apply();
    }

    public String getimage()
    {
        return sharedPreferences.getString("Image", "");
    }

    public String getmobile()
    {
        return sharedPreferences.getString("Phone", "");
    }

    public String getemail()
    {
        return sharedPreferences.getString("Email", "");
    }


    public void saveVepariDetails(String vepari_username, String vepari_number, String vepari_city){               //Vepari user details
        editor.putString("Vepari Name", vepari_username);
        editor.putString("Vepari Number", vepari_number);
        editor.putString("Vepari City", vepari_city);
        editor.commit();
    }

    public String getVepariName(){
        return sharedPreferences.getString("Vepari Name","");
    }

    public String getVepariNumber(){
        return sharedPreferences.getString("Vepari Number","");
    }

    public String getVepariCity(){
        return sharedPreferences.getString("Vepari City","");
    }

    public void saveimage(String image){                     //image mate profile ni ne e
        editor.putString("Image", image);
        editor.commit();
        editor.apply();
    }




    public boolean isLogin()
    {
        return sharedPreferences.getBoolean("isLogin", false);
    }   //login

    public String getUsername()
    {
        return sharedPreferences.getString("Username", "");
    }

    public void saveUserDetail(String userDetail){
        editor.putString("UserDetail",userDetail);
        editor.commit();
        editor.apply();
    }
    public String getUserDetail()
    {
        return sharedPreferences.getString("UserDetail", "");
    }


    public void getSalesmanDetails(String register_salesman, String ID, String credit, String debit, String payment)
    {
        editor.putString("name", register_salesman);
        editor.putString("ID", ID);
        editor.putString("credit", credit);
        editor.putString("debit", debit);
        editor.putString("payment", payment);
    }
    public String getregister_salesman(){
        return sharedPreferences.getString("name","");
    }

    public String getId(){
        return sharedPreferences.getString("ID","");
    }
    public String getcredit(){
        return sharedPreferences.getString("credit","");
    }
    public String getdebit(){
        return sharedPreferences.getString("debit","");
    }
    public String getpayment(){
        return sharedPreferences.getString("payment","");
    }

    public boolean  isUserLogedOut() {
        editor.remove("Username");
        editor.remove("Password");
        editor.clear();
        editor.commit();
        boolean isUsernameEmpty = sharedPreferences.getString("Username", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isUsernameEmpty || isPasswordEmpty;
    }
}
