package controllers;

import javax.swing.UIManager;
import gui.WelcomeGUI;



public class MovieController {
               
        public static void main(String[] args) {
            DatabaseController dbControl = new DatabaseController();
            MovieController app = new MovieController();
            CancellationController canControl = new CancellationController(dbControl);
            PaymentController payControl = new PaymentController(dbControl);
            
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    WelcomeGUI window = new WelcomeGUI(app, dbControl, canControl, payControl);
                    window.frame.setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }    
}
