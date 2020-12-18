package com.example.anuragjewellers.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.anuragjewellery.R;

public class EditDeleteSalesmanActivity extends AppCompatActivity {

    EditText userid,username,mobile,email;
    Button editBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_salesman);
        userid = (EditText) findViewById(R.id.edit_userid);
        username = (EditText) findViewById(R.id.edit_username);
        mobile = (EditText) findViewById(R.id.edit_mobile);
        email = (EditText) findViewById(R.id.edit_email);

        editBtn=(Button)findViewById(R.id.edit_btn);
        deleteBtn =(Button) findViewById(R.id.delete_btn);


        userid.setEnabled(false);
        username.setEnabled(false);
        mobile.setEnabled(false);
        email.setEnabled(false);

    }
}