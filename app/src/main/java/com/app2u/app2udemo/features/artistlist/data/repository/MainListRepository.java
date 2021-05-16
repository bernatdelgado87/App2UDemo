package com.app2u.app2udemo.features.artistlist.data.repository;

import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographerListModel;

import retrofit2.Response;

public interface MainListRepository {
    Response<ApiPhotographerListModel> getMainListResponse() throws Exception;
}
