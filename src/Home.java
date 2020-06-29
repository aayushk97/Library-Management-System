

import LibraryManagementSystem.Student;
import LibraryManagementSystem.Search;
import LibraryManagementSystem.Librarian;
import LibraryManagementSystem.DB;
import LibraryManagementSystem.Admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Home extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;
	private Panel panel_7;
	Boolean menuBtn = false;
	private Panel panel;
	//Librarian Tab
	private Panel panel_3;
	//Student Tab
	private Panel panel_4;
	//Search Books Menu Button
	private Panel panel_8;
	//Search Magazine Menu Button
	private Panel panel_9;
	//Latest
	private Panel panel_10;
	//Get Alerts
	private Panel panel_11;
	//Contact info
	private Panel panel_12;
	//Admin Login
	private Panel panel_13;
	// username or password is incorrect
	private JLabel lblNewLabel_5;
	//Select Tab Librarian or Student
	private String tab = ""; 
	
	private DefaultTableModel model;
	private JScrollPane scroll;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setSize(800, 442);
					frame.setVisible(true);
					System.out.println("aaaa");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(71, 120, 197));
		panel.setBounds(0, 0, 782, 69);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		
		
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					panel_7.setVisible(!menuBtn);
					menuBtn = !menuBtn;
				
			}
		});
		System.out.println(getClass().getResource(""));
		lblNewLabel.setIcon(new ImageIcon("icon\\menu-button.png"));
		
		System.out.println(getClass().getResource("icon\\menu-button.png"));
		lblNewLabel.setBounds(720, 13, 50, 43);
		panel.add(lblNewLabel);
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(new Color(169, 169, 169));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 69, 782, 326);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setForeground(new Color(51, 102, 153));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(212, 46, 242, 257);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 50, 218, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 95, 218, 20);
		panel_2.add(passwordField);
		
		Panel panel_5 = new Panel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(tab.equals("Librarian") && textField.getText().equals("aayush") && String.valueOf(passwordField.getPassword()).equals("123")){
					System.out.println("OK");
					lblNewLabel_5.setVisible(false);
					Librarian l = new Librarian();
					l.setVisible(true);
				} else if( tab.equals("Student") && textField.getText().equals("student") && String.valueOf(passwordField.getPassword()).equals("1234")) {
					System.out.println("OK");
					lblNewLabel_5.setVisible(false);
					
					Student s = new Student();
					s.setVisible(true);
					System.out.println("OK");
					
				} else {
					System.out.println("Not Ok");
					lblNewLabel_5.setVisible(true);
				}
			}
		});
		panel_5.setBackground(new Color(65, 105, 225));
		panel_5.setBounds(12, 160, 218, 22);
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_5.add(lblNewLabel_2);
		
		Panel panel_6 = new Panel();
		// Clear the username and password field
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				passwordField.setText("");
				lblNewLabel_5.setVisible(false);
				
			}
		});
		
		
		
		
		panel_6.setBackground(new Color(65, 105, 225));
		panel_6.setBounds(12, 188, 218, 22);
		panel_2.add(panel_6);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setForeground(Color.WHITE);
		lblClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_6.add(lblClear);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(12, 30, 73, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 75, 73, 16);
		panel_2.add(lblPassword);
		
		lblNewLabel_5 = new JLabel("Username or password is incorrect");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(12, 128, 218, 16);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		panel_3 = new Panel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_3);
				resetColor(panel_4);
				tab = "Librarian";
				System.out.println(tab);
			}
		});
		panel_3.setBackground(new Color(65, 105, 225));
		panel_3.setBounds(212, 10, 120, 35);
		panel_1.add(panel_3);
		setColor(panel_3);
		tab = "Librarian";
		
		
		JLabel lblLibrarian = new JLabel("Librarian");
		lblLibrarian.setForeground(Color.WHITE);
		lblLibrarian.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblLibrarian);
		
		panel_4 = new Panel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_4);
				resetColor(panel_3);
				tab = "Student";
				System.out.println(tab);
			}
		});
		panel_4.setBackground(new Color(65, 105, 225));
		panel_4.setBounds(333, 10, 120, 35);
		panel_1.add(panel_4);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblStudent);
		
		//Menu Button
		panel_7 = new Panel();
		panel_7.setBackground(new Color(0, 102, 170));
		panel_7.setBounds(604, 0, 178, 326);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setVisible(menuBtn);
		
		//Search Button in Menu
		panel_8 = new Panel();
		panel_8.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_8);
				resetColor(new Panel[] {panel_9, panel_10, panel_11, panel_12, panel_13});
				
				Search s = new Search();
				s.setVisible(true);
				dispose();
				System.out.println("aaa");
			}
		});
		panel_8.setBackground(new Color(65, 105, 225));
		panel_8.setBounds(0, 50, 178, 28);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Search Books");
		lblNewLabel_3.setBounds(10, 5, 87, 16);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_8.add(lblNewLabel_3);
		
		
		//Search magazine Button
		panel_9 = new Panel();
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_9);
				resetColor(new Panel[] {panel_8, panel_10, panel_11, panel_12, panel_13});
				
				Search s = new Search();
				s.setVisible(true);
				dispose();
				System.out.println("aaa");
				
			}
		});
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(65, 105, 225));
		panel_9.setBounds(0, 79, 178, 28);
		panel_7.add(panel_9);
		
		JLabel lblSearchMagazine = new JLabel("Search Magazine");
		lblSearchMagazine.setForeground(Color.WHITE);
		lblSearchMagazine.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchMagazine.setBounds(10, 5, 122, 16);
		panel_9.add(lblSearchMagazine);
		
		//Latest Button
		panel_10 = new Panel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_10);
				resetColor(new Panel[] {panel_8, panel_9, panel_11, panel_12, panel_13});
				JFrame f = new JFrame();
				f.setTitle("Issued Books");
				
				model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[] { "Book Name", "Author", "Issue", "Username"});
			    
				
				Connection con=DB.getConnection();
				
				try {
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from books Order by issue DESC");
							while(rs.next()){
								model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),""+rs.getInt(4), rs.getString(5),""+rs.getInt(6) });
								
							}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				JTable j = new JTable(model);
			    scroll = new JScrollPane(j);
				scroll.setBounds( 231, 151, 441, 162 ); // x, y, width, height
				f.setSize(500, 250);
				f.add(scroll);
				
				scroll.setVisible(true);
			    f.setVisible(true);
			}
		});
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(65, 105, 225));
		panel_10.setBounds(0, 108, 178, 28);
		panel_7.add(panel_10);
		
		JLabel lblLatest = new JLabel("Latest");
		lblLatest.setForeground(Color.WHITE);
		lblLatest.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLatest.setBounds(10, 5, 122, 16);
		panel_10.add(lblLatest);
		
		//Get Alerts Button
		panel_11 = new Panel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_11);
				resetColor(new Panel[] {panel_8, panel_10, panel_9, panel_12, panel_13});
			}
		});
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(65, 105, 225));
		panel_11.setBounds(0, 137, 178, 28);
		panel_7.add(panel_11);
		
		JLabel lblGetAlerts = new JLabel("Get Alerts");
		lblGetAlerts.setForeground(Color.WHITE);
		lblGetAlerts.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGetAlerts.setBounds(10, 5, 122, 16);
		panel_11.add(lblGetAlerts);
		
		//Contact info button
		panel_12 = new Panel();
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_12);
				resetColor(new Panel[] {panel_8, panel_10, panel_11, panel_9, panel_13});
			}
		});
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(65, 105, 225));
		panel_12.setBounds(0, 166, 178, 28);
		panel_7.add(panel_12);
		
		JLabel lblContactInfo = new JLabel("Contact Info");
		lblContactInfo.setForeground(Color.WHITE);
		lblContactInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContactInfo.setBounds(10, 5, 122, 16);
		panel_12.add(lblContactInfo);
		
		//Admin Login Button
		panel_13 = new Panel();
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_13);
				resetColor(new Panel[] {panel_8, panel_10, panel_11, panel_12, panel_9});
				Admin admin = new Admin();
				admin.setVisible(true);
				dispose();
			}
		});
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(65, 105, 225));
		panel_13.setBounds(0, 195, 178, 28);
		panel_7.add(panel_13);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdminLogin.setBounds(10, 5, 122, 16);
		panel_13.add(lblAdminLogin);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("icon\\info.png"));
		System.out.println(getClass().getResource(""));
		lblNewLabel_4.setBounds(77, 13, 24, 24);
		panel_7.add(lblNewLabel_4);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_14.setBackground(Color.GRAY);
		panel_14.setBounds(210, 9, 245, 295);
		panel_1.add(panel_14);
		
	}
	
	private void setColor(Panel pane){
		pane.setBackground(new Color(16,52,166));
		
	}
	
	private void resetColor(Panel[] pane){
		for(int i = 0; i < pane.length; i++)
			pane[i].setBackground(new Color(65, 105, 225));
		
	}
	
	private void resetColor(Panel pane){
		pane.setBackground(new Color(65, 105, 225));
		
	}
}

