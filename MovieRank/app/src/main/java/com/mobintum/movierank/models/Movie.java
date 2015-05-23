package com.mobintum.movierank.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Rick on 23/05/15.
 */
public class Movie implements Serializable{

    private String title;
    private int year;
    private String runtime;
    private Rating rating;
    private String synopsis;
    private String posterUrl;
    private ArrayList<Actor> casting;

    public Movie(String title, int year, String runtime, Rating rating, String synopsis, String posterUrl, ArrayList<Actor> casting) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.rating = rating;
        this.synopsis = synopsis;
        this.posterUrl = posterUrl;
        this.casting = casting;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public ArrayList<Actor> getCasting() {
        return casting;
    }

    public void setCasting(ArrayList<Actor> casting) {
        this.casting = casting;
    }

    public static ArrayList<Movie> parseJson(String response){
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray arrayMovies = jsonObject.getJSONArray("movies");

            for(int i=0; i<arrayMovies.length();i++){

                JSONObject jsonMovie = arrayMovies.getJSONObject(i);
                String title = jsonMovie.optString("title", "title default");
                int year = jsonMovie.optInt("year", 0) ;
                String runtime = jsonMovie.optString("runtime","0 minutes");
                String synopsis = jsonMovie.optString("synopsis","default");

                JSONObject jsonPoster = jsonMovie.getJSONObject("posters");
                String posterUrl = jsonPoster.getString("thumbnail");

                JSONObject jsonRaiting = jsonMovie.getJSONObject("ratings");
                int criticsScore = jsonRaiting.optInt("critics_score", 0);
                int audienceScore = jsonRaiting.optInt("audience_score",0);
                Rating rating = new Rating(criticsScore,audienceScore);

                ArrayList<Actor> casting = new ArrayList<Actor>();
                JSONArray arrayCast = jsonMovie.getJSONArray("abridged_cast");

                for(int j=0; j<arrayCast.length();j++){
                    JSONObject jsonActor = arrayCast.getJSONObject(j);
                    String name = jsonActor.getString("name");
                    Actor actor = new Actor(name);
                    casting.add(actor);
                }

                Movie movie = new Movie(title,year,runtime,rating,synopsis,posterUrl,casting);

                movies.add(movie);

            }



        }catch(Exception e){
            e.printStackTrace();
        }

        return movies;
    }
}
