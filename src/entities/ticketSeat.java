package entities;

import java.time.LocalDateTime;

public class ticketSeat {
	private int id;
	private int seatNumber;
    private String rowNumber;
    private boolean available;
    private String movieName;
    private LocalDateTime showTime;
    private String showRoom;
    
    public ticketSeat (int id, int seatNumber, String rowNumber, boolean available, String movieName, LocalDateTime showTime,
            String showRoom) { //ctor for ticketSeat
    	 this.id = id;
    	 this.seatNumber = seatNumber;
         this.rowNumber = rowNumber;
         this.movieName = movieName;
         this.showTime = showTime;
         this.showRoom = showRoom;
    }
    
    public int getID(){ //getter for id
        return id;
    }
    
    public int getseatNumber() { //getter for seatNumber
        return seatNumber;
    }

    public String getRowNumber() { //getter for seat row
        return rowNumber;
    }

    public String getMovieName() { //getter for movie
        return movieName;
    }

    public LocalDateTime getShowTime() { //getter for showtime
        return showTime;
    }

    public String getShowRoom() { //getter for showroom
        return showRoom;
    }

    public boolean available() { //check if seat is available
        return this.available;
    }
}
