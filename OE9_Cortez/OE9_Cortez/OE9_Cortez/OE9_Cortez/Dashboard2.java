package OE9_Cortez;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentNo;
	private JTextField txtStudentName;
	private JComboBox txtGender;
	private JTextField txtAddress;
	private JTable table;
	private JTextField txtSearch;
	private JTextField txtContactNo;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard2 frame = new Dashboard2("Anonymous");
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
	public Dashboard2(String username) {
		initialize(username);
		Clock();
		viewRecords();
	}
	
	private void initialize(String s) {
		setTitle("STUDENT RECORD SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ADD/CREATE button
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord(); //call to the add method
				viewRecords(); // call to view method
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(25, 267, 170, 30);
		contentPane.add(btnAdd);
		
		// CLEAR button
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Calibri", Font.BOLD, 18));
		btnClear.setForeground(Color.BLACK);
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField(); // call to the clear method
				btnAdd.setEnabled(true);
			}
		});
		btnClear.setBounds(211, 267, 170, 30);
		contentPane.add(btnClear);
		
		// UPDATE BUTTON
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {
					updateRecord(txtStudentNo.getText()); // call to the update method
					btnAdd.setEnabled(true);
					viewRecords();
				}
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 18));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(25, 308, 170, 30);
		contentPane.add(btnUpdate);
		
		// DELETE BUTTON
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {
					deleteRecord(txtStudentNo.getText()); // call to the delete method
					btnAdd.setEnabled(true);
					viewRecords();
				}	
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 18));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(211, 308, 170, 30);
		contentPane.add(btnDelete);
		
		// EXIT BUTTON
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
		btnExit.setBounds(25, 349, 356, 30);
		contentPane.add(btnExit);
		
		JLabel lblUsername = new JLabel(s);
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
		txtAddress.setBounds(131, 209, 235, 25);
		contentPane.add(txtAddress);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(410, 104, 564, 308);
		contentPane.add(scrollPane);
		
		//Table EVENT PROCEDURE ONCLICK
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtStudentNo.setEnabled(false);
				btnAdd.setEnabled(false);
				String id = table.getValueAt(table.getSelectedRow(), 0).toString();
				transformData(id);
			}
		});
		
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
		lblAddress.setBounds(20, 210, 101, 25);
		contentPane.add(lblAddress);
		
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
		
		txtGender = new JComboBox();
		txtGender.setModel(new DefaultComboBoxModel(new String[] {"--", "Male", "Female", "Others"}));
		txtGender.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtGender.setBounds(131, 173, 150, 25);
		contentPane.add(txtGender);
		
		txtContactNo = new JTextField();
		txtContactNo.setForeground(Color.BLACK);
		txtContactNo.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtContactNo.setBounds(131, 137, 200, 25);
		contentPane.add(txtContactNo);
		
		lblClock = new JLabel("Time: ");
		lblClock.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblClock.setForeground(Color.WHITE);
		lblClock.setBounds(24, 400, 235, 25);
		contentPane.add(lblClock);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblGender.setBounds(20, 173, 101, 25);
		contentPane.add(lblGender);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactNumber.setForeground(Color.WHITE);
		lblContactNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblContactNumber.setBounds(20, 137, 101, 25);
		contentPane.add(lblContactNumber);
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
			String sql = "INSERT INTO students_tbl (student_no,student_name,gender,contact_no,address,date_created) VALUES (?,?,?,?,?,NOW())";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			if(txtStudentNo.getText().isEmpty() || txtStudentName.getText().isEmpty() || txtAddress.getText().isEmpty() 
					|| txtContactNo.getText().isEmpty() || txtGender.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Student details incomplete", "Student Record Error", 0);
			} else {
				ps.setString(1, txtStudentNo.getText());
				ps.setString(2, txtStudentName.getText());
				ps.setString(3, txtGender.getSelectedItem().toString());
				ps.setString(4, txtContactNo.getText());
				ps.setString(5, txtAddress.getText());
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Record successfully added...");
				clearTextField();
			}
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
	
	//VIEW record method
	private void viewRecords() {
		Connection con = connect();
		DefaultTableModel mod = new DefaultTableModel();
		
		mod.addColumn("ID");
		mod.addColumn("Student Number");
		mod.addColumn("Student Name");
		mod.addColumn("Gender");
		mod.addColumn("Contact No");
		mod.addColumn("Address");
		mod.addColumn("Date of Registration");
		mod.addColumn("Last Update on Record");
		
		try {
			String sql = "SELECT * FROM students_tbl";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				mod.addRow(new Object[] {
					rs.getInt("id"),
					rs.getString("student_no"),
					rs.getString("student_name"),
					rs.getString("gender"),
					rs.getString("contact_no"),
					rs.getString("address"),
					rs.getString("date_created"),
					rs.getString("date_updated"),
					
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(mod);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(85);
			table.getColumnModel().getColumn(5).setPreferredWidth(200);
			table.getColumnModel().getColumn(6).setPreferredWidth(135);
			table.getColumnModel().getColumn(7).setPreferredWidth(135);
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
	
	//DELETE record method
	private void deleteRecord(String id) {
		Connection con = connect();
		
		try {
			String sql = "DELETE FROM students_tbl WHERE student_no = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Record successfully deleted...");
			clearTextField();
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
	
	//UPDATE record method
	private void updateRecord(String id) {
		Connection con = connect();
		
		try {
			String sql = "UPDATE students_tbl SET student_no = ?,student_name = ?, gender = ?, contact_no = ?, address = ? WHERE student_no = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, txtStudentNo.getText());
			ps.setString(2, txtStudentName.getText());
			ps.setString(3, txtGender.getSelectedItem().toString());
			ps.setString(4, txtContactNo.getText());
			ps.setString(5, txtAddress.getText());
			ps.setString(6, id);
			ps.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Record successfully updated...");
			clearTextField();
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
	
	//CLICK EVENT FROM TABLE TO INPUT FIELDS
	private void transformData(String id) {
		Connection con = connect();
		
		try {
			String sql = "SELECT * FROM students_tbl WHERE id = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				txtStudentNo.setText(rs.getString("student_no"));
				txtStudentName.setText(rs.getString("student_name"));
				txtGender.setSelectedItem(rs.getString("gender"));
				txtContactNo.setText(rs.getString("contact_no"));
				txtAddress.setText(rs.getString("address"));
			}
		} catch(Exception e) {
			System.out.println("Error..." + e);
		}
	}
	
	//CLEAR method
	private void clearTextField() {
		txtStudentNo.setText("");
		txtStudentNo.setEnabled(true);
		txtStudentName.setText("");
		txtGender.setSelectedItem("--");
		txtContactNo.setText("");
		txtAddress.setText("");
	}
	
	//TIME and DATE method
	public void Clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar c1 = new GregorianCalendar();
						
						//DATE variables
						int day = c1.get(Calendar.DAY_OF_MONTH);
						String day2 = Integer.toString(day).format("%02d", day);
						int month = c1.get(Calendar.MONTH) + 1;
						String month2 = Integer.toString(month).format("%02d", month);
						int year = c1.get(Calendar.YEAR);
						
						//TIME variables
						int sec = c1.get(Calendar.SECOND);
						String sec2 = Integer.toString(sec).format("%02d", sec);
						int min = c1.get(Calendar.MINUTE);
						String min2 = Integer.toString(min).format("%02d", min);
						int hr = c1.get(Calendar.HOUR_OF_DAY);
						String hr2 = Integer.toString(hr).format("%02d", hr);
						
						lblClock.setText("Time : " + hr2 + ":" + min2 + ":" + sec2 + " | Date : " + month2 + "/" + day2 + "/" + year);
						sleep(1000);
					}
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
}
