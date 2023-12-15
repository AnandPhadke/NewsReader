package com.example.newsreaderapp.rest_service;

import io.reactivex.observers.DisposableObserver;

/**
 * Disposable is used to dispose the subscription when an Observer no longer wants to listen to
 * Observable. In android disposable are very useful in avoiding memory leaks.
    Let’s say you are making a long running network call and updating the UI. By the time network
    call completes its work, if the activity / fragment is already destroyed,
    as the Observer subscription is still alive, it tries to update already destroyed activity.
    In this case it can throw a memory leak. So using the Disposables, the un-subscription can be
    when the activity is destroyed.
 * @param <T>
 */
public class ApiObserver<T> extends DisposableObserver<T> {

    private final EventBus eventBus;
    private final int requestCode;

    public ApiObserver(EventBus eventBus, int requestCode) {
        this.eventBus = eventBus;
        this.requestCode = requestCode;
    }

    @Override
    public void onNext(T t) {
        eventBus.onNext(new SuccessEvent<T>(t,requestCode));
    }

    @Override
    public void onError(Throwable e) {
        eventBus.onError(new ErrorEvent(e,requestCode));
    }

    @Override
    public void onComplete() {
        eventBus.onCompletion(new CompletionEvent(requestCode));
    }
}
