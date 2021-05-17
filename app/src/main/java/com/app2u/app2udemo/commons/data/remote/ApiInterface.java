package com.app2u.app2udemo.commons.data.remote;

import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographerListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {
    @Headers({"Accept: application/json"})
    @GET("/api/photographer")
    Call<ApiPhotographerListModel> getList();

}
