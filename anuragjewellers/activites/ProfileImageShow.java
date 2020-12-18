package com.example.anuragjewellers.activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.anuragjewellers.utils.PrefManager;
import com.example.anuragjewellery.R;

public class ProfileImageShow extends AppCompatActivity {
    ImageView imageView;
    ImageView dialogButton;
    SharedPreferences sharedPreferences;
    Context context;
    String image;
    Toolbar toolbar;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);

        prefManager = new PrefManager(this);


        toolbar = findViewById(R.id.toolbar_image);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        imageView = findViewById(R.id.imageview);
        dialogButton = findViewById(R.id.backbutton);


        //sharedPreferences = getSharedPreferences("MySharedPref", context.MODE_PRIVATE);
        image = prefManager.getimage();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(ProfileImageShow.this, ProfileActivity.class);
                finish();
            }
        });

        Glide.with(ProfileImageShow.this)  //2
                .load(image) //3
                .into(imageView);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
