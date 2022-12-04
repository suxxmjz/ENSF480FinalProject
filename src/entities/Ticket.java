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

    public Ticket(int id, int seatNo, String showroom_ID, String movieName, String theatre, LocalDate datePurchased, LocalDateTime showing_time, String email, double price){ //ctor for ticket
        
        showTimeTicket = new Showtime(showroom_ID, theatre, movieName, showing_time);
        this.id = id;
        this.seatNo = seatNo;
   
        this.datePurchased = datePurchased;
       
        this.email = email;
        this.price= price;
    }

    public int getID(){ //getter for id
        return id;
    }

    public int getSeatNo(){ //getter for seat number
        return seatNo;
    }

    public Showtime getShowtimeObj(){ //getter for showtime
        return showTimeTicket;
    }

    public LocalDate getDatePurchased(){ //getter for date purchased
        return datePurchased;
    }

    public String getEmail(){ //getter for email
        return email;
    }

    public double getPrice(){ //getter tof ticket price
        return price;
    }
}
