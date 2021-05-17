package com.app2u.app2udemo.features.artistlist.data.model.local;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataModalPhotographer extends RealmObject {
    @PrimaryKey
    private long id;

    private String firstName;
    private String lastName;
    private String imageUrl;
    private String description;

    public DataModalPhotographer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
