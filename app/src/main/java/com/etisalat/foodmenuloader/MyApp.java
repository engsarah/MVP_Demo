package com.etisalat.foodmenuloader;

import android.app.Application;
import android.content.Context;

/**
 * This class is responsible for providing application
 * context instance
 */
public class MyApp extends Application {
    private static MyApp instance;


    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }
        @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
