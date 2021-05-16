package com.app2u.app2udemo.features.artistlist.domain.usecase;

import android.util.Log;

import com.app2u.app2udemo.commons.domain.executor.JobScheduler;
import com.app2u.app2udemo.commons.domain.executor.UIScheduler;
import com.app2u.app2udemo.commons.domain.Usecase;
import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.data.repository.MainListRepository;

import io.reactivex.Single;
import retrofit2.Response;

public class ListUsecase extends Usecase<ApiPhotographerListModel> {
    private MainListRepository mainListRepository;


    public ListUsecase(MainListRepository mainListRepository, UIScheduler uiScheduler, JobScheduler jobScheduler) {
        super(uiScheduler, jobScheduler);
        this.mainListRepository = mainListRepository;
    }

    @Override
    public Single<ApiPhotographerListModel> buildUseCaseObservable() {
        return Single.create(emitter -> {
            try {
                Response<ApiPhotographerListModel> response = mainListRepository.getMainListResponse();
                if (response != null && response.isSuccessful()) {
                    ApiPhotographerListModel apiPhotographerListModel = response.body();
                    emitter.onSuccess(apiPhotographerListModel);
                } else {
                    Log.d("Usecase", "not successfull");
                    emitter.onError(new Exception());
                }
            } catch (Exception exception) {
                Log.d("Usecase", exception.getMessage());
                emitter.onError(exception);
            }
        });
    }
}
