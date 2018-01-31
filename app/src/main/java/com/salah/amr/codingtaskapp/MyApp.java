package com.salah.amr.codingtaskapp;

import android.app.Application;
import android.content.Context;

import com.salah.amr.codingtaskapp.dagger.AppComponent;
import com.salah.amr.codingtaskapp.dagger.AppModule;
import com.salah.amr.codingtaskapp.dagger.DaggerAppComponent;

/**
 * Created by Amr Salah on 1/31/2018.
 */

public class MyApp extends Application {
    private static MyApp instance;
    private static AppComponent component;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
        // or return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;
        component = DaggerAppComponent.builder().appModule(new AppModule(instance)).build();
        component.inject(this);
        super.onCreate();
    }

    public static AppComponent getComponent(){
        return component;
    }



}