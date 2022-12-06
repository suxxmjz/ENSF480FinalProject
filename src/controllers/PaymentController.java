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
    
    public PaymentController(DatabaseController db){ //set database instance
        this.dbControl = db;
    }
    
    
    public void setApp(MovieController app){ //set movie controller instance
        this.app = app;
    }

    public void makePayment(User user, Ticket theT, Showtime theTime){ //to make a payment
        currUser = user;
        String eml = currUser.getEmail();
        Showtime theShowTime = theT.getShowtimeObj();
        int theSeat = theT.getSeatNo();
        boolean reg = dbControl.checkRegisterStatus(eml); //check registration status of user
        if(reg){
            payTabR = new PaymentGUI(dbControl, theTime, theSeat, theT.getID(), eml); //open gui that has user and card info saved
        }
        else{
            payTabO = new MakePaymentGUI(dbControl, theTime, theSeat, theT.getID(), eml); //open gui where user has to enter their info
        }
        currUser.newTicket(theT);
        dbControl.changeToBooked(theShowTime, theSeat);
        dbControl.addTicket(theT);
       
    }

}
