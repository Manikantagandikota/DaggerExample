package com.example.daggerexample;

import android.app.Application;

import com.example.daggerexample.module.AppModule;
import com.example.daggerexample.module.NetworkModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://simplifiedcoding.net/demos/"))
                .build();
    }

    public AppComponent getNetworkComponent() {
        return appComponent;
    }
}