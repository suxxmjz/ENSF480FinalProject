package entities;

import java.util.*;


public class User{
    private ArrayList<Ticket> tickets;
	
    public void newTicket(Ticket tix) {
	tickets.add(tix);
    }

    public User() {
	tickets = new ArrayList<Ticket>();
    }
	
    public ArrayList<Ticket> getTickets() {
	return tickets;
    }
	
    public void clearTicketList() {
	tickets.clear();
    }

    
}
