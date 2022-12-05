package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import entities.RegisteredUser;
import javax.swing.JButton;

public class CreateAccountGUI {

	public JFrame frame;
	public static JTextField firstName;
	public static JTextField lastName;
	public static JTextField Email;
	public static JTextField Address;
	public static JTextField CardNum;
	public static JTextField Password;
	public static String fName, lName, address, email, password;
	public static int cardNum;
	public MovieTheatreApp app;
	public static DatabaseController dbControl;
	public static AccountController accControl;
	public BrowsingController brControl;
	public CancellationController canControl;
	public PaymentController payControl; 

	public CreateAccountGUI(DatabaseController dbControl, AccountController accountController) {
		CreateAccountGUI.dbControl = dbControl;
		CreateAccountGUI.accControl = accountController;
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 72, 84, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(124, 81, 163, 20);
		frame.getContentPane().add(firstName);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(41, 109, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(124, 118, 163, 20);
		frame.getContentPane().add(lastName);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(41, 145, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(124, 154, 163, 20);
		frame.getContentPane().add(Email);
		
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Address");
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(41, 256, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(124, 265, 300, 20);
		frame.getContentPane().add(Address);
		
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCreateAccount.setBounds(151, 22, 173, 36);
		frame.getContentPane().add(lblCreateAccount);
				
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Password");
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_3.setBounds(41, 182, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_3);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(124, 191, 163, 20);
		frame.getContentPane().add(Password);
		
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Card Number");
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(41, 218, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		CardNum = new JTextField();
		CardNum.setColumns(10);
		CardNum.setBounds(124, 229, 163, 20);
		frame.getContentPane().add(CardNum);
		
		
		JLabel lblNewLabel = new JLabel("As you create an account you will be charged with an annual fee of $20");
		lblNewLabel.setBounds(41, 329, 423, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCreateAcc = new JButton("Create Account");
		btnCreateAcc.addActionListener(new MakeCreateAccountListener());
		btnCreateAcc.setBounds(173, 296, 129, 23);
		frame.getContentPane().add(btnCreateAcc);
	}
	
	static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^0-9]", " "); // regular expression
 
        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");
 
        if (str.equals(""))
            return "-1";
 
        return str;
    }
		
	class MakeCreateAccountListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fName = firstName.getText();
				lName = lastName.getText();
				email = Email.getText();
				address = Address.getText();
				password = Password.getText();
				cardNum = Integer.parseInt(extractInt(CardNum.getText()).replace(" ",""));
				RegisteredUser temp = new RegisteredUser(fName, lName, address, email, password, cardNum);
				dbControl.addRegisteredUser(temp);
				frame.dispose();
				WelcomeGUI afterRegistration= new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
				afterRegistration.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
