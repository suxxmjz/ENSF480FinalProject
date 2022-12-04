package controllers;
import gui.*;

import java.time.LocalDateTime;
import java.util.*;
import entities.*;
public class PaymentController {
    public MovieTheatreApp app;
    // private ArrayList<Ticket> tickets;
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
        // String email = user.getEmail();
        // boolean checkReg = checkRegisterUser(email);
        // // tickets = currUser.getTickets();
        // if(checkReg){
        //     payTab = new PaymentGUI(user,this);
        //     payTab.RegPaymentGUI();

        // }
        // else{
        //     payTab = new PaymentGUI(user,this);
        //     normalPayment("info");
        // }
        // for (Ticket each : tickets) {
            dbControl.addTicket(theT);
            currUser.newTicket(theT);
            Showtime theShowTime = theT.getShowtimeObj();
            int theSeat = theT.getSeatNo();
            dbControl.updateSeat(theShowTime, theSeat);
        //}
        // currUser.clearTicketList();
    }

    //IMPLEMENT BELOW FUNCTION TO MAKE SURE USER ENTERS CORRECT TYPE OF INFO

    // public void parseInfo(String e, String b, String c) {
    //     String email = e;
    //     String billingInfo = b;
    //     card = Integer.parseInt(c);

    //     for (Ticket each : tickets) {
           
    //         databaseController.addTicket(each);
    //         currUser.newTicket(each);
    //         databaseController.updateSeat(each.getMovieName(), each.getShowingTime(), each.getSeatNo(), false);
    //     }
    // }
}
