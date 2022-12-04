package controllers;
import controllers.DatabaseController;
import entities.*;
import gui.CreateAccountGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController {
    private CreateAccountGUI acc;
	private DatabaseController dbControl;
	private MovieTheatreApp app;
	
	public AccountController(DatabaseController db, MovieTheatreApp movieTheater) {
		dbControl = db;
		app = movieTheater;
	}
	
	public void createAccount() {
		this.acc = new CreateAccountGUI ("Create an Account", this);
	}
	
	public MovieTheatreApp getApp () {
		return app;
	}

	public void register() throws Exception{
		
		
		dbControl.addRegisteredUser(acc.getRU());
		String email = acc.getRU().getEmail();
		String password = acc.getRU().getPassword();
		RegisteredUser information = dbControl.getRegisteredUser(email, password);
		if (information == null) {
//			acc.displayInvalidRegistration();
		}
		else {
			System.out.println("successfully added RU");
//			app.loginStatus(true);
////			acc.displayConfirmedRegistration(acc.getCreationDate().toString());
//			app.setUser(information);
////			((RegisteredUser) app.getUser()).getInformation();
//			app.restart();
		}
	}
	
//	public void login(User user) throws Exception {
//		
//		acc = new CreateAccountGUI ("Login", this, user);
//	
//	}
//	
//	public void checkLogin (User user) {
//		
//		Information information = dbControl.getAccount(acc.getEmail(), acc.getPassword());
//		if (information == null) {
//			acc.dispose();
//			acc.displayInvalidLogin();
//			try {
//				login(user);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		else {
//			((RegisteredUser) user).getInformation();
//			app.setUser(user);
//			acc.setUser(user);
//			acc.dispose();
//			acc.displayLoginConfirmation();	
//			app.userSelection();
//			app.loginStatus(true);
//		}
//	}
	
}
