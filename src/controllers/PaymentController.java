package controllers;
import gui.*;

import java.time.LocalDateTime;
import java.util.*;

import entities.*;
public class PaymentController {
    public MovieController app;
    private DatabaseController dbControl;
    private PaymentGUI payTabR;
    private MakePaymentGUI payTabO;
    private User currUser;
    
    public PaymentController(DatabaseController db){
        this.dbControl = db;
    }
    
    
    public void setApp(MovieController app){
        this.app = app;
    }

    public void makePayment(User user, Ticket theT, Showtime theTime){
        currUser = user;
        String eml = currUser.getEmail();
        Showtime theShowTime = theT.getShowtimeObj();
        int theSeat = theT.getSeatNo();
        boolean reg = dbControl.checkRegisterStatus(eml);
        if(reg){
            payTabR = new PaymentGUI(dbControl, theTime, theSeat, theT.getID(), eml);
        }
        else{
            payTabO = new MakePaymentGUI(dbControl, theTime, theSeat, theT.getID(), eml);
        }
        currUser.newTicket(theT);
        dbControl.changeToBooked(theShowTime, theSeat);
        dbControl.addTicket(theT);
       
    }

}