package com.example.newsreaderapp.feature.home;


import android.util.Log;

import com.example.newsreaderapp.pojo.Example;
import com.example.newsreaderapp.rest_service.Event;
import com.example.newsreaderapp.rest_service.EventBus;
import com.example.newsreaderapp.rest_service.EventSubscriber;
import com.example.newsreaderapp.shared.presenter.PresenterStub;
import com.example.newsreaderapp.utils.Constants;

import javax.inject.Inject;

public class HomePresenter extends PresenterStub implements EventSubscriber {

    IHomeView iHomeView;

    @Inject
    HomeRestService homeRestService;

    @Inject
    EventBus eventBus;

    public HomePresenter(IHomeView homeView) {
        this.iHomeView = homeView;
    }

    @Override
    public void onEvent(Event event) {
        Log.v("onEvent", "Success");
        switch (event.getType()){
            case Event.TYPE_SUCCESS:
                Log.v("onEvent", "Success");
                if(event.getRequestCode() == Constants.REQUEST_CODE.NEWS_REQUEST){
                    iHomeView.setTempResult(event.getResult());
                }
                break;
            case Event.TYPE_COMPLETION:
                break;
            case Event.TYPE_ERROR:
                break;
        }
    }

    public void getNews() {
        homeRestService.getNews();
    }


    @Override
    public void onPostCreate() {
        Log.v("onEvent", "onPostCreate");
        eventBus.subscribe(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unsubsribe();
    }
}
