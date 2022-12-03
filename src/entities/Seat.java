package entities;
import java.util.*;


public class Seat{
    private int seatNumber;
    private String rowNumber;
    private boolean available;
    private String movieName;
    private float showTime;
    private String showRoom;


    public User (int seatNumber, string rowNumber, boolean available, string movieName, float showTime, string showRoom){
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showRoom = showRoom; 
    }

    
    public int getseatNumber(){
        return seatNumber;
    }

    public String getRowNumber(){
        return rowNumber;
    }

    public String getMovieName(){
        return movieName;
    }

    public float getShowTime(){
        return showTime;
    }

    public String getShowRoom(){
        return showRoom;
    }

    public boolean available(){
        return this.available;
    }

}
