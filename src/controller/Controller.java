package controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import model.Album;
import model.Database;
import model.DurationUtil;
import model.Song;
import view.Display;

public class Controller {

    private Database db;
    private Display display;

    public Controller(){
        db = new Database();
        display = new Display();
    }

    public void start(){

        int op = 0;

        while(op != 5){

            op = display.mainMenu();

            switch(op){
                case 1:
                    Album newAlbum = new Album();
                    display.fillAlbumData(newAlbum);

                    do{

                        Song newSong = new Song();

                        display.fillSongData(newSong);
                        db.registerSong(newSong);
                        newAlbum.getSongList().add(newSong);

                    }while(display.RegisterSongAgain());

                    db.registerAlbum(newAlbum);
                    break;
                case 2:
                    op = display.searchAlbumMenu();
                    ArrayList<Album> albumResults;

                    switch(op){
                        case 1:
                            albumResults = db.searchAlbunsForTitle(display.searchAlbumTitle());
                            break;
                        case 2:
                            albumResults = db.searchAlbunsForReleaseYear(display.searchAlbumReleaseYear());
                            break;
                        case 3:
                            albumResults = db.searchAlbunsForBand(display.searchAlbumBand());
                            break;
                        default:
                            albumResults = new ArrayList<Album>();
                    }
                    switch(op){
                        case 1:
                        case 2:
                        case 3:
                            display.albumResults(albumResults);
                        default:
                    }
                    break;
                case 3:
                    op = display.searchSongMenu();
                    ArrayList<Song> songResults = null;

                    switch(op){
                        case 1:
                            songResults = db.searchSongsForTitle(display.searchSongTitle());
                            break;
                        case 2:
                            songResults = db.searchSongsForBand(display.searchSongBand());
                            break;
                        default:
                    }
                    switch(op){
                        case 1:
                        case 2:
                        case 3:
                            display.songList(songResults);
                        default:
                    }
                    break;
                case 4:
                    display.playlist(generatePlaylist());
                    break;
                case 5:
                    display.exitMessage();
                    break;

                default:
            }
        }
    }

    public ArrayList<Song> generatePlaylist(){

        ArrayList<Song> allSongs = db.getAllSongsList();
        ArrayList<Song> favoSongs = db.getFavoriteSongsList();
        ArrayList<Song> playlist = new ArrayList<Song>();

        DurationUtil durationUtil = new DurationUtil();
        Random random = new Random();

        Duration durationOneHour = durationUtil.StringFormatToDuration("01:00:00");

        boolean pickFavorite = true;

        Song randomSong = null;

        while(durationOneHour.minus(durationUtil.getTotalDuration(playlist)).isPositive() && allSongs.size() > 0){

            if(pickFavorite && favoSongs.size() > 0){
                  
                randomSong = favoSongs.size() > 1 ? favoSongs.get(random.nextInt(favoSongs.size()-1)) : favoSongs.get(0);

                pickFavorite = false;
            }else{

                randomSong = allSongs.size() > 1 ? allSongs.get(random.nextInt(allSongs.size()-1)) : allSongs.get(0);
                System.out.println(randomSong.toString());

                pickFavorite = true;
            }

            playlist.add(randomSong);
            allSongs.remove(randomSong);
            favoSongs.remove(randomSong);
        }

        if(durationOneHour.minus(durationUtil.getTotalDuration(playlist)).isNegative()){
            playlist.remove(randomSong);
        }

        return playlist;
    }
}
