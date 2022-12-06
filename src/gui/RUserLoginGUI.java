package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controllers.DatabaseController;
import entities.RegisteredUser;
import java.awt.Color;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RUserLoginGUI {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton btnLogin;
	public static DatabaseController dbControl;

	public static String email, password;
	char[] passwordEncrypt;

	public  RUserLoginGUI(DatabaseController dbControl) {
		RUserLoginGUI.dbControl = dbControl;
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLogin.setBounds(182, 11, 70, 36);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(75, 58, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Password");
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_3.setBounds(75, 95, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 67, 163, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("Forgot Password?");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(158, 130, 122, 14);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 105, 163, 20);
		frame.getContentPane().add(passwordField);
		
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new CheckLoginListener());
		btnLogin.setBounds(158, 153, 84, 23);
		frame.getContentPane().add(btnLogin);
	
	}
	
	class CheckLoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				email = textField.getText();
				passwordEncrypt = passwordField.getPassword();
				password = String.valueOf(passwordEncrypt);
				RegisteredUser rU = dbControl.getRegisteredUser(email, password);
				if(Objects.isNull(rU)) {
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
					frame.dispose();
					RUserLoginGUI loginGUI = new RUserLoginGUI(dbControl);
					loginGUI.frame.setVisible(true);
				}
				else {
					frame.dispose();
					TheatreGUI theatreGUI = new TheatreGUI(dbControl);
					theatreGUI.frame.setVisible(true);
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
