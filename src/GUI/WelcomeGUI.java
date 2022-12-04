import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

public class WelcomeGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeGUI window = new WelcomeGUI();
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
	public WelcomeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 157);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(244, 11, 179, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancelPayment = new JButton("Continue as guest");
		btnCancelPayment.setBounds(191, 80, 140, 23);
		frame.getContentPane().add(btnCancelPayment);
		
		JButton btnMakePayment = new JButton("Create Account");
		btnMakePayment.setBounds(49, 80, 132, 23);
		frame.getContentPane().add(btnMakePayment);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(341, 80, 141, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnLogin_1 = new JButton("Cancel Ticket");
		btnLogin_1.setBounds(492, 80, 140, 23);
		frame.getContentPane().add(btnLogin_1);
	}
}
