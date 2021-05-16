package com.app2u.app2udemo.features.artistlist.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPhotographerListModel {
    @SerializedName("count")
    @Expose
    public Integer size;

    @SerializedName("next")
    @Expose
    public String nextKey;

    @SerializedName("results")
    @Expose
    public List<ApiPhotographer> photographerList;

    public Integer getSize() {
        return size;
    }

    public String getNextKey() {
        return nextKey;
    }

    public List<ApiPhotographer> getPhotographerList() {
        return photographerList;
    }
}
