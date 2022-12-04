package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.DatabaseController;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TheatreGUI {

	public JFrame frame;
	public static DatabaseController dbControl;

	public TheatreGUI(DatabaseController dbControl) {
		TheatreGUI.dbControl = dbControl;
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAvailableTheatre = new JLabel("Available Theatre");
		lblAvailableTheatre.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAvailableTheatre.setBounds(155, 0, 204, 71);
		frame.getContentPane().add(lblAvailableTheatre);
		
		JButton btnNewButton = new JButton("Select Theatre");
		btnNewButton.addActionListener(new SelectListener());
		btnNewButton.setBounds(195, 279, 125, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/theatre.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(103, 58, 308, 210);
		frame.getContentPane().add(lblNewLabel);
	}
	
	class SelectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				MovieGUI movieGUI = new MovieGUI(dbControl);
				movieGUI.frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
