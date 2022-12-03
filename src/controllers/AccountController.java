package controllers;
import DatabaseController;
import entities.*;
import View.AccountGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController {
    private AccountGUI accountGUI;
	private DatabaseController databaseController;
	private MovieTheatreApp movieTheatreApp;
	
	public AccountController(DatabaseController database, MovieTheatreApp movieTheater) {
		databaseController = database;
		movieTheatreApp = movieTheater;
	}
	
	public void createAccount() {
		this.accountGUI = new AccountGUI ("Create an Account", this);
	}
	
	public MovieTheatreApp getMTA () {
		return movieTheatreApp;
	}

	public void register() throws Exception{
		
		Information information = new Information(accountGUI.getFirstName(), accountGUI.getLastName(), accountGUI.getUserAddress(), accountGUI.getCardNumber());
		String email = accountGUI.getUserEmail();
		String password = accountGUI.getPassword();
		databaseController.addAccount(information);
		information = databaseController.getAccount(email, password);
		if (information == null) {
			accountGUI.displayInvalidRegistration();
		}
		else {
			movieTheatreApp.loginStatus(true);
			accountGUI.displayConfirmedRegistration(account.getCreationDate().toString());
			movieTheatreApp.setUser(new RegisteredUser());
			((RegisteredUser) movieTheatreApp.getUser()).setAccount(information);
			movieTheatreApp.restart();
		}
	}
	
	public void login(User user) throws Exception {
		
		accountGUI = new AccountGUI ("Login", this, user);
	
	}
	
	public void checkLogin (User user) {
		
		Information information = databaseController.getAccount(accountGUI.getEmail(), accountGUI.getPassword());
		if (information == null) {
			accountGUI.dispose();
			accountGUI.displayInvalidLogin();
			try {
				login(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		else {
			((RegisteredUser) user).getInformation();
			movieTheatreApp.setUser(user);
			accountGUI.setUser(user);
			accountGUI.dispose();
			accountGUI.displayLoginConfirmation();	
			movieTheatreApp.userSelection();
			movieTheatreApp.loginStatus(true);
		}
	}
}
