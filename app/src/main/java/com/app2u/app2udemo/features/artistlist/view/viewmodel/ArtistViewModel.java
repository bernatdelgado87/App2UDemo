package com.app2u.app2udemo.features.artistlist.view.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.app2u.app2udemo.commons.view.viewmodel.CommonViewModel;
import com.app2u.app2udemo.commons.domain.executor.Observer;
import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;
import com.app2u.app2udemo.features.artistlist.domain.usecase.ListUsecase;

import java.util.List;

public class ArtistViewModel extends CommonViewModel {
    private ListUsecase listUsecase;
    private MutableLiveData<List<Photographer>> apiPhotographerMutableLiveData = new MutableLiveData<List<Photographer>>();
    private MutableLiveData<Photographer> photographerDetail = new MutableLiveData<Photographer>();

    public MutableLiveData<List<Photographer>> getApiPhotographerMutableLiveData() {
        return apiPhotographerMutableLiveData;
    }

    public MutableLiveData<Photographer> getPhotographerDetail() {
        return photographerDetail;
    }

    public void requestList() {
        screenState.setHasErrors(false);
        screenState.setIsLoading(true);
        addDisposable(listUsecase.execute(new ListObserver()));
    }

    class ListObserver extends Observer<List<Photographer>> {
        @Override
        public void onSuccess(List<Photographer> apiPhotographers) {
            screenState.setHasErrors(false);
            screenState.setIsLoading(false);
            apiPhotographerMutableLiveData.setValue(apiPhotographers);
        }

        @Override
        public void onError(Throwable exception) {
            screenState.setHasErrors(true);
            screenState.setIsLoading(false);
        }
    }

    public void setListUsecase(final ListUsecase listUsecase) {
        this.listUsecase = listUsecase;
    }
}
