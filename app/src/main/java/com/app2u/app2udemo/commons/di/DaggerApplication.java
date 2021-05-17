package com.app2u.app2udemo.commons.di;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DaggerApplication extends Application {
    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
        initRealmDatabase();
    }

    private void initRealmDatabase(){
        Realm.init(this);
        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .allowWritesOnUiThread(true)
                        .deleteRealmIfMigrationNeeded()
                        .build();
        Realm.setDefaultConfiguration(config);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
