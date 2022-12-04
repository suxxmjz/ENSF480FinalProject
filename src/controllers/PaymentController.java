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
    
    public PaymentController(DatabaseController db){
        this.dbControl = db;
    }
    
    
    public void currApp(MovieTheatreApp app){
        this.app = app;
    }

    public void makePayment(User user, Ticket theT){
        currUser = user;
        payTab = new PaymentGUI();
            currUser.newTicket(theT);
            Showtime theShowTime = theT.getShowtimeObj();
            int theSeat = theT.getSeatNo();
            dbControl.changeToBooked(theShowTime, theSeat);
       
    }

}
