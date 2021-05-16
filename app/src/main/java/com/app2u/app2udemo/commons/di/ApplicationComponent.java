package com.app2u.app2udemo.commons.di;

import com.app2u.app2udemo.features.artistlist.view.activity.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class, UseCaseModule.class, RepositoryModule.class})

public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

}
