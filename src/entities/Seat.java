package entities;

import java.time.LocalDateTime;
import java.util.*;

public class Seat {
    private int seatNumber;
    private String rowNumber;
    private boolean available;
    private String movieName;
    private LocalDateTime showTime;
    private String showRoom;

    
    //constructor
    public Seat(int seatNumber, boolean available, String movieName, LocalDateTime showTime,
            String showRoom) {
        this.seatNumber = seatNumber;
        this.available = available;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showRoom = showRoom;
    }
    
    //getter for seat number
    public int getseatNumber() {
        return seatNumber;
    }

    //getter for movie name
    public String getMovieName() {
        return movieName;
    }

    //getter for show time that uses user's local date and time
    public LocalDateTime getShowTime() {
        return showTime;
    }

    //getter for show room
    public String getShowRoom() {
        return showRoom;
    }

    //boolean flag to check if seat is available or not
    public boolean available() {
        return this.available;
    }

}
