package OE8_Cortez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	public static Login frame = new Login();
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pfPassword;
	public String username;

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
	public Login() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		txtUsername.setBounds(115, 116, 250, 24);
		contentPane.add(txtUsername);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		pfPassword.setBounds(115, 184, 250, 24);
		pfPassword.setForeground(Color.BLACK);
		contentPane.add(pfPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/copl_db";
				String user = "root";
				
				try {
					Class.forName(driver);
					Connection con = (Connection) DriverManager.getConnection(url,user,"");
					String query = "SELECT * FROM users_tbl WHERE username = '"+ txtUsername.getText() +"' AND password = '"+ String.valueOf(pfPassword.getPassword()) +"'";
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "Login Successful...", "Login Alert", 1);
						username = txtUsername.getText();
						new Welcome(username).setVisible(true);
						frame.setVisible(false);
						frame.dispose();
					} else if (txtUsername.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Username is required...", "Login Error", 0);
					} else if (String.valueOf(pfPassword.getPassword()).trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Password is required...", "Login Error", 0);
					} else {
						JOptionPane.showMessageDialog(null, "Username or Password entered is incorrect...", "Login Error", 0);
					}
				} catch (Exception f) {
					System.out.print(f);
				}
			}
		});
		btnLogin.setBounds(276, 250, 89, 23);
		btnLogin.setBackground(Color.WHITE);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(btnClose, "Do you want to exit the program?", "Exit", 0);
				if (x == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnClose.setBounds(115, 250, 89, 23);
		btnClose.setBackground(Color.WHITE);
		contentPane.add(btnClose);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Calibri", Font.BOLD, 36));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(143, 25, 193, 44);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(115, 90, 137, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblPassword.setBounds(115, 160, 137, 24);
		contentPane.add(lblPassword);
	}
}
