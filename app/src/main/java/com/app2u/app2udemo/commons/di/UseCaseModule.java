package com.app2u.app2udemo.commons.di;

import com.app2u.app2udemo.commons.domain.executor.JobScheduler;
import com.app2u.app2udemo.commons.domain.executor.JobThread;
import com.app2u.app2udemo.commons.domain.executor.UIScheduler;
import com.app2u.app2udemo.commons.domain.executor.UIThread;
import com.app2u.app2udemo.features.artistlist.domain.usecase.ListUsecase;
import com.app2u.app2udemo.features.artistlist.data.repository.MainListRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {
    private ListUsecase listUsecase;

    @Provides
    public JobScheduler provideJobScheduler(JobThread jobThread) {
        return jobThread;
    }

    @Provides
    public UIScheduler provideUIScheduler(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    public ListUsecase provideRegisterUseCaseFactory(MainListRepository registerRepository, UIScheduler uiScheduler, JobScheduler jobScheduler) {
        if (listUsecase == null) {
            listUsecase = new ListUsecase(registerRepository, uiScheduler, jobScheduler);
        }
        return listUsecase;
    }

}
