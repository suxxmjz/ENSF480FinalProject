package controllers;

import java.util.*;
import gui.*;
import entities.*;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;

public class CancellationController {
    private CancelTicketGUI refundGUI;
    private DatabaseController db;
    public MovieController app;
    private int card;
    private int id;
    private User currUser;
    private Ticket ticket;
    private Voucher newV;


    public CancellationController(DatabaseController db) {
        this.db = db;
    }

    public void setApp(MovieController incoming) {
        app = incoming;
    }


    public void validateTicket(int id, String email) {
       
    
        ticket = db.getTicket(id, email);

        if (ticket == null) {
            System.out.print("Ticket does not exist.");
            return;
        }

        if (!check72hours(ticket)) {
            System.out.print("Refund failed. Please refund 72 hours prior to showtime.");
            return;
        }


        boolean checkReg = db.checkRegisterStatus(email);
        if(checkReg){
          
			LocalDate expDate = LocalDate.now();
			int max = 1000000;
			int min = 10000;
			int range = max - min + 1;
			int theCode =(int)(Math.random() * range) + min;
            newV = new Voucher(theCode, 20, expDate, email);
        }
        else{
            LocalDate expDate = LocalDate.now();
            int max = 1000000;
            int min = 10000;
            int range = max - min + 1;
            int theCode = (int) (Math.random() * range) + min;
            newV = new Voucher(theCode, 20, expDate, email);
        }

        Showtime theShowTime = ticket.getShowtimeObj();
        int theSeat = ticket.getSeatNo();

        db.changeToAvailable(theShowTime, theSeat);
        db.addVoucher(newV);
  
    }

    private boolean check72hours(Ticket ticket) {
        Duration duration = Duration.between(LocalDateTime.now(), (ticket.getShowtimeObj()).getShowingTime());
        if (duration.toHours() >= 72)
            return true;
        else
            return false;
    }
    
}