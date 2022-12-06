package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.CancellationController;
import controllers.DatabaseController;
import controllers.MovieController;
import controllers.PaymentController;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeGUI{

	public JFrame frame;
	public static MovieController app;
	public static DatabaseController dbControl;
	public static CancellationController canControl;
	public static PaymentController payControl; 

	/**
	 * Launch the application.
	 */	
	public WelcomeGUI(MovieController app, DatabaseController dbControl, CancellationController canControl, PaymentController payControl) {
		WelcomeGUI.app = app;
		WelcomeGUI.dbControl = dbControl;
		WelcomeGUI.canControl = canControl;
		WelcomeGUI.payControl = payControl;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 157);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(244, 11, 179, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnGuest = new JButton("Continue as guest");
		btnGuest.addActionListener(new GuestListener());
		btnGuest.setBounds(191, 80, 140, 23);
		frame.getContentPane().add(btnGuest);
		
		JButton btnMakeAccount = new JButton("Create Account");
		btnMakeAccount.addActionListener(new MakeAccountListener());
		btnMakeAccount.setBounds(49, 80, 132, 23);
		frame.getContentPane().add(btnMakeAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new LoginListener());
		btnLogin.setBounds(341, 80, 141, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCanelTicket = new JButton("Cancel Ticket");
		btnCanelTicket.addActionListener(new CancelListener());
		btnCanelTicket.setBounds(492, 80, 140, 23);
		frame.getContentPane().add(btnCanelTicket);
	}

	
	class MakeAccountListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				CreateAccountGUI accountGUI = new CreateAccountGUI(dbControl);
				accountGUI.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				RUserLoginGUI loginGUI = new RUserLoginGUI(dbControl);
				loginGUI.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class CancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				CancelTicketGUI cancelTicketGUI = new CancelTicketGUI(dbControl);
				cancelTicketGUI.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class GuestListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				TheatreGUI theatreGUI = new TheatreGUI(dbControl);
				theatreGUI.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
