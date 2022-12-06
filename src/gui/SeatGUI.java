package gui;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controllers.DatabaseController;
import entities.Seat;
import entities.Showtime;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class SeatGUI {

	public JFrame frame;
	public static DatabaseController dbControl;
	public static int id;
	public static ArrayList<Seat> seats;
	public static boolean status;
	public static String movieName, email;

	public SeatGUI(DatabaseController dbControl, int id, String movieName) {
		SeatGUI.id = id;
		SeatGUI.dbControl = dbControl;
		SeatGUI.movieName = movieName;
		Showtime temp = dbControl.getShowTime(id);
		seats = dbControl.getAllSeats(temp);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 600, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seat Selection");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(227, 11, 129, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Screen");
		lblNewLabel_3.setBounds(260, 96, 60, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(191, 57, 201, 100);
		Image img2 = new ImageIcon(this.getClass().getResource("/screen.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		for(int i = 50; i < 500; i+=100) {
			for(int j = 170; j < 540; j+=110) {
				JLabel lblNewLabel_1 = new JLabel("");
				Image img1 = new ImageIcon(this.getClass().getResource("/seat.png")).getImage();
				lblNewLabel_1.setIcon(new ImageIcon(img1));
				lblNewLabel_1.setBounds(i, j, 72, 65);
				frame.getContentPane().add(lblNewLabel_1);
			}
		}
		int k = 1;
		int l = 0;
		for(int i = 43; i < 500; i+=100) {
			for(int j = 240; j < 600 && l < seats.size(); j+=110) {
				JButton btnNewButton_1 = new JButton("Seat " + k);
				status = seats.get(l).available();
				if (status) {
					btnNewButton_1.setBounds(i, j, 80, 28);
					btnNewButton_1.addActionListener(new BookingListener());
					btnNewButton_1.setBackground(Color.GREEN);
					frame.getContentPane().add(btnNewButton_1);
				}else {
					btnNewButton_1.setBounds(i, j, 80, 28);
					btnNewButton_1.setBackground(Color.RED);
					frame.getContentPane().add(btnNewButton_1);
				}
				l++;
				k = k + 1;
			}	
		}
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

	
	class BookingListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(status) {
					JButton temp = (JButton) e.getSource();
					String text = temp.getText();
					int seatNum = Integer.parseInt(extractInt(text).replace(" ",""));
					Showtime time = dbControl.getShowTime(id);
					dbControl.changeToBooked(time, seatNum);
					frame.dispose();
					PaymentGUI paymentGUI = new PaymentGUI(dbControl, time, seatNum, id, movieName);
					paymentGUI.frame.setVisible(true);
				}
				else {
					JButton temp = (JButton) e.getSource();
					String text = temp.getText();
					int seatNum = Integer.parseInt(extractInt(text).replace(" ",""));
					Showtime time = dbControl.getShowTime(id);
					dbControl.changeToBooked(time, seatNum);				
					frame.dispose();
					PaymentGUI paymentGUI = new PaymentGUI(dbControl, time, seatNum, id, movieName);
					paymentGUI.frame.setVisible(true);
				}	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
