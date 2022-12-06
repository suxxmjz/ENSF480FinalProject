package controllers;

import javax.swing.UIManager;
import gui.WelcomeGUI;



public class MovieController {
               
        public static void main(String[] args) {
            DatabaseController dbControl = new DatabaseController(); //establish database
            MovieController app = new MovieController(); //establish moviecontroller
            CancellationController canControl = new CancellationController(dbControl); //establish cancellation controller
            PaymentController payControl = new PaymentController(dbControl); //establish payment controller
            
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    WelcomeGUI window = new WelcomeGUI(app, dbControl, canControl, payControl); //open welcome gui
                    window.frame.setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }    
}
