import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateAccountGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountGUI window = new CreateAccountGUI();
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
	public CreateAccountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 72, 84, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(124, 81, 163, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(41, 109, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(124, 118, 163, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(41, 145, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(124, 154, 163, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Address");
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(41, 256, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(124, 265, 300, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCreateAccount.setBounds(151, 22, 173, 36);
		frame.getContentPane().add(lblCreateAccount);
		
		JButton btnMakePayment = new JButton("Create Account");
		btnMakePayment.setBounds(173, 296, 129, 23);
		frame.getContentPane().add(btnMakePayment);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Password");
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_3.setBounds(41, 182, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(124, 191, 163, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Card Number");
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(41, 218, 84, 36);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(124, 229, 163, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel = new JLabel("As you create an account you will be charged with an annual fee of $20");
		lblNewLabel.setBounds(41, 329, 423, 14);
		frame.getContentPane().add(lblNewLabel);
	}

}
