package com.app2u.app2udemo.commons.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final DaggerApplication application;

    public AppModule(DaggerApplication application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationContext() {
        return this.application;
    }
}


