package com.example.newsreaderapp.shared.view.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newsreaderapp.shared.dependency_injection.DaggerPresenterComponent;
import com.example.newsreaderapp.shared.dependency_injection.PresenterComponent;
import com.example.newsreaderapp.shared.dependency_injection.PresenterModule;
import com.example.newsreaderapp.shared.presenter.Presenter;


public abstract class PresentedActivity<T extends Presenter> extends AppCompatActivity {
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        presenter.onCreate();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.onPostCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        presenter.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void inject() {
        presenter = onCreatePresenter();
//        PresenterComponent presenterComponent  = null;
        PresenterComponent  presenterComponent  =
                DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule(this))
                .build();

        injectPresenter(presenterComponent, presenter);
    }

    protected abstract T onCreatePresenter();

    protected abstract void injectPresenter(PresenterComponent presenterComponent, T presenter);
}
