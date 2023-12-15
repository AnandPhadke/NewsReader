package com.example.newsreaderapp.feature.home;



import com.example.newsreaderapp.shared.dependency_injection.PresenterComponent;
import com.example.newsreaderapp.shared.dependency_injection.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = PresenterComponent.class, modules = HomeModule.class)
public interface HomeComponent {
    void inject (HomePresenter presenter);
}
