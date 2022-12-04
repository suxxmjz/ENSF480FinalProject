package entities;

import java.util.*;
import java.time.*;  
import java.lang.Math;


//Voucher class to generate voucher
//created by generating random numbers
class Voucher{
	int code;
	double amount;
	LocalDate expirationDate;
    String email;

         //constructor
	Voucher(double credit, LocalDate expirationDate, String email){
		int max = 1000000;
		int min = 10000;
		int range = max - min + 1;
		this.amount = credit;
		this.expirationDate = expirationDate;
		this.code = (int)(Math.random() * range) + min;
        this.email = email;
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
         
	//User constructor
	public User(String firstName, String lastName, String userAddress, String userEmail, String password, int cardNumber){
	}
	
	
	public User() {
		tickets = new ArrayList<Ticket>();
       }
	
	//to get a new ticket
	public void newTicket(Ticket tix) {
		tickets.add(tix);
	}

	//array to retrieve tickets
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	//to remove tickets
	public void clearTicketList() {
		tickets.clear();
	}

        //to link email to user
	public void addEmail(String mail){
		this.email = mail;
	}
        
	//getter for email
	public String getEmail(){
        return email;
    }
        //getter for first name
	public String getFirstName(){
		return firstName;
	}

	//getter for last name
	public String getLastName(){
		return lastName;
	}

	//getter for user address
	public String getUserAddress(){
		return userAddress;
	}
        
	//getter for user email
	public String getuserEmail(){
		return userEmail;
	}
 
	//getter for password
	public String getPassword(){
		return password;
	}
 
	//getter for user's card number
	public int getcardNumber(){
		return cardNumber;
	}
	
	//function to add voucher credit to user's account
	public void addCredit(double d, String e) {

		LocalDate rn  = LocalDate.now();
		LocalDate expr = rn.plusYears(1);
		Voucher newV = new Voucher(d,expr, e);
		userVouchers.add(newV);
	}
     
	//function to delete voucher from database when applied to an account
     public void deleteVoucher(int codeV, String emailV){
        for(int i =0; i < userVouchers.size(); i++){
            if(userVouchers.get(i).code == codeV && userVouchers.get(i).email == emailV){
                userVouchers.remove(i);
                return;

            }
        }
    }
}
