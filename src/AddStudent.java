package LibraryManagementSystem;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.List;

import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;



public class AddStudent extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AddStudent() {
		
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
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setForeground(Color.WHITE);
		lblAddUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddUser.setBounds(22, 13, 130, 24);
		panel_2.add(lblAddUser);
		lblAddUser.setIcon(new ImageIcon("icon\\man-user.png"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(51, 102, 153));
		panel_3.setBounds(0, 50, 180, 50);
		panel_2.add(panel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(22, 13, 30, 24);
		panel_3.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(240, 59, 198, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(240, 34, 76, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(567, 34, 76, 16);
		panel_1.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(567, 59, 198, 22);
		panel_1.add(textField_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				StudentDao.save(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), Date.valueOf(textField_6.getText()), comboBox.getSelectedIndex());
				//System.out.println(comboBox.getSelectedItem());
			}
		});
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 0, 153));
		panel_4.setBounds(407, 264, 198, 33);
		panel_1.add(panel_4);
		
		JLabel lblAddUser_1 = new JLabel("Add User");
		lblAddUser_1.setForeground(Color.WHITE);
		lblAddUser_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddUser_1.setBounds(70, 2, 93, 29);
		panel_4.add(lblAddUser_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(240, 86, 76, 16);
		panel_1.add(lblFirstName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(240, 111, 198, 22);
		panel_1.add(textField_2);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(567, 86, 76, 16);
		panel_1.add(lblLastName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(567, 111, 198, 22);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(240, 166, 198, 22);
		panel_1.add(textField_4);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(240, 141, 117, 16);
		panel_1.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(567, 141, 76, 16);
		panel_1.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(567, 166, 198, 22);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(240, 226, 198, 22);
		panel_1.add(textField_6);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		lblDateOfJoining.setBounds(240, 201, 117, 16);
		panel_1.add(lblDateOfJoining);
		
		JLabel lblNoOfMonths = new JLabel("No of Months ");
		lblNoOfMonths.setBounds(567, 201, 103, 16);
		panel_1.add(lblNoOfMonths);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(573, 226, 192, 22);
		panel_1.add(comboBox);
		
		
	}
}

