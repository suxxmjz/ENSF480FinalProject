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


    public CancellationController(DatabaseController db) { //intialize database controller to current instance
        this.db = db;
    }

    public void setMta(MovieTheatreApp incoming) { //intialize movietheatre controller to current instance
        app = incoming;
    }

    public void cancel(User user) throws Exception { //to cancel a ticket
        currUser = user;
        refundGUI = new CancelTicketGUI();
        refundGUI.getTicketNo();
    }

    public void ticketParse(int id) { //function to see if ticket actually exists
       
    
        ticket = db.getTicket(id);

        if (ticket == null) { //so if ticket doesn't exist, show an error message
            refundGUI.CancellationFailedGUI("Ticket does not exist.");
            return;
        }

        if (!check72hours(ticket)) { //if it is 72 hours or closer to the showtime, the refund is invalid
            refundGUI.CancellationFailedGUI("Refund failed. Please refund 72 hours prior to showtime.");
            return;
        }

        String userEmail = currUser.getEmail();
        boolean checkReg = db.checkRegisterStatus(userEmail); //check is user is registeered
        if(checkReg){
            currUser.addCredit((ticket.getPrice()), userEmail); //if they are registered, give back full credit
        }
        else{
            currUser.addCredit(((ticket.getPrice()) * 0.85), userEmail); //if they are ordinary user, take %15 admin cut for return credit
        }
        Showtime theShowTime = ticket.getShowtimeObj();
        int theSeat = ticket.getSeatNo();

        db.changeToAvailable(theShowTime, theSeat); //free up the seat again
       
  
    }

    private boolean check72hours(Ticket ticket) { //function to check if there is more than 72 hours till showtime
        Duration duration = Duration.between(LocalDateTime.now(), (ticket.getShowtimeObj()).getShowingTime());
        if (duration.toHours() >= 72)
            return true;
        else
            return false;
    }
    
}
