package view;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.Duration;

import model.Album;
import model.DurationUtil;
import model.Song;


public class Display {

    private Scanner scanner;
    private DurationUtil durationUtil;

    public Display(){
        scanner = new Scanner(System.in);
        durationUtil = new DurationUtil();
    }

    public int mainMenu(){

        System.out.println("=-=-=-=MAIN MENU=-=-=-=\n");
        System.out.println("1- Register Album");
        System.out.println("2- Search Album");
        System.out.println("3- Search Song");
        System.out.println("4- Generate Playlist");
        System.out.println("5- Exit\n");
        System.out.print("Enter the corresponding option number above: ");

        int op = Integer.parseInt(scanner.nextLine());
        //int op = scanner.nextInt();
        return op;
    }

    public int searchAlbumMenu(){
        System.out.println("\n=-=-=-=SEARCH ALBUM=-=-=-=\n");
        System.out.println("You want to search for:\n");
        System.out.println("1- Title");
        System.out.println("2- Year Release");
        System.out.println("3- Band Name");
        System.out.println("0- Exit\n");
        System.out.print("Enter the corresponding option number above: ");

        int op = Integer.parseInt(scanner.nextLine());
        return op;
    }

    public int searchSongMenu(){
        System.out.println("\n=-=-=-=SEARCH SONG=-=-=-=\n");
        System.out.println("You want to search for:\n");
        System.out.println("1- Title");
        System.out.println("2- Band Name");
        System.out.println("0- Exit\n");
        System.out.print("Enter the corresponding option number above: ");

        int op = Integer.parseInt(scanner.nextLine());
        return op;
    }

    public String searchAlbumTitle(){
        System.out.println("\n=-=-=-=SEARCH ALBUM FOR TITLE=-=-=-=\n");
        System.out.print("Enter the album title: ");

        return scanner.nextLine();
    }

    public int searchAlbumReleaseYear(){
        System.out.println("\n=-=-=-=SEARCH ALBUM FOR TITLE=-=-=-=\n");
        System.out.print("Enter the album release year: ");

        return Integer.parseInt(scanner.nextLine());
    }

    public String searchAlbumBand(){
        System.out.println("\n=-=-=-=SEARCH ALBUM FOR TITLE=-=-=-=\n");
        System.out.print("Enter the band name: ");

        return scanner.nextLine();
    }

    public String searchSongBand(){
        System.out.println("\n=-=-=-=SEARCH SONG FOR BAND=-=-=-=\n");
        System.out.print("Enter the band name: ");

        return scanner.nextLine();
    }

    public String searchSongTitle(){
        System.out.println("\n=-=-=-=SEARCH SONG FOR TITLE=-=-=-=\n");
        System.out.print("Enter the song title: ");

        return scanner.nextLine();
    }

    public void albumResults(ArrayList<Album> results){
        System.out.println();
        System.out.println(Integer.toString(results.size()) + " results found.");
        System.out.println();

        int cont_album = 1;
        for(Album album : results){
            System.out.print(Integer.toString(cont_album) + "- ");
            System.out.println(album.toString());
            System.out.println("-------------------");
            System.out.println("SONGS: ");
            songList(album.getSongList());
            System.out.println();
            cont_album++;
        }
    }

    public void songResultsSeach(ArrayList<Song> results){
        System.out.println();
        System.out.println(Integer.toString(results.size()) + " results found.");
        System.out.println();
        songList(results);
    }

    public void playlist(ArrayList<Song> playlist){
        Duration playlistDuration = durationUtil.getTotalDuration(playlist);

        System.out.println();
        System.out.println("=-=-=-=PLAYLIST=-=-=-=\n");
        System.out.println("-> "+Integer.toString(playlist.size()) + " Songs - Duration: [" + 
                            durationUtil.DurationToStringFormat(playlistDuration) + "]");
        
        songList(playlist);
    }

    public void songList(ArrayList<Song> results){

        int cont = 1;
        System.out.println();
        for(Song song : results){
            System.out.print(Integer.toString(cont) + "- ");
            System.out.println(song.toString());
            cont++;
        }
        System.out.println();
    }

    public void fillAlbumData(Album data){

        System.out.println("\n=-=-=-=ALBUM REGISTER=-=-=-=\n");

        System.out.print("Enter the album title: ");
        data.setTitle(scanner.nextLine());

        System.out.print("\nEnter the release year: ");
        data.setReleaseYear(Integer.parseInt(scanner.nextLine()));

        System.out.print("\nEnter the band name: ");
        data.setBand(scanner.nextLine());
    }

    public void fillSongData(Song data){

        System.out.println("\n=-=-=-=SONG REGISTER=-=-=-=\n");

        System.out.print("Enter the song title: ");
        data.setTitle(scanner.nextLine());

        System.out.print("\nEnter enter the song duration (hh:mm:ss): ");
        Duration dur = durationUtil.StringFormatToDuration(scanner.nextLine());
        data.setDuration(dur);

        System.out.print("\nis this song a favourite? (y/n) \n");
        switch(scanner.nextLine().charAt(0)){
            case 'y':
                data.setFavorite(true);
                break;
            case 'n':
                data.setFavorite(false);
                break;
            default:
                data.setFavorite(false);
                break;
        }
    }

    public boolean RegisterSongAgain(){
        System.out.println("Do you want to register another song? (y/n) ");
        switch(scanner.nextLine().charAt(0)){
            case 'y':
                return true;
            default:
                return false;
        }
    }

    public void exitMessage(){
        System.out.print("\n----------Thank you for using our system.----------\n");
        
    }

}
