package com.example.newsreaderapp.rest_service;

public interface EventBus {
    void subscribe(EventSubscriber subscriber);

    void unsubsribe();

    void onNext(Event event);

    void onError(Event event);

    void onCompletion(Event event);

}
