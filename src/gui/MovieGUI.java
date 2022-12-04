import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MovieGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieGUI window = new MovieGUI();
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
	public MovieGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		boolean userStatus = false;
		if(userStatus) {
			frame = new JFrame();
			frame.setBounds(100, 100, 1100, 556);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Movies");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
			lblNewLabel.setBounds(481, 11, 122, 71);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("");
			Image img1 = new ImageIcon(this.getClass().getResource("/img1.jpg")).getImage();
			lblNewLabel_1.setIcon(new ImageIcon(img1));
			lblNewLabel_1.setBounds(127, 78, 190, 278);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_3 = new JLabel("Details");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_3.setBounds(127, 362, 93, 14);
			frame.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_5 = new JLabel("The Dark Knight");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(127, 380, 190, 14);
			frame.getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_5_1 = new JLabel("Slot 1: 2:00 PM");
			lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_1.setBounds(127, 398, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_1);
			
			JLabel lblNewLabel_5_2 = new JLabel("Slot 2: 5:00 PM");
			lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_2.setBounds(127, 416, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_2);
			
			JLabel lblNewLabel_5_3 = new JLabel("Slot 3: 10:00 PM");
			lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_3.setBounds(127, 435, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_3);
			
			JLabel lblNewLabel_2 = new JLabel("");
			Image img2 = new ImageIcon(this.getClass().getResource("/img2.jpg")).getImage();
			lblNewLabel_2.setIcon(new ImageIcon(img2));
			lblNewLabel_2.setBounds(442, 78, 190, 278);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3_1 = new JLabel("Details");
			lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_3_1.setBounds(442, 362, 93, 14);
			frame.getContentPane().add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5_4 = new JLabel("Dragon Ball Super Broly");
			lblNewLabel_5_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_4.setBounds(442, 380, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_4);
			
			JLabel lblNewLabel_5_1_1 = new JLabel("Slot 4: 3:00 PM");
			lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_1_1.setBounds(442, 398, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_1_1);
			
			JLabel lblNewLabel_5_2_1 = new JLabel("Slot 5: 7:00 PM");
			lblNewLabel_5_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_2_1.setBounds(442, 416, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_2_1);
			
			JLabel lblNewLabel_5_3_1 = new JLabel("Slot 6: 11:30 PM");
			lblNewLabel_5_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_3_1.setBounds(442, 435, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_3_1);
			
			JLabel lblNewLabel_6 = new JLabel("");
			Image img3 = new ImageIcon(this.getClass().getResource("/img3.jpg")).getImage();
			lblNewLabel_6.setIcon(new ImageIcon(img3));
			lblNewLabel_6.setBounds(754, 78, 200, 278);
			frame.getContentPane().add(lblNewLabel_6);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Details");
			lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_3_1_1.setBounds(754, 362, 93, 14);
			frame.getContentPane().add(lblNewLabel_3_1_1);
			
			JLabel lblNewLabel_5_4_1 = new JLabel("The Wolf of Wall Street");
			lblNewLabel_5_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_4_1.setBounds(754, 380, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_4_1);
			
			JLabel lblNewLabel_5_1_1_1 = new JLabel("Slot 7: 11:00 AM");
			lblNewLabel_5_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_1_1_1.setBounds(754, 398, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_1_1_1);
			
			JLabel lblNewLabel_5_2_1_1 = new JLabel("Slot 8: 4:00 PM");
			lblNewLabel_5_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_2_1_1.setBounds(754, 416, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_2_1_1);
			
			JLabel lblNewLabel_5_3_1_1 = new JLabel("Slot 9: 1:00 AM");
			lblNewLabel_5_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_3_1_1.setBounds(754, 435, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_3_1_1);
			
			JLabel lblNewLabel_4 = new JLabel("Please select the slot you want (ex: Slot 1):");
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(372, 478, 260, 14);
			frame.getContentPane().add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(642, 476, 50, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
		}
		
		else {
			frame = new JFrame();
			frame.setBounds(100, 100, 800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Movies");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
			lblNewLabel.setBounds(320, 11, 122, 71);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("");
			Image img1 = new ImageIcon(this.getClass().getResource("/img1.jpg")).getImage();
			lblNewLabel_1.setIcon(new ImageIcon(img1));
			lblNewLabel_1.setBounds(127, 78, 190, 278);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_3 = new JLabel("Details");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_3.setBounds(127, 362, 93, 14);
			frame.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_5 = new JLabel("The Dark Knight");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5.setBounds(127, 380, 190, 14);
			frame.getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_5_1 = new JLabel("Slot 1: 2:00 PM");
			lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_1.setBounds(127, 398, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_1);
			
			JLabel lblNewLabel_5_2 = new JLabel("Slot 2: 5:00 PM");
			lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_2.setBounds(127, 416, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_2);
			
			JLabel lblNewLabel_5_3 = new JLabel("Slot 3: 10:00 PM");
			lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_3.setBounds(127, 435, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_3);
			
			JLabel lblNewLabel_2 = new JLabel("");
			Image img2 = new ImageIcon(this.getClass().getResource("/img2.jpg")).getImage();
			lblNewLabel_2.setIcon(new ImageIcon(img2));
			lblNewLabel_2.setBounds(442, 78, 190, 278);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3_1 = new JLabel("Details");
			lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_3_1.setBounds(442, 362, 93, 14);
			frame.getContentPane().add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5_4 = new JLabel("Dragon Ball Super Broly");
			lblNewLabel_5_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_4.setBounds(442, 380, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_4);
			
			JLabel lblNewLabel_5_1_1 = new JLabel("Slot 4: 3:00 PM");
			lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_1_1.setBounds(442, 398, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_1_1);
			
			JLabel lblNewLabel_5_2_1 = new JLabel("Slot 5: 7:00 PM");
			lblNewLabel_5_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_2_1.setBounds(442, 416, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_2_1);
			
			JLabel lblNewLabel_5_3_1 = new JLabel("Slot 6: 11:30 PM");
			lblNewLabel_5_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_5_3_1.setBounds(442, 435, 190, 14);
			frame.getContentPane().add(lblNewLabel_5_3_1);
			
			JLabel lblNewLabel_4 = new JLabel("Please select the slot you want (ex: Slot 1):");
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(150, 478, 260, 14);
			frame.getContentPane().add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(430, 476, 50, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
		}
	}
}
