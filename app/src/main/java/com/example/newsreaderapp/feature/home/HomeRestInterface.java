package com.example.newsreaderapp.feature.home;

import com.example.newsreaderapp.pojo.Example;
import com.example.newsreaderapp.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HomeRestInterface {

    @GET("top-headlines?country=us&apiKey="+ Constants.API_KEY.KEY)
    Observable<Example> getDetails();
}
