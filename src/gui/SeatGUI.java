package gui;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;

public class SeatGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatGUI window = new SeatGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeatGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		for(int i = 43; i < 500; i+=100) {
			for(int j = 240; j < 600; j+=110) {
				JButton btnNewButton_1 = new JButton("Seat " + k);
				//boolean status = Showtime.getSeatStatus(k);
				boolean status = true;
				if (status) {
					btnNewButton_1.setBounds(i, j, 80, 28);
					btnNewButton_1.setBackground(Color.GREEN);
					frame.getContentPane().add(btnNewButton_1);
				}else {
					btnNewButton_1.setBounds(i, j, 80, 28);
					btnNewButton_1.setBackground(Color.RED);
					frame.getContentPane().add(btnNewButton_1);
				}
				
				k = k + 1;
			}	
		}
	}
}
