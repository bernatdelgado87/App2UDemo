package com.app2u.app2udemo.commons.di;

import android.app.Application;

public class DaggerApplication extends Application {
    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
