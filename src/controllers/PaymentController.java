package controllers;
import gui.*;

import java.time.LocalDateTime;
import java.util.*;
import entities.*;
public class PaymentController {
    public MovieTheatreApp app;
    private DatabaseController dbControl;
    private PaymentGUI payTab;
    private int card;
    private User currUser;
   
    
    public PaymentController(DatabaseController db){ //intialize database controller to current instance
        this.dbControl = db;
    }
    
    
    public void currApp(MovieTheatreApp app){ //intialize movieTheatre controller to current instance
        this.app = app;
    }

    public void makePayment(User user, Ticket theT){ //function to make the payment
        currUser = user;
        payTab = new PaymentGUI();
            currUser.newTicket(theT); //add new ticket under user email
            Showtime theShowTime = theT.getShowtimeObj();
            int theSeat = theT.getSeatNo();
            dbControl.changeToBooked(theShowTime, theSeat); //change the seat to booked
       
    }

}
