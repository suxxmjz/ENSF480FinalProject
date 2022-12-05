package entities;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {

    private int id;
    private int seatNo;
    private Showtime showTimeTicket;


    private LocalDate datePurchased;
   
    private String email;
    private double price; 

    public Ticket(int id, int seatNo, String showroom_ID, String movieName, String theatre, LocalDate datePurchased, LocalDateTime showing_time, String email, double price){
        
        showTimeTicket = new Showtime(showroom_ID, theatre, movieName, showing_time);
        this.id = id;
        this.seatNo = seatNo;
   
        this.datePurchased = datePurchased;
       
        this.email = email;
        this.price= price;
    }

    public int getID(){
        return id;
    }

    public int getSeatNo(){
        return seatNo;
    }

    public Showtime getShowtimeObj(){
        return showTimeTicket;
    }

    public LocalDate getDatePurchased(){
        return datePurchased;
    }

    public String getEmail(){
        return email;
    }

    public double getPrice(){
        return price;
    }
}
