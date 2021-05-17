package com.app2u.app2udemo.features.artistlist.data.repository;

import com.app2u.app2udemo.features.artistlist.data.model.local.DataModalPhotographer;
import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographerListModel;

import java.util.List;

import retrofit2.Response;

public interface MainListRepository {
    Response<ApiPhotographerListModel> getMainListResponse() throws Exception;

    void saveArtistListToDatabase(List<DataModalPhotographer> dataModalPhotographerList);

    List<DataModalPhotographer> getPhotographerListFromLocal();
}
