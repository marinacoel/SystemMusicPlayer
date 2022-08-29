package model;

import java.util.ArrayList;

public class Album {
    private String title;
    private int releaseYear;
    private String band;  
    private ArrayList<Song> songList;

    public Album() {
        songList = new ArrayList<Song>();
    }

    public Album(String title, int releaseYear, String band, ArrayList<Song> songList) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.band = band;
        this.songList = songList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {

        String about = title + " (" + releaseYear + ") - " + band;
        return about;
    }
}
