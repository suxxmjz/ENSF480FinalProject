package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
import entities.Voucher;

public class VoucherGUI {

	public JFrame frame;
	public static DatabaseController dbControl;
    public JTextField textField;
    public JTextField textField_1;
    public static String email, voucher;
    public static MovieTheatreApp app;
	public static AccountController accControl;
	public static BrowsingController brControl;
	public static CancellationController canControl;
	public static PaymentController payControl;
	double checkStatus;
	public static String showID, movieName, theatre;
	public static int randomNumber, seatNumber;
	public static LocalDate datePur;
	public static LocalDateTime movieShowTime;
	public static double price;
	public static Showtime time;
	
	public VoucherGUI(DatabaseController dbControl, int randomNumber, int seatNumber, String showID, String movieName, String theatre, LocalDate datePur, LocalDateTime movieShowTime, String email, double price, Showtime time) {
		VoucherGUI.dbControl = dbControl;
		VoucherGUI.randomNumber = randomNumber;
		VoucherGUI.seatNumber = seatNumber;
		VoucherGUI.showID = showID;
		VoucherGUI.movieName = movieName;
		VoucherGUI.theatre = theatre;
		VoucherGUI.datePur = datePur;
		VoucherGUI.movieShowTime = movieShowTime;
		VoucherGUI.email = email;
		VoucherGUI.price = price;
		VoucherGUI.time = time;
		frame = new JFrame();
        frame.setBounds(100, 100, 450, 208);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCancelTicket = new JLabel("Apply Voucher");
        lblCancelTicket.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblCancelTicket.setBounds(136, 11, 180, 36);
        frame.getContentPane().add(lblCancelTicket);

        JLabel lblNewLabel = new JLabel("Voucher Number");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(53, 66, 105, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email Address");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(53, 101, 105, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(160, 64, 219, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(160, 99, 220, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new VoucherListener());
        btnNewButton.setBounds(172, 130, 89, 23);
        frame.getContentPane().add(btnNewButton);
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
	
	class VoucherListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				//Check for the email and ticket in database then do the stuff below
				//Also cancel the current ticket from the database
				//Also make the seat available in the database.
				
				voucher = textField.getText();
				int id = Integer.parseInt(extractInt(voucher));
				email = textField_1.getText();
				if(email.equals("") || voucher.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid input", "Invalid Input", JOptionPane.ERROR_MESSAGE);
					}
				else {
					Voucher temp = dbControl.getVoucher(id, email);
					if (temp == null) {
						JOptionPane.showMessageDialog(null, "Invalid Input!", "Error Message", JOptionPane.ERROR_MESSAGE);
					}
					else {
						checkStatus = dbControl.validateVoucher(temp);
						System.out.println(checkStatus);
						if(checkStatus != -1){
							if (temp.getAmount() == 20) {
								dbControl.deleteVoucher(temp);
								
								Ticket tempTicket = new Ticket(randomNumber, seatNumber, showID, movieName, theatre, datePur, movieShowTime, email, price);
								dbControl.addTicket(tempTicket);			
								JOptionPane.showMessageDialog(null, "Booking Complete! Please check your email for the ticket.", "Voucher Info", JOptionPane.PLAIN_MESSAGE);
								frame.dispose();
								WelcomeGUI afterRegistration= new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
								afterRegistration.frame.setVisible(true);
							}
							
							else if (temp.getAmount() == 17) {
								dbControl.deleteVoucher(temp);
								JOptionPane.showMessageDialog(null, "Voucher Applied, please pay remaining amount!", "Voucher Info", JOptionPane.PLAIN_MESSAGE);
								frame.dispose();
								MakePaymentGUI guestPay = new MakePaymentGUI(dbControl, time, seatNumber, id, movieName);
								guestPay.frame.setVisible(true);
							}
				        }
				        else{
				        	frame.dispose();
				        	JOptionPane.showMessageDialog(null, "Voucher is Invalid!", "Voucher Info", JOptionPane.ERROR_MESSAGE);
							WelcomeGUI afterRegistration= new WelcomeGUI(app, dbControl, accControl, brControl, canControl, payControl);
							afterRegistration.frame.setVisible(true);
				        }						
					}	
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
