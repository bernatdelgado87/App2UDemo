package com.app2u.app2udemo.features.artistlist.data.mapper;

import com.app2u.app2udemo.features.artistlist.data.model.local.DataModalPhotographer;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;

import java.util.ArrayList;
import java.util.List;

public class LocalArtistMapper {
    public static List<Photographer> mapToModel(List<DataModalPhotographer> dataModalPhotographerList) {
        List<Photographer> photographerList = new ArrayList<>();
        for (DataModalPhotographer dataModalPhotographer : dataModalPhotographerList){
            Photographer photographer = new Photographer();
            photographer.setFirstName(dataModalPhotographer.getFirstName());
            photographer.setLastName(dataModalPhotographer.getLastName());
            photographer.setImage(dataModalPhotographer.getImageUrl());
            photographer.setDescription(dataModalPhotographer.getDescription());
            photographerList.add(photographer);
            }
        return photographerList;
    }

    public static List<DataModalPhotographer> mapFromModel(List<Photographer> photographers) {
        List<DataModalPhotographer> photographerList = new ArrayList<>();
        for (Photographer photographer : photographers) {
            DataModalPhotographer dataModalPhotographer = new DataModalPhotographer();
            dataModalPhotographer.setId(photographer.getId());
            dataModalPhotographer.setFirstName(photographer.getFirstName());
            dataModalPhotographer.setLastName(photographer.getLastName());
            dataModalPhotographer.setImageUrl(photographer.getImage());
            dataModalPhotographer.setDescription(photographer.getDescription());
            photographerList.add(dataModalPhotographer);
        }
        return photographerList;
    }

}
