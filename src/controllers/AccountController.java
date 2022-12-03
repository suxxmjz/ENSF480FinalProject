package controllers;
import DatabaseController;
import entities.*;
import View.AccountGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController {
    private AccountGUI acc;
	private DatabaseController dbControl;
	private MovieTheatreApp app;
	
	public AccountController(DatabaseController db, MovieTheatreApp movieTheater) {
		dbControl = db;
		app = movieTheater;
	}
	
	public void createAccount() {
		this.acc = new AccountGUI ("Create an Account", this);
	}
	
	public MovieTheatreApp getApp () {
		return app;
	}

	public void register() throws Exception{
		
		Information information = new Information(acc.getFirstName(), acc.getLastName(), acc.getUserAddress(), acc.getCardNumber());
		String email = acc.getUserEmail();
		String password = acc.getPassword();
		dbControl.addAccount(information);
		information = dbControl.getAccount(email, password);
		if (information == null) {
			acc.displayInvalidRegistration();
		}
		else {
			app.loginStatus(true);
			acc.displayConfirmedRegistration(acc.getCreationDate().toString());
			app.setUser(new RegisteredUser());
			((RegisteredUser) app.getUser()).getInformation();
			app.restart();
		}
	}
	
	public void login(User user) throws Exception {
		
		acc = new AccountGUI ("Login", this, user);
	
	}
	
	public void checkLogin (User user) {
		
		Information information = dbControl.getAccount(acc.getEmail(), acc.getPassword());
		if (information == null) {
			acc.dispose();
			acc.displayInvalidLogin();
			try {
				login(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		else {
			((RegisteredUser) user).getInformation();
			app.setUser(user);
			acc.setUser(user);
			acc.dispose();
			acc.displayLoginConfirmation();	
			app.userSelection();
			app.loginStatus(true);
		}
	}
}
