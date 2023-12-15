package com.example.newsreaderapp.feature.splash;


import android.os.Handler;

public class SplashPresenter {
    private static final long SPLASH_DELAY = 1000;

    public void addSplashDelay(final SplashViewInterface splashViewInterface) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashViewInterface.startActivity();
            }
        },SPLASH_DELAY);
    }
}
