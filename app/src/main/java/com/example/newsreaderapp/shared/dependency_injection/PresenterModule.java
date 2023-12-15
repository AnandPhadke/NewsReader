package com.example.newsreaderapp.shared.dependency_injection;



import android.app.Activity;


import androidx.appcompat.app.AppCompatActivity;

import com.example.newsreaderapp.rest_service.EventBus;
import com.example.newsreaderapp.rest_service.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    private AppCompatActivity activity;
    public PresenterModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Singleton
    @Provides
    EventBus getEventBus() {
        return new RxBus();
    }
}
