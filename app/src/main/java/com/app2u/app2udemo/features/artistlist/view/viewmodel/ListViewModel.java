package com.app2u.app2udemo.features.artistlist.view.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.app2u.app2udemo.commons.view.viewmodel.CommonViewModel;
import com.app2u.app2udemo.commons.domain.executor.Observer;
import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.domain.usecase.ListUsecase;

public class ListViewModel extends CommonViewModel {
    private ListUsecase listUsecase;
    private MutableLiveData<ApiPhotographerListModel> apiPhotographerMutableLiveData = new MutableLiveData<ApiPhotographerListModel>();

    public MutableLiveData<ApiPhotographerListModel> getApiPhotographerMutableLiveData() {
        return apiPhotographerMutableLiveData;
    }

    public void requestList() {
        addDisposable(listUsecase.execute(new ListObserver()));
    }

    class ListObserver extends Observer<ApiPhotographerListModel> {
        @Override
        public void onSuccess(ApiPhotographerListModel apiPhotographer) {
            apiPhotographerMutableLiveData.setValue(apiPhotographer);
        }

        @Override
        public void onError(Throwable exception) {
            //todo implement error view
        }
    }

    public void setListUsecase(final ListUsecase listUsecase) {
        this.listUsecase = listUsecase;
    }
}
