package LibraryManagementSystem;


import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SearchStudent extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	Boolean select1 = false;
	//select Search by name, id or publisher
	private JPanel panel_8;
	private Boolean viewSelect = false;
	
	private DefaultTableModel model;
	private Boolean viewTable;
	private String selectedForSearch;
	
	private JScrollPane scroll;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudent frame1 = new SearchStudent();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public SearchStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		viewTable = false;
		
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
		
		System.out.println("aa");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 68, 800, 374);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 153));
		panel_2.setBounds(0, 0, 93, 374);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_5.setBounds(118, 42, 100, 29);
		panel_1.add(panel_5);
		
		JLabel label_2 = new JLabel("Select");
		panel_5.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(230, 42, 416, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("icon\\barcode.png"));
		lblNewLabel_1.setBounds(658, 42, 27, 29);
		panel_1.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_4.setIcon(new ImageIcon("icon\\search.png"));
		lblNewLabel_4.setBounds(697, 43, 24, 24);
		panel_1.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Library Database");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(230, 90, 127, 25);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Internet");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(469, 90, 127, 25);
		panel_1.add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(118, 69, 100, 75);
		panel_1.add(panel_8);
		panel_8.setVisible(viewSelect);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedForSearch = "f_name";
				label_2.setText("First name");
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_10.setBounds(0, 25, 100, 25);
		panel_8.add(panel_10);
		
		JLabel lblDate = new JLabel("First Name");
		panel_10.add(lblDate);
		
		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedForSearch = "l_name";
				label_2.setText("Last Name");
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_11.setBounds(0, 50, 100, 25);
		panel_8.add(panel_11);
		
		JLabel lblPublisher = new JLabel("Last Name");
		panel_11.add(lblPublisher);
		
		JPanel panel_9 = new JPanel();
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedForSearch = "username";
				label_2.setText("Username");
				panel_8.setVisible(!viewSelect);
				viewSelect = !viewSelect;
			}
		});
		panel_9.setBounds(0, 0, 100, 25);
		panel_8.add(panel_9);
		
		JLabel lblName = new JLabel("Username");
		panel_9.add(lblName);
		
		//Table *Do not touch* -----------------------------------
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Username", "Password", "First Name", "Last Name", "Phone Number", "Email" , "DOJ", "No Of Months " });
		/*
				  new String[][]{{"a","b","c"},{"b"},{"a"}}, 
		          new String[] { "Employee ID", "First Name", "Last Name", "Phone Number", "E-mail", "Date of Joining", "Shift" } );
		*/
		JTable t = new JTable(model);
		scroll = new JScrollPane(t);
		scroll.setBounds( 231, 151, 441, 162 ); // x, y, width, height
		panel_1.add(scroll);
		
		scroll.setVisible(viewTable);
		
		
		//--------------------------------------------------------


	}
	
	public void viewTable(){
		ResultSet rs = StudentDao.view(selectedForSearch, textField.getText());
		 
	
		try {
			while(rs.next()){
				//ar.add(new String[]{""+rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});	
				model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7),""+rs.getInt(8)});	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
