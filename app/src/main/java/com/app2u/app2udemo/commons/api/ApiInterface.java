package com.app2u.app2udemo.commons.api;

import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographer;
import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographerListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {
    @Headers({"Accept: application/json"})
    @GET("/api/photographer")
    Call<ApiPhotographerListModel> getList();

}
