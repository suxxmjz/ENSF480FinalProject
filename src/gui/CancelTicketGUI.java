package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controllers.AccountController;
import controllers.BrowsingController;
import controllers.CancellationController;
import controllers.DatabaseController;
import controllers.MovieTheatreApp;
import controllers.PaymentController;

import javax.swing.JButton;

public class CancelTicketGUI {

    public JFrame frame;
    public JTextField textField;
    public JTextField textField_1;
    public static String email, Ticket; //What should the type of Ticket be
    public static MovieTheatreApp app;
	public static DatabaseController dbControl;
	public static AccountController accControl;
	public static BrowsingController brControl;
	public static CancellationController canControl;
	public static PaymentController payControl;
 
    public CancelTicketGUI(DatabaseController dbControl) {
    	CancelTicketGUI.dbControl = dbControl;
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 208);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCancelTicket = new JLabel("Cancel Ticket");
        lblCancelTicket.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblCancelTicket.setBounds(136, 11, 155, 36);
        frame.getContentPane().add(lblCancelTicket);

        JLabel lblNewLabel = new JLabel("Ticket Number");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(53, 66, 93, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email Address");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(53, 101, 93, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(146, 64, 219, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(146, 99, 220, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new RefundListener());
        btnNewButton.setBounds(172, 130, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }
    
    class RefundListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				//Check for the email and ticket in database then do the stuff below
				//Also cancel the current ticket from the database
				//Also make the seat available in the database.
				email = textField.getText();
				Ticket = textField_1.getText();
				if(email.equals("") || Ticket.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid input", "Invalid Input", JOptionPane.ERROR_MESSAGE);
					}
				else {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "4345345345", "Voucher Number", JOptionPane.PLAIN_MESSAGE);
					WelcomeGUI afterRegistration= new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
					afterRegistration.frame.setVisible(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}