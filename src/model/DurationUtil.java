package model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DurationUtil {

    public DurationUtil() {
    }
    
    public String DurationToStringFormat(Duration duration){

        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }

    public Duration StringFormatToDuration(String input){

        Duration dur;

        try{

            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime lt = LocalTime.parse(input, format);
            dur = Duration.between ( LocalTime.MIN , lt );

        }catch(java.time.format.DateTimeParseException ex){

            return Duration.ZERO;

        }

        return dur;
    }

    public Duration getTotalDuration(ArrayList<Song> songList){

        Duration durationTotal = Duration.ZERO;

        for(Song song : songList){
            durationTotal = durationTotal.plus(song.getDuration()); 
        }

        return durationTotal;
    }
}
