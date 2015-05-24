package com.mobintum.maincity.models;

import java.io.Serializable;

/**
 * Created by Rick on 24/05/15.
 */
public class City implements Serializable{
    private double latitude;
    private double longitude;
    private String nameCity;
    private String pictureUrl;

    public City(double latitude, double longitude, String nameCity, String pictureUrl) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameCity = nameCity;
        this.pictureUrl = pictureUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
