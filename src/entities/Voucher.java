package entities;

import java.time.LocalDate;

public class Voucher{
	private int code;
	private int amount;
	private LocalDate expirationDate;
	private String email;

	public Voucher(int code, int amount, LocalDate expirationDate, String email){

		this.setAmount(amount);
		this.setExpirationDate(expirationDate.plusYears(1));
	//	this.setCode((int)(Math.random() * range) + min);
		this.setEmail(email);
		this.code = code;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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
