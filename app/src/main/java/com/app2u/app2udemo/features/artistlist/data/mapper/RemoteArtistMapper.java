package com.app2u.app2udemo.features.artistlist.data.mapper;

import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographer;
import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;

import java.util.ArrayList;
import java.util.List;

public class RemoteArtistMapper {
    public static List<Photographer> mapToModel(ApiPhotographerListModel apiPhotographerListModel) {
        List<Photographer> photographerList = new ArrayList<>();
        for (ApiPhotographer apiPhotographer : apiPhotographerListModel.getPhotographerList()) {
            Photographer photographer = new Photographer();
            photographer.setId(apiPhotographer.getId());
            photographer.setFirstName(apiPhotographer.getFirstName());
            photographer.setLastName(apiPhotographer.getLastName());
            photographer.setImage(apiPhotographer.getImage());
            photographer.setDescription(apiPhotographer.getDescription());
            photographerList.add(photographer);
        }
        return photographerList;
    }
}
