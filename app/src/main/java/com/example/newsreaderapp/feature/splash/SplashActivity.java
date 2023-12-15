package com.example.newsreaderapp.feature.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsreaderapp.R;
import com.example.newsreaderapp.feature.home.HomeActivity;


public class SplashActivity extends AppCompatActivity implements SplashViewInterface {

    SplashPresenter splashPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPresenter = new SplashPresenter();
        splashPresenter.addSplashDelay(this);
    }

    @Override
    public void startActivity() {
        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }
}
