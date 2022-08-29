package model;

import java.util.ArrayList;

public class Database {

    private ArrayList<Song> songList;
    private ArrayList<Album> albumList;

    public Database(){
        this.songList = new ArrayList<Song>();
        this.albumList = new ArrayList<Album>();
    }

    public ArrayList<Song> getAllSongsList(){
        ArrayList<Song> copy = new ArrayList<Song>(songList);

        return copy;
    }

    public ArrayList<Song> getFavoriteSongsList(){
        ArrayList<Song> results = new ArrayList<Song>();

        for(Song song : songList){
            if(song.isFavorite()){
                results.add(song);
            }
        }
        return results;
    }

    public ArrayList<Song> getNotFavoriteSongsList(){
        ArrayList<Song> results = new ArrayList<Song>();

        for(Song song : songList){
            if(!song.isFavorite()){
                results.add(song);
            }
        }
        return results;
    }

    public void registerSong(Song song){
        songList.add(song);
    }

    public void registerAlbum(Album album){
        albumList.add(album);
    }
    
    public ArrayList<Album> searchAlbunsForTitle(String title){

        ArrayList<Album> results = new ArrayList<Album>();

        for(Album album : albumList){
            if(album.getTitle().equalsIgnoreCase(title)){
                results.add(album);
            }
        }
        return results;
    }

    public ArrayList<Album> searchAlbunsForReleaseYear(int releaseYear){

        ArrayList<Album> results = new ArrayList<Album>();

        for(Album album : albumList){
            if(album.getReleaseYear() == releaseYear){
                results.add(album);
            }
        }
        return results;
    }

    public ArrayList<Album> searchAlbunsForBand(String band){

        ArrayList<Album> results = new ArrayList<Album>();

        for(Album album : albumList){
            if(album.getBand().equalsIgnoreCase(band)){
                results.add(album);
            }
        }
        return results;     
    }

    public ArrayList<Song> searchSongsForTitle(String title){
        ArrayList<Song> results = new ArrayList<Song>();

        for(Song song : songList){
            if(song.getTitle().equalsIgnoreCase(title)){
                results.add(song);
            }
        }
        return results;
    }

    public ArrayList<Song> searchSongsForBand(String band){
        ArrayList<Song> results = new ArrayList<Song>();

        for(Album album : albumList){
            if(album.getBand().equalsIgnoreCase(band)){
                for(Song song : album.getSongList()){
                    results.add(song);
                }
            }
        }
        return results;
    }
}
