package controllers;
import DatabaseController;
import PaymentGUI;
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
        this.db = db;
    }
    
    
    public void currApp(MovieTheatreApp app){
        this.app = app;
    }

    public void makePayment(User user, Ticket theT){
        currUser = user;
        String email = user.getEmail();
        boolean checkReg = checkRegisterUser(email);
        // tickets = currUser.getTickets();
        if(checkReg){
            payGUI = new PaymentGUI(user,this);
            payGUI.RegPaymentGUI();

        }
        else{
            payGUI = new PaymentGUI(user,this);
            normalPayment("info");
        }
        // for (Ticket each : tickets) {
            databaseController.addTicket(theT);
            user.newTicket(theT);
            databaseController.updateSeat(theT.getMovieName(), theT.getShowingTime(), theT.getSeatNo(), false);
        //}
        currUser.clearTicketList();
    }

    public void normalPayment(String info) throws Exception {
        payGUI.OrdPaymentGUI();
    }

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
