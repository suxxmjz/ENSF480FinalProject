package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import gui.*;
import entities.*;
import java.time.LocalDateTime;
import java.time.Duration;

public class CancellationController {
    private CancelTicketGUI refundGUI;
    private DatabaseController db;
    public MovieTheatreApp app;
    private int card;
    private int id;
    private User currUser;
    private Ticket ticket;


    public CancellationController(DatabaseController db) {
        this.db = db;
    }

    public void setMta(MovieTheatreApp incoming) {
        app = incoming;
    }

    public void cancel(User user) throws Exception {
        currUser = user;
        refundGUI = new CancelTicketGUI();
        refundGUI.getTicketNo();
    }

    public void ticketParse(int id) {
       
    
        ticket = db.getTicket(id);

        if (ticket == null) {
            refundGUI.CancellationFailedGUI("Ticket does not exist.");
            return;
        }

        if (!check72hours(ticket)) {
            refundGUI.CancellationFailedGUI("Refund failed. Please refund 72 hours prior to showtime.");
            return;
        }

        String userEmail = currUser.getEmail();
        boolean checkReg = db.checkRegisterStatus(userEmail);
        if(checkReg){
            currUser.addCredit((ticket.getPrice()), userEmail);
        }
        else{
            currUser.addCredit(((ticket.getPrice()) * 0.85), userEmail);
        }
        Showtime theShowTime = ticket.getShowtimeObj();
        int theSeat = ticket.getSeatNo();

        db.changeToAvailable(theShowTime, theSeat);
       
  
    }

    private boolean check72hours(Ticket ticket) {
        Duration duration = Duration.between(LocalDateTime.now(), (ticket.getShowtimeObj()).getShowingTime());
        if (duration.toHours() >= 72)
            return true;
        else
            return false;
    }
    
}
