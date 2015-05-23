package com.mobintum.movierank.models;

/**
 * Created by Rick on 23/05/15.
 */
public class Rating {

    private int criticScore;
    private int audienceScore;

    public Rating(int criticScore, int audienceScore) {
        this.criticScore = criticScore;
        this.audienceScore = audienceScore;
    }

    public int getCriticScore() {
        return criticScore;
    }

    public void setCriticScore(int criticScore) {
        this.criticScore = criticScore;
    }

    public int getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(int audienceScore) {
        this.audienceScore = audienceScore;
    }
}
