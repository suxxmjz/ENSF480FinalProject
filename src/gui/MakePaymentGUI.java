package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.AccountController;
import controllers.BrowsingController;
import controllers.CancellationController;
import controllers.DatabaseController;
import controllers.MovieTheatreApp;
import controllers.PaymentController;
import entities.Showtime;
import entities.Ticket;

public class MakePaymentGUI {

	public JFrame frame;
	public static JTextField firstName;
	public static JTextField lastName;
	public static JTextField Email;
	public static JTextField Address;
	public static JTextField CardNum;
	public static String fName, lName, address, email, movieName;
	public static int cardNum, seatNumber, id;
	public static DatabaseController dbControl;
	public static Showtime time;
	public MovieTheatreApp app;
	public static AccountController accControl;
	public BrowsingController brControl;
	public CancellationController canControl;
	public PaymentController payControl; 

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
	
	public MakePaymentGUI(DatabaseController dbControl, Showtime time, int seatNumber, int id, String movieName) {
		MakePaymentGUI.dbControl = dbControl;
		MakePaymentGUI.time = time;
		MakePaymentGUI.seatNumber = seatNumber;
		MakePaymentGUI.id = id;
		MakePaymentGUI.movieName = movieName;
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(200, 11, 119, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 62, 84, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		firstName = new JTextField();
		firstName.setBounds(128, 71, 163, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(45, 99, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(45, 135, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(128, 108, 163, 20);
		frame.getContentPane().add(lastName);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(128, 144, 163, 20);
		frame.getContentPane().add(Email);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Card Number");
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(45, 171, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Address");
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(45, 207, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		
		CardNum = new JTextField();
		CardNum.setColumns(10);
		CardNum.setBounds(128, 180, 163, 20);
		frame.getContentPane().add(CardNum);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(128, 216, 300, 20);
		frame.getContentPane().add(Address);
		
		JButton btnCancelPayment = new JButton("Cancel payment");
		btnCancelPayment.setBounds(267, 254, 126, 23);
		frame.getContentPane().add(btnCancelPayment);
		
		JButton btnMakePayment = new JButton("Make payment");
		btnMakePayment.addActionListener(new MakeCreateAccountListener());
		btnMakePayment.setBounds(128, 254, 119, 23);
		frame.getContentPane().add(btnMakePayment);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/visa.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(432, 248, 77, 29);
		frame.getContentPane().add(lblNewLabel_2);
	}
	
	class MakeCreateAccountListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				email = Email.getText();
				Random random = new Random();
				int randomNumber = random.nextInt(1000000000);
				String theatre = "Cineplex Odeon";
				LocalDate datePur = LocalDate.now();
				double price = 20;
				String showID = Integer.toString(id);
				LocalDateTime movieShowTime = time.getShowingTime();
				Ticket temp = new Ticket(randomNumber, seatNumber, showID, movieName, theatre, datePur, movieShowTime, email, price);
				dbControl.addTicket(temp);
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Your seat has been booked. Please check your email for the ticket. Thank you!", "Payment Confirmed!", JOptionPane.INFORMATION_MESSAGE);
				WelcomeGUI afterRegistration= new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
				afterRegistration.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
