package com.app2u.app2udemo.features.artistlist.domain.usecase;

import com.app2u.app2udemo.commons.domain.Usecase;
import com.app2u.app2udemo.commons.domain.executor.JobScheduler;
import com.app2u.app2udemo.commons.domain.executor.UIScheduler;
import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.data.repository.MainListRepository;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;

import java.util.List;

import io.reactivex.Single;
import io.realm.Realm;
import retrofit2.Response;

import static com.app2u.app2udemo.features.artistlist.data.mapper.LocalArtistMapper.mapFromModel;
import static com.app2u.app2udemo.features.artistlist.data.mapper.LocalArtistMapper.mapToModel;
import static com.app2u.app2udemo.features.artistlist.data.mapper.RemoteArtistMapper.mapToModel;

public class ListUsecase extends Usecase<List<Photographer>> {
    private MainListRepository mainListRepository;

    public ListUsecase(MainListRepository mainListRepository, UIScheduler uiScheduler, JobScheduler jobScheduler) {
        super(uiScheduler, jobScheduler);
        this.mainListRepository = mainListRepository;
    }

    @Override
    public Single<List<Photographer>> buildUseCaseObservable() {
        return Single.create(emitter -> {
            List<Photographer> localResult = mapToModel(mainListRepository.getPhotographerListFromLocal());
            if (localResult != null && localResult.size() > 0) {
                emitter.onSuccess(localResult);
            } else {
                try {
                    List<Photographer> photographerList = getListFromRemote();
                    mainListRepository.saveArtistListToDatabase(mapFromModel(photographerList));
                    emitter.onSuccess(photographerList);
                } catch (Exception exception) {
                    emitter.onError(exception);
                }
            }
        });
    }

    private List<Photographer> getListFromRemote() throws Exception {
        Response<ApiPhotographerListModel> response = mainListRepository.getMainListResponse();
        return mapToModel(response.body());
    }

    public void clearLocalDatabase() {
        Realm.getDefaultInstance().deleteAll();
    }
}
