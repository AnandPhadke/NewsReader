package com.example.newsreaderapp.rest_service;


import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class RxBus implements EventBus {

    private final Subject<Event> subject = PublishSubject.create();
    private final CompositeDisposable disposable = new CompositeDisposable();


    @Override
    public void subscribe(final EventSubscriber subscriber) {
        subject.subscribe(new Observer<Event>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(getClass().getName(),"onSubscribe");
                disposable.add(d);
            }

            @Override
            public void onNext(Event event) {
                Log.v(getClass().getName(),"onNext in subject");
                try {
                    subscriber.onEvent(event);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.v(getClass().getName(),"onError   "+e.toString());
                subscriber.onEvent(new ErrorEvent(e));
                e.printStackTrace();
            }
            @Override
            public void onComplete() {
                Log.v(getClass().getName(),"onComplete");
            }
        });
    }

    @Override
    public void unsubsribe() {
        Log.v(getClass().getName(),"unsubsribe");
    }

    @Override
    public void onNext(Event event) {
        Log.v(getClass().getName(),"onNext"+event);
        subject.onNext(event);
    }

    @Override
    public void onError(Event event) {
        Log.v(getClass().getName(),"onError"+event);
        subject.onError(event.getResult());
    }

    @Override
    public void onCompletion(Event event) {
        Log.v(getClass().getName(),"onCompletion"+event);
        subject.onComplete();
    }
}
