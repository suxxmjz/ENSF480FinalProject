package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeGUI{

	private JFrame frame; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeGUI window = new WelcomeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private WelcomeGUI() {
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
				CreateAccountGUI accountGUI = new CreateAccountGUI(dbControl, accControl, paycontrol);
				accountGUI.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
//				app.login();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class CancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
//				app.cancel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class GuestListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
//				app.browse();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
