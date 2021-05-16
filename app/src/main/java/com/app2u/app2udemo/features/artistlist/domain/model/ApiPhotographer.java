package com.app2u.app2udemo.features.artistlist.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPhotographer {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("guid")
    @Expose
    private String guid;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("is_removed")
    @Expose
    private boolean isremoved;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("facebook")
    @Expose
    private String facebook;

    @SerializedName("instagram")
    @Expose
    private String instagram;

    @SerializedName("webpage")
    @Expose
    private String webpage;


    public Integer getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isIsremoved() {
        return isremoved;
    }

    public String getDescription() {
        return description;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getImage() {
        return image;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getWebpage() {
        return webpage;
    }
}
