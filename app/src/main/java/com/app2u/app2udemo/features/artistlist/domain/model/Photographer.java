package com.app2u.app2udemo.features.artistlist.domain.model;

public class Photographer {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String description;
    private String image;
    private String facebook;
    private String instagram;
    private String webpage;

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
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

    public String getDescription() {
        return description;
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
