package controllers;

import javax.swing.UIManager;
import gui.WelcomeGUI;
import entities.*;
import controllers.*;


public class MovieTheatreApp {
        private WelcomeGUI start;
        private BrowsingController browser;
        private PaymentController pay;
        private CancellationController cancel;
        private AccountController acc;
        private boolean isLogged;
        private User user;
        
        public MovieTheatreApp(DatabaseController data) {
            browser = new BrowsingController(data, this);
            pay = new PaymentController(data);
            cancel = new CancellationController(data);
            acc = new AccountController();
            user = new User();
        }
        
        public static void main(String[] args) {
            DatabaseController dbControl = new DatabaseController();
            AccountController acControl = new AccountController();
            MovieTheatreApp app = new MovieTheatreApp(dbControl);
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    if (app.user.getClass() == User.class) {
                        app.start = new WelcomeGUI(app);
                    }
                    else {
                        app.start = new WelcomeGUI ("Account singed in", app);
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            } 
        
        public void loginStatus(boolean in) {
            isLogged = in;
        }
        
        public void payNow() throws Exception {
            pay.pay(isLogged, user);
            pay.setMta(this);
        }
        
        public void login() throws Exception {
            user = new RegisteredUser();
            try {
                acc.login(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        public void userSelection () {
            start = new WelcomeGUI ("User logged in", this);
        }
        
        public void browse() throws Exception {
            browse.browse(user);
        }
        
        public void cancel() throws Exception {
            cancel.cancel(new User());
            cancel.setMta(this);
        }
        
        public void register() throws Exception {
            account.createAccount();
        }
        
        public void logout() {
            user = new User ();
            start = new WelcomeGUI (this);
        }
        
        public void restart() {
            if (user.getClass() == User.class) {
                start = new WelcomeGUI (this);
            }
            else {
                start = new WelcomeGUI ("Account singed in", this);
            }
        }
        
        public void setUser(User use) {
            user = use;
        }
        
        public User getUser () {
            return user;
        }
}
