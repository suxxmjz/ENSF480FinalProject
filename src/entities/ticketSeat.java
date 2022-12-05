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
            String showRoom) {
    	 this.id = id;
    	 this.seatNumber = seatNumber;
         this.rowNumber = rowNumber;
         this.movieName = movieName;
         this.showTime = showTime;
         this.showRoom = showRoom;
    }
    
    public int getID(){
        return id;
    }
    
    public int getseatNumber() {
        return seatNumber;
    }

    public String getRowNumber() {
        return rowNumber;
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
