package entities;

import java.time.LocalDate;

public class Voucher{
	private int code;
	private double amount;
	private LocalDate expirationDate;
	private String email;

	Voucher(double amount, LocalDate expirationDate, String email){
		int max = 1000000;
		int min = 10000;
		int range = max - min + 1;
		this.setAmount(amount);
		this.setExpirationDate(expirationDate);
		this.setCode((int)(Math.random() * range) + min);
		this.setEmail(email);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
