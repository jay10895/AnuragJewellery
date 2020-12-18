package com.example.anuragjewellers;

import android.app.Application;

import com.example.anuragjewellery.R;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class AppController extends Application {

    private static AppController instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance=this;
     /*   CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Aller_Bd.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()

                                .setDefaultFontPath("fonts/Aller_Bd.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }
    public static AppController getInstance()
    {
        return instance;
    }
}
