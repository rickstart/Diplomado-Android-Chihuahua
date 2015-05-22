package com.mobintum.girlsapp.models;

import java.io.Serializable;

/**
 * Created by Rick on 22/05/15.
 */
public class Girl implements Serializable {

    private String name;
    private String urlWeb;
    private int photo;

    public Girl(String name, String urlWeb, int photo) {
        this.name = name;
        this.urlWeb = urlWeb;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
