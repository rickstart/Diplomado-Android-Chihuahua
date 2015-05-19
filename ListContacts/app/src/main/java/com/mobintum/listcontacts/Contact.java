package com.mobintum.listcontacts;

import java.io.Serializable;

/**
 * Created by Rick on 18/05/15.
 */
public class Contact implements Serializable {

    private String name;
    private String company;
    private String city;
    private String phone;
    private String email;
    private String github;
    private String twitter;
    private int photo;

    public Contact(String name, String company, String city, String phone, String email, String github, String twitter, int photo) {
        this.name = name;
        this.company = company;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.github = github;
        this.twitter = twitter;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
