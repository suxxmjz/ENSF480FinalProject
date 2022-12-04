import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PaymentGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentGUI window = new PaymentGUI();
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
	public PaymentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		textField = new JTextField();
		textField.setBounds(128, 71, 163, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(45, 99, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(45, 135, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 108, 163, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 144, 163, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Card Number");
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(45, 171, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Address");
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(45, 207, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 180, 163, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 216, 300, 20);
		frame.getContentPane().add(textField_4);
		
		JButton btnCancelPayment = new JButton("Cancel payment");
		btnCancelPayment.setBounds(267, 254, 126, 23);
		frame.getContentPane().add(btnCancelPayment);
		
		JButton btnMakePayment = new JButton("Make payment");
		btnMakePayment.setBounds(128, 254, 119, 23);
		frame.getContentPane().add(btnMakePayment);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/visa.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(432, 248, 77, 29);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
