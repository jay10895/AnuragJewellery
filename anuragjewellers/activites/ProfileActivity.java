package com.example.anuragjewellers.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anuragjewellers.utils.FileUtility;
import com.example.anuragjewellers.utils.PrefManager;
import com.example.anuragjewellery.R;

import java.io.File;
import java.lang.reflect.Method;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ProfileActivity extends AppCompatActivity {

    ImageView back_arrow;
    ImageView image_profile;
    Button button_choose;
    TextView profile;
    TextView profile_phone;
    TextView profile_email;
    TextView changeProfilepassword;

    String image;
    String uname;
    String phone_number;
    String email;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prefManager = new PrefManager(this);

        back_arrow = findViewById(R.id.back_arrow);
        image_profile = findViewById(R.id.image_profile);
        button_choose = findViewById(R.id.button_choose);
        changeProfilepassword = findViewById(R.id.changeProfilepassword);

        profile = findViewById(R.id.profile);
        profile_phone = findViewById(R.id.profile_phone);
        profile_email = findViewById(R.id.profile_email);

        uname=  prefManager.getUsername();
        phone_number = prefManager.getmobile();
        email = prefManager.getemail();
        image = prefManager.getimage();

        profile.setText(uname);
        profile_phone.setText(phone_number);
        profile_email.setText(email);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        image_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,ProfileImageShow.class);
                startActivity(intent);
            }
        });

        button_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        Glide.with(ProfileActivity.this)  //2
                .load(image) //3
                .into(image_profile);

        changeProfilepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private ImagePickSetOnClickListner imageSetOnclickListner=new ImagePickSetOnClickListner() {
        @Override
        public void Camera(Uri uri) {                                      //Camera path mate
            // Log.d("TAG",filePath);
            final String path = FileUtility.getPath(ProfileActivity.this,uri);
            if (path != null)
            { File f = new File(path);
                image_profile.setImageURI(uri);

                prefManager.saveimage(path);
                Glide.with(ProfileActivity.this)  //2
                        .load(path) //3
                        .into(image_profile);
            }
        }
        @Override
        public void Gallary(Uri uri) {                                       //Gallery path mate
            final String path = FileUtility.getPath(ProfileActivity.this,uri);
            if (path != null)
            {
                File f = new File(path);
                image_profile.setImageURI(uri);


                prefManager.saveimage(path);
                Glide.with(ProfileActivity.this)  //2
                        .load(path) //3
                        .into(image_profile);
            }
        }
    };

    private void openDialog()
    {
        SelectBottomDialogFragment addPhotoBottomDialogFragment = new SelectBottomDialogFragment(ProfileActivity.this,"Image",imageSetOnclickListner);
        addPhotoBottomDialogFragment.show(getSupportFragmentManager(),"add_photo_dialog_fragment");
    }

    public static void disableException()
    {
        if(Build.VERSION.SDK_INT>=24)
        {
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

   /* @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}