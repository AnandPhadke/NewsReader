package com.example.newsreaderapp.feature.home;

import android.app.Activity;

import com.example.newsreaderapp.rest_service.EventBus;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    private Activity activity;

    public HomeModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    HomeRestService getHomeRestService(EventBus eventBus){
        return new HomeRestService(activity, eventBus);
    }
}
