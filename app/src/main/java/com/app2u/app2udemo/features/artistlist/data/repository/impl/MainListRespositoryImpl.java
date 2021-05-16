package com.app2u.app2udemo.features.artistlist.data.repository.impl;

import android.util.Log;

import com.app2u.app2udemo.commons.api.ApiUtils;
import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.data.repository.MainListRepository;

import retrofit2.Response;

public class MainListRespositoryImpl implements MainListRepository {
    @Override
    public Response<ApiPhotographerListModel> getMainListResponse() throws Exception {
        Response<ApiPhotographerListModel> response = null;
        try {
            response = ApiUtils.getServiceClient()
                    .getList()
                    .execute();
        } catch (Exception e) {
            Log.e("repository", e.getMessage());
            throw new Exception(e);
        }
        if (response != null && !response.isSuccessful()) {
            Log.e("repository", "not successfull");
            throw new Exception();
        }
        return response;
    }
}
