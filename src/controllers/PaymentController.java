package controllers;
import DatabaseController;
import PaymentGUI;
import java.util.*;
import entities.*;
public class PaymentController {
    public MovieTheatreApp app;
    private ArrayList<Ticket> tickets;
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

    public void makePayment(boolean reg, User user){
        currUser = user;
        tickets = currUser.getTickets();
        if(reg){
            payGUI = new PaymentGUI(user,this);
            payGUI.RegPaymentGUI();

        }
        else{
            payGUI = new PaymentGUI(user,this);
            normalPayment("info");
        }
        for (Ticket each : tickets) {
            TicketReceipt ticketReceipt = new TicketReceipt(each.getID());
            databaseController.addTicketReceipt(ticketReceipt);
            user.addTicketReceipt(ticketReceipt);
            databaseController.updateSeat(each.getMovieName(), each.getShowingTime(), each.getSeatNo(), false);
        }
        currUser.clearTicketList();
    }

    public void normalPayment(String info) throws Exception {
        payGUI.OrdPaymentGUI();
    }

    public void parseInfo(String e, String b, String c) {
        String email = e;
        String billingInfo = b;
        card = Integer.parseInt(c);

        for (Ticket each : tickets) {
            TicketReceipt ticketReceipt = new TicketReceipt(each.getID());
            databaseController.addTicketReceipt(ticketReceipt);
            currUser.addTicketReceipt(ticketReceipt);
            databaseController.updateSeat(each.getMovieName(), each.getShowingTime(), each.getSeatNo(), false);
        }
    }
}
