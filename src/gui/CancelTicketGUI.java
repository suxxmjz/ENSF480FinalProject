package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CancelTicketGUI {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CancelTicketGUI window = new CancelTicketGUI();
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
    public CancelTicketGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 208);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCancelTicket = new JLabel("Cancel Ticket");
        lblCancelTicket.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblCancelTicket.setBounds(136, 11, 155, 36);
        frame.getContentPane().add(lblCancelTicket);

        JLabel lblNewLabel = new JLabel("Ticket Number");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(53, 66, 93, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email Address");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(53, 101, 93, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(146, 64, 219, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(146, 99, 220, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBounds(172, 130, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }
}