package com.example.newsreaderapp.feature.home;

import android.content.Context;

import com.example.newsreaderapp.pojo.Example;
import com.example.newsreaderapp.rest_service.ApiObserver;
import com.example.newsreaderapp.rest_service.CustomObservableTransformer;
import com.example.newsreaderapp.rest_service.EventBus;
import com.example.newsreaderapp.rest_service.RestService;
import com.example.newsreaderapp.utils.Constants;

public class HomeRestService extends RestService {
    private final Context context;
    private final EventBus eventBus;
    HomeRestInterface restInterface;

    public HomeRestService(Context context, EventBus eventBus) {
        super(context,eventBus);
        this.context = context;
        this.eventBus = eventBus;
        restInterface = retrofit.create(HomeRestInterface.class);
    }

    public void getNews(){
        restInterface.getDetails()
                 .compose(CustomObservableTransformer.<Example>transformObservable())
                .subscribeWith(new ApiObserver<Example>(eventBus, Constants.REQUEST_CODE.NEWS_REQUEST));
    }
}
