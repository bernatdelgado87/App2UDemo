package com.app2u.app2udemo.features.artistlist.data.repository.impl;

import com.app2u.app2udemo.commons.data.local.RealmHelper;
import com.app2u.app2udemo.commons.data.remote.ApiUtils;
import com.app2u.app2udemo.features.artistlist.data.model.local.DataModalPhotographer;
import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.data.repository.MainListRepository;

import java.util.List;

import retrofit2.Response;

import static com.app2u.app2udemo.commons.data.local.RealmHelper.addDataToDatabase;

public class MainListRespositoryImpl implements MainListRepository {
    @Override
    public Response<ApiPhotographerListModel> getMainListResponse() throws Exception {
        Response<ApiPhotographerListModel> response = null;
        try {
            response = ApiUtils.getServiceClient()
                    .getList()
                    .execute();
        } catch (Exception e) {
            throw new Exception(e);
        }
        if (response != null && !response.isSuccessful()) {
            throw new Exception();
        }
        return response;
    }

    @Override
    public void saveArtistListToDatabase(List<DataModalPhotographer> dataModalPhotographerList) {
        addDataToDatabase(dataModalPhotographerList);

    }

    @Override
    public List<DataModalPhotographer> getPhotographerListFromLocal() {
        return RealmHelper.getAllPhotographers();
    }

}
