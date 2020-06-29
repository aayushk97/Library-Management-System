package LibraryManagementSystem;



import LibraryManagementSystem.AddLibrarian;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.ScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Admin extends JFrame {

	private JPanel contentPane;
	
	
	private JTextField textField;
	private boolean viewLibrarian;
	private boolean viewSelect;
	private String selectedForSearch;
	private boolean viewTable;
	private JLabel label_6;
	private JLabel label_7; 
	private JPanel panel_7;
	private JPanel panel_8;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JFrame frame;
	private String[][] result;
	private DefaultTableModel model;
	private JLabel label_2;
	
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		viewLibrarian = false;
		viewTable = false;
		viewSelect = false; 
		
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
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 153));
		panel_2.setBounds(0, 0, 180, 374);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(22, 13, 30, 24);
		panel_2.add(label);
		label.setIcon(new ImageIcon(getClass().getResource("icon\\man-user.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(51, 102, 153));
		panel_3.setBounds(0, 50, 180, 50);
		panel_2.add(panel_3);
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(187, 141, 100, 75);
		panel_1.add(panel_8);
		panel_8.setVisible(viewSelect);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedForSearch = "f_name";
				label_2.setText("First Name");
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_10.setBounds(0, 25, 100, 25);
		panel_8.add(panel_10);
		
		JLabel lblDate = new JLabel("First name");
		panel_10.add(lblDate);
		
		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedForSearch = "l_name";
				label_2.setText("Last name");
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_11.setBounds(0, 50, 100, 25);
		panel_8.add(panel_11);
		
		JLabel lblPublisher = new JLabel("Last name");
		panel_11.add(lblPublisher);
		
		JPanel panel_9 = new JPanel();
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedForSearch = "emp_id";
				label_2.setText("Employee ID");
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_9.setBounds(0, 0, 100, 25);
		panel_8.add(panel_9);
		
		JLabel lblName = new JLabel("Employee ID");
		panel_9.add(lblName);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(22, 13, 30, 24);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddLibrarian addl = new AddLibrarian();
				addl.setVisible(true);
				dispose();
			}
		});
		panel_4.setBounds(197, 13, 161, 29);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Add Librarian");
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setVisible(!viewLibrarian);
				
				label_6.setVisible(!viewLibrarian);
				label_7.setVisible(!viewLibrarian); 
				panel_7.setVisible(!viewLibrarian);
				
				viewLibrarian = !viewLibrarian;
				
			}
		});
		panel_5.setBounds(395, 13, 161, 29);
		panel_1.add(panel_5);
		
		JLabel lblViewBook = new JLabel("View Librarian");
		panel_5.add(lblViewBook);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(591, 13, 161, 29);
		panel_1.add(panel_6);
		
		JLabel lblRemoveBook = new JLabel("Button3");
		panel_6.add(lblRemoveBook);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(299, 112, 384, 29);
		panel_1.add(textField);
		textField.setVisible(viewLibrarian);
		
		panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_7.setBounds(187, 112, 100, 29);
		panel_1.add(panel_7);
		
		label_2 = new JLabel("Select");
		panel_7.add(label_2);
		panel_7.setVisible(viewLibrarian);
		
		label_6 = new JLabel("New label");
		label_6.setIcon(new ImageIcon(getClass().getResource("icon\\barcode.png")));
		label_6.setBounds(693, 112, 27, 29);
		panel_1.add(label_6);
		label_6.setVisible(viewLibrarian);
		
				
		//Table *Do not touch* -----------------------------------
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Employee ID", "First Name", "Last Name", "Phone Number", "E-mail", "Date of Joining", "Shift" });
		/*
				  new String[][]{{"a","b","c"},{"b"},{"a"}}, 
		          new String[] { "Employee ID", "First Name", "Last Name", "Phone Number", "E-mail", "Date of Joining", "Shift" } );
		*/
		JTable t = new JTable(model);
		JScrollPane scroll = new JScrollPane(t);
		scroll.setBounds( 299, 152, 469, 162 ); // x, y, width, height
		panel_1.add(scroll);
		
		scroll.setVisible(viewTable);
		
		
		//--------------------------------------------------------
		
		
		
		label_7 = new JLabel("New label");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				scroll.setVisible(!viewTable);
				viewTable = !viewTable;
				
				viewTable();
				if(!viewTable){
					model.setRowCount(0);
				}
				
			}
		});
		label_7.setIcon(new ImageIcon(getClass().getResource("icon\\search.png")));
		label_7.setBounds(732, 113, 24, 24);
		panel_1.add(label_7);
		label_7.setVisible(viewLibrarian);
		
		
		      
		
		
		}
	
	
	public void viewTable(){
		ResultSet rs = LibrarianDao.view(selectedForSearch, textField.getText());
		 
	
		try {
			while(rs.next()){
				//ar.add(new String[]{""+rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});	
				model.addRow(new String[]{""+rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}		

