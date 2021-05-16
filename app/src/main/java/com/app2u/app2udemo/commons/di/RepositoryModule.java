package com.app2u.app2udemo.commons.di;

import com.app2u.app2udemo.features.artistlist.data.repository.MainListRepository;
import com.app2u.app2udemo.features.artistlist.data.repository.impl.MainListRespositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    MainListRepository mainListRepository;

    @Provides
    public MainListRepository provideRegisterRepository() {
        if (mainListRepository == null) {
            mainListRepository = new MainListRespositoryImpl();
        }
        return mainListRepository;
    }
}
