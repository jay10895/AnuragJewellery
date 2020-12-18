package com.example.anuragjewellers.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.anuragjewellers.utils.PrefManager;
import com.example.anuragjewellery.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SplashActivity extends AppCompatActivity {

    ImageView splashImage;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashImage = findViewById(R.id.splash_image);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        splashImage.startAnimation(myanim);
        CheckPermission();
        prefManager = new PrefManager(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (prefManager.isLogin()) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 8000);
    }

    private boolean check(Context context)
    {
        boolean isExternalStorage=false,isCamera=false,isAccessNetwork=false;

        int resultforExternal = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(resultforExternal== PackageManager.PERMISSION_GRANTED)
        {
            isExternalStorage=true;
        }
        int resultforCamera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
        if(resultforCamera== PackageManager.PERMISSION_GRANTED)
        {
            isCamera=true;
        }
        int resultAccessNetwork = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE);
        if(resultAccessNetwork== PackageManager.PERMISSION_GRANTED)
        {
            isAccessNetwork=true;
        }
        if(!isExternalStorage || !isCamera || !isAccessNetwork )
        {
            ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA, Manifest.permission.ACCESS_NETWORK_STATE}, 1);
            return false;
        }
        else
        {
            if(isExternalStorage && isCamera &&  isAccessNetwork)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        CheckPermission();
    }

    public boolean CheckPermission()
    {
        if(check(this))
        {
            new Thread()
            {
                @Override
                public void run()
                {
                    synchronized (this)
                    {
                        try
                        {
                            wait(3000);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    try
                    {

                    }
                    catch (Exception e)
                    {
                    }
                }
            }.start();

        }
        else
        {
            return false;
        }
        return false;
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