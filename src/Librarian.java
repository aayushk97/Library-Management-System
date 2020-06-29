package LibraryManagementSystem;


import LibraryManagementSystem.IssueBook;
import LibraryManagementSystem.DB;
import LibraryManagementSystem.AddStudent;
import LibraryManagementSystem.AddBook;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Librarian extends JFrame {
	
	private JPanel contentPane;
	private DefaultTableModel model;
	private JScrollPane scroll;

	/**
	 * Create the panel.
	 */

	public Librarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 69);
		panel.setBackground(new Color(71, 120, 197));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setIcon(new ImageIcon("icon\\menu-button.png"));
		
		lblNewLabel_2.setBounds(738, 34, 24, 16);
		panel.add(lblNewLabel_2);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 0, 153));
		panel_13.setBounds(550, 13, 160, 40);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("    Logout");
		System.out.println(getClass().getResource(""));
		lblNewLabel_3.setIcon(new ImageIcon("icon\\logout.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 5, 100, 30);
		panel_13.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 68, 800, 374);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 153));
		panel_2.setBounds(0, 0, 180, 374);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 102, 153));
		panel_3.setBounds(0, 50, 180, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icon\\man-user.png"));
		label.setBounds(22, 13, 30, 24);
		panel_3.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icon\\open-book.png"));
		lblNewLabel_1.setBounds(22, 21, 30, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("icon\\open-book.png"));
		label_1.setBounds(22, 113, 30, 24);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("icon\\arrow-point-to-right.png"));
		label_2.setBounds(42, 118, 24, 16);
		panel_2.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddBook addbook = new AddBook();
				addbook.setVisible(true);
				System.out.println("Clicked on add Book");
			}
		});
		panel_4.setBounds(197, 13, 161, 29);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Add Book");
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Search s = new Search();
				s.setVisible(true);
			}
		});
		panel_5.setBounds(395, 13, 161, 29);
		panel_1.add(panel_5);
		
		JLabel lblViewBook = new JLabel("View Book");
		panel_5.add(lblViewBook);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(591, 13, 161, 29);
		panel_1.add(panel_6);
		
		JLabel lblRemoveBook = new JLabel("Update/ Remove Book");
		panel_6.add(lblRemoveBook);
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddStudent.main(null);
			}
		});
		panel_7.setBounds(197, 65, 161, 29);
		panel_1.add(panel_7);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		panel_7.add(lblAddStudent);
		
		JPanel panel_8 = new JPanel();
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SearchStudent st = new SearchStudent();
				st.setVisible(true);
			}
		});
		panel_8.setBounds(395, 65, 161, 29);
		panel_1.add(panel_8);
		
		JLabel lblViewStudent = new JLabel("View Student");
		panel_8.add(lblViewStudent);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(591, 65, 161, 29);
		panel_1.add(panel_9);
		
		JLabel lblUpdateRemoveStudent = new JLabel("Update/ Remove Student");
		panel_9.add(lblUpdateRemoveStudent);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				IssueBook issueBook = new IssueBook();
				issueBook.setVisible(true);
			}
		});
		panel_10.setBounds(197, 119, 161, 29);
		panel_1.add(panel_10);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		panel_10.add(lblIssueBook);
		
		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame f = new JFrame();
				f.setTitle("Issued Books");
				
				model = new DefaultTableModel();
				model.setColumnIdentifiers(new String[] { "Book Name", "Author", "Issue", "Username"});
			    
				
				Connection con=DB.getConnection();
				
				try {
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from issueBook");
							while(rs.next()){
								model.addRow(new String[]{rs.getString(1),rs.getString(2),""+rs.getInt(3),rs.getString(4)});
								
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
		panel_11.setBounds(395, 119, 161, 29);
		panel_1.add(panel_11);
		
		JLabel lblViewIssued = new JLabel("View Issued");
		panel_11.add(lblViewIssued);
		
		JPanel panel_12 = new JPanel();
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				IssueBook ib = new IssueBook();
				ib.setVisible(true);
			}
		});
		panel_12.setBounds(591, 119, 161, 29);
		panel_1.add(panel_12);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		panel_12.add(lblReturnBook);

	}
}
