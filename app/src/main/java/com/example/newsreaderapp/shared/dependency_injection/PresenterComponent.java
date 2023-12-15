package com.example.newsreaderapp.shared.dependency_injection;


import com.example.newsreaderapp.rest_service.EventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {
    EventBus getEventBus();
}
