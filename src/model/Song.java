package model;

import java.time.Duration;

public class Song {

    private String title;
    private Duration duration;
    private Boolean favorite;
    
    public Boolean isFavorite() {
        return favorite;
    }
    public Song(){   
    }

    public Song(String title, Duration duration, Boolean favorite) {
        this.title = title;
        this.duration = duration;
        this.favorite = favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Duration getDuration() {
        return duration;
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {

        DurationUtil durConverter = new DurationUtil();
        
        String about = title + "  ["+ durConverter.DurationToStringFormat(duration) + "]  ";

        if(favorite){
            about = about.concat("FAVORITE!");
        }

        return about;
    }
}
