package entities;
import java.time.LocalDate;

public class Ticket {

    private int id;
    private int seatNo;
    private String showroom_ID;
    private String movieName;
    private LocalDate datePurchased;
    private LocalDate showing_time;
    private String email;
    private double price; 

    public Ticket(int id, int seatNo, String showroom_ID, String movieName, LocalDate datePurchased, LocalDate showing_time, String email, double price){
        this.id = id;
        this.seatNo = seatNo;
        this.showroom_ID = showroom_ID;
        this.movieName = movieName;
        this.datePurchased = datePurchased;
        this.showing_time = showing_time;
        this.email = email;
        this.price= price;
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

    public LocalDate getShowingTime(){
        return showing_time;
    }

    public String getEmail(){
        return email;
    }

    public double getPrice(){
        return price;
    }
}
