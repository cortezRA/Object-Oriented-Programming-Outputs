package OE8_Cortez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

public class Welcome extends JFrame {

	private JPanel contentPane;
	public static Welcome frame = new Welcome("Anonymous");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome(String username) {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel(username);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 36));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(203, 35, 250, 59);
		contentPane.add(lblUsername);
		
		JLabel lblWelcome = new JLabel("WELCOME,");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Calibri", Font.BOLD, 36));
		lblWelcome.setBounds(21, 35, 189, 59);
		contentPane.add(lblWelcome);
	}
}
