package com.example.newsreaderapp.shared.presenter;

public interface Presenter {
    void onCreate();

    void onPostCreate();

    void onResume();

    void onPostResume();

    void onPause();

    void onDestroy();
}
