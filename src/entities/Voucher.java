package entities;

import java.time.LocalDate;

public class Voucher{
	private int code;
	private double amount;
	private LocalDate expirationDate;
	private String email;

	//constructor 
	Voucher(double amount, LocalDate expirationDate, String email){
		int max = 1000000;
		int min = 10000;
		int range = max - min + 1;
		this.setAmount(amount);
		this.setExpirationDate(expirationDate);
		this.setCode((int)(Math.random() * range) + min);
		this.setEmail(email);
	}

	//getter for voucher code
	public int getCode() {
		return code;
	}

	//setter for voucher code
	public void setCode(int code) {
		this.code = code;
	}
	
        //getter for voucher amount
	public double getAmount() {
		return amount;
	}
	
       //setter for voucher amount
	public void setAmount(double amount) {
		this.amount = amount;
	}

	//getter for expiration date that that uses user's local date
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	//setter for expiration date
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	//getter for email
	public String getEmail() {
		return email;
	}

	//setter email
	public void setEmail(String email) {
		this.email = email;
	}
}
