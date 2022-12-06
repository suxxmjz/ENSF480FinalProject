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


    public CancellationController(DatabaseController db) { //set database instance
        this.db = db;
    }

    public void setApp(MovieController incoming) { //set moviecontroller instance
        app = incoming;
    }


    public void validateTicket(int id, String email) { //function to check if ticket is able to be cancelled
       
    
        ticket = db.getTicket(id, email);

        if (ticket == null) { //if ticket is invalid
            System.out.print("Ticket does not exist.");
            return;
        }

        if (!check72hours(ticket)) { //refund window(72 hours prior) has passed
            System.out.print("Refund failed. Please refund 72 hours prior to showtime.");
            return;
        }


        boolean checkReg = db.checkRegisterStatus(email); //check registration status of user
        if(checkReg){
          
			LocalDate expDate = LocalDate.now();
			int max = 1000000;
			int min = 10000;
			int range = max - min + 1;
			int theCode =(int)(Math.random() * range) + min; //generate voucher id
            newV = new Voucher(theCode, 20, expDate, email);
        }
        else{
            LocalDate expDate = LocalDate.now();
            int max = 1000000;
            int min = 10000;
            int range = max - min + 1;
            int theCode = (int) (Math.random() * range) + min;
            newV = new Voucher(theCode, 17, expDate, email);
        }

        Showtime theShowTime = ticket.getShowtimeObj();
        int theSeat = ticket.getSeatNo();

        db.changeToAvailable(theShowTime, theSeat); //change seat back to available
        db.addVoucher(newV); //add voucher info to database
  
    }

    private boolean check72hours(Ticket ticket) { //check if 72 hours window has passed for refund
        Duration duration = Duration.between(LocalDateTime.now(), (ticket.getShowtimeObj()).getShowingTime());
        if (duration.toHours() >= 72)
            return true;
        else
            return false;
    }
    
}
