package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import controllers.AccountController;
import controllers.BrowsingController;
import controllers.CancellationController;
import controllers.DatabaseController;
import controllers.MovieTheatreApp;
import controllers.PaymentController;
import entities.Showtime;
import entities.Ticket;

import javax.swing.JButton;

public class PaymentGUI {

	public JFrame frame;
	public static Showtime time;
	public static int seatNumber, id;
	public static DatabaseController dbControl;
	public static String email, movieName;
	boolean userStatus;
	Random random = new Random();
	public static int randomNumber;
	public static String theatre;
	public static LocalDate datePur;
	public static double price;
	public static String showID;
	public static LocalDateTime movieShowTime;
	public MovieTheatreApp app;
	public static AccountController accControl;
	public BrowsingController brControl;
	public CancellationController canControl;
	public PaymentController payControl; 
		
	public PaymentGUI(DatabaseController dbControl, Showtime time, int seatNumber, int id, String movieName) {
		PaymentGUI.dbControl = dbControl;
		PaymentGUI.time = time;
		PaymentGUI.seatNumber = seatNumber;
		PaymentGUI.id = id;
		PaymentGUI.movieName = movieName;
		email = RUserLoginGUI.email;
		userStatus = dbControl.checkRegisterStatus(email);
		

		if(userStatus) {
			frame = new JFrame();
			frame.setBounds(100, 100, 500, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Payment");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblNewLabel.setBounds(200, 11, 119, 36);
			frame.getContentPane().add(lblNewLabel);
			
			JButton btnUseCreditCard = new JButton("Use Credit Card");
			btnUseCreditCard.addActionListener(new PaymentUserListener());
			btnUseCreditCard.setBounds(100, 130, 130, 23);
			frame.getContentPane().add(btnUseCreditCard);
			
			JButton btnVoucher = new JButton("Use Voucher");
			btnVoucher.addActionListener(new VoucherListener());
			btnVoucher.setBounds(250, 130, 130, 23);
			frame.getContentPane().add(btnVoucher);
			
		}
		else {
			frame = new JFrame();
			frame.setBounds(100, 100, 500, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Payment");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblNewLabel.setBounds(200, 11, 119, 36);
			frame.getContentPane().add(lblNewLabel);
			
			JButton btnUseCreditCard = new JButton("Use Credit Card");
			btnUseCreditCard.addActionListener(new PaymentGuestUserListener());
			btnUseCreditCard.setBounds(100, 130, 130, 23);
			frame.getContentPane().add(btnUseCreditCard);
			
			JButton btnVoucher = new JButton("Use Voucher");
			btnVoucher.addActionListener(new VoucherListener());
			btnVoucher.setBounds(250, 130, 130, 23);
			frame.getContentPane().add(btnVoucher);
		}
	}
	class PaymentUserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
					email = RUserLoginGUI.email;
					randomNumber = random.nextInt(1000000000);
					theatre = "Cineplex Odeon";
					datePur = LocalDate.now();
					price = 20;
					showID = Integer.toString(id);
					movieShowTime = time.getShowingTime();
					Ticket temp = new Ticket(randomNumber, seatNumber, showID, movieName, theatre, datePur, movieShowTime, email, price);
					dbControl.addTicket(temp);
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Your seat has been booked and you have been charged from the saved credit card in your account. Please check your email for the ticket. Thank you!", "Payment Confirmed!", JOptionPane.INFORMATION_MESSAGE);
					WelcomeGUI afterRegistration= new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
					afterRegistration.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class PaymentGuestUserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				MakePaymentGUI guestPay = new MakePaymentGUI(dbControl, time, seatNumber, id, movieName);
				guestPay.frame.setVisible(true);	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class VoucherListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
					frame.dispose();
					datePur = LocalDate.now();
					theatre = "Cineplex Odeon";
					datePur = LocalDate.now();
					price = 20;
					showID = Integer.toString(id);
					movieShowTime = time.getShowingTime();
					VoucherGUI voucherUse = new VoucherGUI(dbControl, randomNumber, seatNumber, showID, movieName, theatre, datePur, movieShowTime, email, price, time);
					voucherUse.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}


