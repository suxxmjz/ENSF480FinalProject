package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import Database.DatabaseController;
import entities.*;
import View.CancellationGUI;
import java.time.LocalDateTime;
import java.time.Duration;

public class CancellationController {
    private CancellationGUI refundGUI;
    private DatabaseController databaseController;
    public MovieTheatreApp app;
    private int card;
    private int id;
    private User currUser;
    private Ticket ticket;


    public CancellationController(DatabaseController db) {
        databaseController = db;
    }

    public void setMta(MovieTheatreApp incoming) {
        app = incoming;
    }

    public void cancel(User user) throws Exception {
        currUser = user;
        refundGUI = new CancellationGUI("Ticket Cancellation", this);
        refundGUI.getTicketNo();
    }

    public void ticketParse(int id) {
       
    
        ticket = databaseController.getTicket(id);

        if (ticket == null) {
            refundGUI.CancellationFailedGUI("Ticket does not exist.");
            return;
        }

        if (!check72hours(ticket)) {
            refundGUI.CancellationFailedGUI("Refund failed. Please refund 72 hours prior to showtime.");
            return;
        }
        if (currUser.getClass() == User.class) {
            try {
                ordinaryCancel(currUser, ticket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            registeredCancel(currUser, ticket);
        }
        boolean deleted = databaseController.removeTicketReceipt(id);
        if (deleted) {
            databaseController.updateSeat(ticket.getMovieName(), ticket.getShowingTime(), ticket.getSeatNo(), true);
        }
    }

    // public void billingInfoParse(String e, String c, String b) {
    //     String email = e;
    //     String billingInfo = b;
    //     card = Integer.parseInt(c);
    //     double refundAmount = ticket.getPrice() * .85;
    //     Calendar cal = Calendar.getInstance();
    //     cal.add(Calendar.YEAR, 1);
    //     Date nextYear = cal.getTime();
    //     refundGUI.RegCancelGUI(refundAmount, nextYear);
    // }

    private boolean check72hours(Ticket ticket) {
        Duration duration = Duration.between(LocalDateTime.now(), ticket.getShowingTime());
        if (duration.toHours() >= 72)
            return true;
        else
            return false;
    }
    }

    private void ordinaryCancel(User user, Ticket ticket) throws Exception {
        refundGUI.OrdinaryCancelGUI();
    }

    private void registeredCancel(User user, Ticket ticket) {
        double refundAmount = ticket.getPrice();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date nextYear = cal.getTime();
        refundGUI.RegCancelGUI(refundAmount, nextYear);
    }
}
