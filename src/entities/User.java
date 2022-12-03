package entities;

import java.util.*;


public class User{
    private ArrayList<Ticket> tickets;
    private ArrayList<TicketReceipt> receiptList;
	
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
    public void addTicketReceipt(TicketReceipt rec) {
		receiptList.add(rec);
	}
    
}
