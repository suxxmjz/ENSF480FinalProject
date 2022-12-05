package entities;

import java.time.LocalDateTime;

public class Seat {
    private int seatNumber;
    //private String rowNumber;
    private boolean available;
    private String movieName;
    private LocalDateTime showTime;
    private String showRoom;

    public Seat(int seatNumber, boolean available, String movieName, LocalDateTime showTime,
            String showRoom) {
        this.seatNumber = seatNumber;
        this.available = available;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showRoom = showRoom;
    }

    public int getseatNumber() {
        return seatNumber;
    }


    public String getMovieName() {
        return movieName;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public String getShowRoom() {
        return showRoom;
    }

    public boolean available() {
        return this.available;
    }

}