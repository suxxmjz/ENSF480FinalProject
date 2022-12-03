package entities;
import java.time.LocalDate;

public class Ticket {

    private int id;
    private int seatNo;
    private String showroom_ID;
    private String movieName;
    private LocalDate datePurchased;
    private String showing_time;
    private String email;

    public Ticket(int id, int seatNo, String showroom_ID, String movieName, LocalDate datePurchased, String showing_time, String email){
        this.id = id;
        this.seatNo = seatNo;
        this.showroom_ID = showroom_ID;
        this.movieName = movieName;
        this.datePurchased = datePurchased;
        this.showing_time = showing_time;
        this.email = email;
    }

    public int getID(){
        return id;
    }

    public int getSeatNo(){
        return seatNo;
    }

    public String getShowroomID(){
        return showroom_ID;
    }

    public String getMovieName(){
        return movieName;
    }

    public LocalDate getDatePurchased(){
        return datePurchased;
    }

    public String getShowingTime(){
        return showing_time;
    }

    public String getEmail(){
        return email;
    }
}
