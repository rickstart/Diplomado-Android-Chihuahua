package com.mobintum.musicplayer;

/**
 * Created by Rick on 20/05/15.
 */
public class Song {

    private String title;
    private String artist;
    private String album;
    private String fileName;
    private int albumPoster;

    public Song(String title, String artist, String album, String fileName, int albumPoster) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.fileName = fileName;
        this.albumPoster = albumPoster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getAlbumPoster() {
        return albumPoster;
    }

    public void setAlbumPoster(int albumPoster) {
        this.albumPoster = albumPoster;
    }
}
