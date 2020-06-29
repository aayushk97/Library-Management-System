package LibraryManagementSystem;


import LibraryManagementSystem.DB;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

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


public class Student extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private boolean viewTable = false;
	/**
	 * Create the panel.
	 */
	public Student() {
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
		panel_13.setBounds(578, 23, 148, 33);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Logout");
		lblNewLabel_3.setIcon(new ImageIcon("icon\\logout.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(18, 2, 93, 29);
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
		
		JLabel label = new JLabel("");
		label.setBounds(22, 13, 30, 24);
		panel_2.add(label);
		label.setIcon(new ImageIcon("icon\\man-user.png"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(51, 102, 153));
		panel_3.setBounds(0, 50, 180, 50);
		panel_2.add(panel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(22, 13, 30, 24);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				model.setColumnIdentifiers(new String[] { "Username", "Password", "First Name", "Last Name", "Phone Number", "Email" , "DOJ", "No Of Months " });
				scroll.setVisible(viewTable);
				viewTable = !viewTable;
				if(!viewTable){
					model.setRowCount(0);
				}
				Connection con=DB.getConnection();
				
				try {
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from students where username = 'user1'");
							while(rs.next()){
								model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7),""+rs.getInt(8)});
								
							}
							
							con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panel_4.setBounds(197, 13, 161, 29);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("View User Details");
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				model.setColumnIdentifiers(new String[] { "Book Name", "Author", "Issue", "Username" });
				scroll.setVisible(viewTable);
				viewTable = !viewTable;
				if(!viewTable){
					model.setRowCount(0);
				}
				Connection con=DB.getConnection();
				
				try {
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from issueBook where username = 'user1'");
							while(rs.next()){
								model.addRow(new String[]{rs.getString(1),rs.getString(2),""+rs.getInt(3),rs.getString(4)});
								
							}
							
							con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_5.setBounds(395, 13, 161, 29);
		panel_1.add(panel_5);
		
		JLabel lblViewBook = new JLabel("View Issued Books");
		panel_5.add(lblViewBook);
		
		//---------------------------------------------------------------------------------------
		model = new DefaultTableModel();
		
		/*
				  new String[][]{{"a","b","c"},{"b"},{"a"}}, 
		          new String[] { "Employee ID", "First Name", "Last Name", "Phone Number", "E-mail", "Date of Joining", "Shift" } );
		*/
		JTable t = new JTable(model);
		scroll = new JScrollPane(t);
		scroll.setBounds( 231, 67, 521, 246 ); // x, y, width, height
		panel_1.add(scroll);
		
		scroll.setVisible(viewTable);

	}
}
