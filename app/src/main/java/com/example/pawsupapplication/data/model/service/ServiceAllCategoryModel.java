package com.example.pawsupapplication.data.model.service;

public class ServiceAllCategoryModel {
    Integer id;
    Integer imageurl;

    public ServiceAllCategoryModel(Integer id, Integer imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }
}