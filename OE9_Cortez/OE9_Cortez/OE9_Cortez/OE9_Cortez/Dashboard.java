package OE9_Cortez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentNo;
	private JTextField txtStudentName;
	private JTextField txtAddress;
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("Anonymous");
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
	public Dashboard(String username) {
		setTitle("STUDENT RECORD SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel(username);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(780, 17, 194, 25);
		contentPane.add(lblUsername);
		
		txtStudentNo = new JTextField();
		txtStudentNo.setForeground(Color.BLACK);
		txtStudentNo.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtStudentNo.setBounds(131, 65, 200, 25);
		contentPane.add(txtStudentNo);
		txtStudentNo.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setForeground(Color.BLACK);
		txtStudentName.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtStudentName.setBounds(131, 101, 200, 25);
		contentPane.add(txtStudentName);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.BLACK);
		txtAddress.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtAddress.setBounds(131, 137, 250, 25);
		contentPane.add(txtAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 104, 564, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblStudentRecordSystem = new JLabel("STUDENT RECORD SYSTEM");
		lblStudentRecordSystem.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentRecordSystem.setForeground(Color.WHITE);
		lblStudentRecordSystem.setFont(new Font("Calibri", Font.BOLD, 24));
		lblStudentRecordSystem.setBounds(10, 11, 274, 35);
		contentPane.add(lblStudentRecordSystem);
		
		JLabel lblStudentNo = new JLabel("Student Number:");
		lblStudentNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentNo.setForeground(Color.WHITE);
		lblStudentNo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStudentNo.setBounds(20, 65, 101, 25);
		contentPane.add(lblStudentNo);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblStudentName.setBounds(20, 101, 101, 25);
		contentPane.add(lblStudentName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAddress.setBounds(20, 137, 101, 25);
		contentPane.add(lblAddress);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Calibri", Font.BOLD, 18));
		btnClear.setForeground(Color.BLACK);
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField(); // call to the clear method
			}
		});
		btnClear.setBounds(211, 189, 170, 30);
		contentPane.add(btnClear);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecords();
			}
		});
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Calibri", Font.BOLD, 18));
		btnView.setBackground(Color.WHITE);
		btnView.setBounds(25, 230, 356, 30);
		contentPane.add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 18));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(25, 270, 356, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 18));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(25, 310, 356, 30);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(btnExit, "Do you want to exit the program?", "Exit", 0);
				if (x == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Calibri", Font.BOLD, 18));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(25, 350, 356, 30);
		contentPane.add(btnExit);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord(); //call to the add method
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(24, 190, 170, 30);
		contentPane.add(btnAdd);
		
		txtSearch = new JTextField();
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtSearch.setBounds(464, 66, 510, 25);
		contentPane.add(txtSearch);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSearch.setBounds(410, 66, 50, 25);
		contentPane.add(lblSearch);
		
		
	}
	
	//Database Connection
	static Connection connect() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/copl_db";
			String user = "root";
			
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, user, "");
		}catch(Exception e){
			System.out.println("Cannot connect to the database... " + e);
		}
		return null;
	}
	
	//ADD record method
	private void addRecord() {
		Connection con = connect();

		try {
			String sql = "INSERT INTO students_tbl (student_no,student_name,address,date_created) VALUES (?,?,?,NOW())";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			if(txtStudentNo.getText().isEmpty() || txtStudentName.getText().isEmpty() || txtAddress.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Student details incomplete", "Student Record Error", 0);
			} else {
				ps.setString(1, txtStudentNo.getText());
				ps.setString(2, txtStudentName.getText());
				ps.setString(3, txtAddress.getText());
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Record successfully added...");
				clearTextField();
			}
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
	
	//CLEAR method
	private void clearTextField() {
		txtStudentNo.setText("");
		txtStudentName.setText("");
		txtAddress.setText("");
	}
	
	//VIEW record method
	private void viewRecords() {
		Connection con = connect();
		DefaultTableModel mod = new DefaultTableModel();
		
		mod.addColumn("ID");
		mod.addColumn("Student Number");
		mod.addColumn("Student Name");
		mod.addColumn("Address");
		mod.addColumn("Date of Registration");
		
		try {
			String sql = "SELECT * FROM students_tbl";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mod.addRow(new Object[] {
					rs.getInt("id"),
					rs.getString("student_no"),
					rs.getString("student_name"),
					rs.getString("address"),
					rs.getString("date_created")
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(mod);
			table.setAutoResizeMode(5);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(20);
			table.getColumnModel().getColumn(2).setPreferredWidth(30);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(45);
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
}
