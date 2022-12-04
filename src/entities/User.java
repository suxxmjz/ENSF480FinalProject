package entities;

import java.util.*;
import java.time.*;  
import java.lang.Math;

class Voucher{
	int code;
	int amount;
	LocalDate expirationDate;

	Voucher(int amount, LocalDate expirationDate){
		int max = 1000000;
		int min = 10000;
		int range = max - min + 1;
		this.amount = amount;
		this.expirationDate = expirationDate;
		this.code = (int)(Math.random() * range) + min;
	}
}

public class User{
	private String firstName;
	private String lastName;
	private String userAddress;
	private String userEmail;
	private String password;
	private int cardNumber;
    private ArrayList<Ticket> tickets;
	private String email;
	private ArrayList<Voucher> userVouchers;

	public User(String firstName, String lastName, String userAddress, String userEmail, String password, int cardNumber){
	}
	
	public User() {
		tickets = new ArrayList<Ticket>();
       }
	
	public void newTicket(Ticket tix) {
		tickets.add(tix);
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public void clearTicketList() {
		tickets.clear();
	}


	public void addEmail(String mail){
		this.email = mail;
	}

	public String getEmail(){
        return email;
    }

	public String getFirstName(){
		return firstName;
	}

	
	public String getLastName(){
		return lastName;
	}

	public String getUserAddress(){
		return userAddress;
	}

	public String getuserEmail(){
		return userEmail;
	}

	public String getPassword(){
		return password;
	}

	public int getcardNumber(){
		return cardNumber;
	}
	public void addCredit(int credit, int creditAmount, boolean creditExpired) {

		LocalDate rn  = LocalDate.now();
		LocalDate expr = rn.plusYears(1);
		Voucher newV = new Voucher(credit,expr);
		userVouchers.add(newV);
	}
}
