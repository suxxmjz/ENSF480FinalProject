import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RUserLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RUserLogin window = new RUserLogin();
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
	public RUserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 226);
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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(158, 153, 84, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 105, 163, 20);
		frame.getContentPane().add(passwordField);
	}
}
