package entities;

import java.util.*;
import java.time.*;  
import java.lang.Math;


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
            if(userVouchers.get(i).getCode() == codeV && userVouchers.get(i).getEmail() == emailV){
                userVouchers.remove(i);
                return;

            }
        }
    }
}
