package controllers;

import javax.swing.UIManager;
import gui.WelcomeGUI;



public class MovieTheatreApp {
               
        public static void main(String[] args) {
            DatabaseController dbControl = new DatabaseController();
            MovieTheatreApp app = new MovieTheatreApp();
            BrowsingController brControl = new BrowsingController(dbControl, app);
            CancellationController canControl = new CancellationController(dbControl);
            PaymentController payControl = new PaymentController(dbControl);
            AccountController accControl = new AccountController(dbControl, app);
            
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    WelcomeGUI window = new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
                    window.frame.setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }    
}
