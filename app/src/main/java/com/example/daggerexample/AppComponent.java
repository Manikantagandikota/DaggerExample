package com.example.daggerexample;

import com.example.daggerexample.module.AppModule;
import com.example.daggerexample.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}