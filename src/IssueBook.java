package LibraryManagementSystem;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;

import java.awt.Label;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class IssueBook extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 800, 442);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				//setContentPane(contentPane);
				
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
				getContentPane().add(panel_1, BorderLayout.EAST);
				panel_1.setLayout(null);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(0, 102, 153));
				panel_2.setBounds(0, 0, 180, 374);
				panel_1.add(panel_2);
				panel_2.setLayout(null);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("icon//arrow-point-to-right.png"));
				label.setBounds(32, 18, 24, 16);
				panel_2.add(label);
				
				JLabel label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon("icon//open-book.png"));
				label_2.setBackground(Color.WHITE);
				label_2.setBounds(12, 13, 30, 24);
				panel_2.add(label_2);
				
				JLabel lblIssueBook = new JLabel("Issue Book");
				lblIssueBook.setForeground(Color.WHITE);
				lblIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblIssueBook.setBounds(60, 18, 80, 16);
				panel_2.add(lblIssueBook);
				
				JPanel panel_5 = new JPanel();
				panel_5.setBackground(new Color(51, 102, 152));
				panel_5.setBounds(0, 170, 180, 159);
				panel_2.add(panel_5);
				panel_5.setLayout(null);
				
				JLabel label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon("icon//open-book.png"));
				label_3.setBackground(Color.WHITE);
				label_3.setBounds(12, 13, 30, 24);
				panel_5.add(label_3);
				
				JLabel label_4 = new JLabel("");
				label_4.setIcon(new ImageIcon("icon//arrow-point-to-left.png"));
				label_4.setBounds(32, 18, 24, 16);
				panel_5.add(label_4);
				
				JLabel lblReturnBook = new JLabel("Return Book");
				lblReturnBook.setForeground(Color.WHITE);
				lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblReturnBook.setBounds(60, 18, 80, 16);
				panel_5.add(lblReturnBook);
				
				textField = new JTextField();
				textField.setBounds(240, 38, 198, 22);
				panel_1.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Book Name");
				lblNewLabel.setBounds(240, 13, 76, 16);
				panel_1.add(lblNewLabel);
				
				JLabel lblPassword = new JLabel("Author");
				lblPassword.setBounds(567, 13, 76, 16);
				panel_1.add(lblPassword);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(567, 38, 198, 22);
				panel_1.add(textField_1);
				
				JPanel panel_4 = new JPanel();
				panel_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int a = issueBookDao.issueBook(textField.getText(), textField_1.getText(), Integer.parseInt(textField_3.getText()), textField_5.getText());
						if( a > 0 ){
							textField.setText(null);
							textField_1.setText(null);
							textField_3.setText(null);
							textField_5.setText(null);
							
							
						}
					}
				});
				panel_4.setLayout(null);
				panel_4.setBackground(new Color(0, 0, 153));
				panel_4.setBounds(407, 133, 198, 33);
				panel_1.add(panel_4);
				
				JLabel lblAddUser_1 = new JLabel("Issue Book");
				lblAddUser_1.setForeground(Color.WHITE);
				lblAddUser_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblAddUser_1.setBounds(60, 0, 93, 29);
				panel_4.add(lblAddUser_1);
				
				JLabel lblLastName = new JLabel("Issue");
				lblLastName.setBounds(240, 73, 76, 16);
				panel_1.add(lblLastName);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(240, 98, 198, 22);
				panel_1.add(textField_3);
				
				JLabel lblEmail = new JLabel("Username");
				lblEmail.setBounds(567, 73, 76, 16);
				panel_1.add(lblEmail);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(567, 98, 198, 22);
				panel_1.add(textField_5);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_1.setIcon(new ImageIcon("icon/barcode.png"));
				lblNewLabel_1.setBounds(643, 133, 57, 33);
				panel_1.add(lblNewLabel_1);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(192, 170, 573, 2);
				panel_1.add(separator);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(240, 204, 198, 22);
				panel_1.add(textField_2);
				
				JLabel label_5 = new JLabel("Book Name");
				label_5.setBounds(240, 179, 76, 16);
				panel_1.add(label_5);
				
				JLabel label_6 = new JLabel("Author");
				label_6.setBounds(567, 179, 76, 16);
				panel_1.add(label_6);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(567, 204, 198, 22);
				panel_1.add(textField_4);
				
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(240, 264, 198, 22);
				panel_1.add(textField_6);
				
				JLabel label_7 = new JLabel("Issue");
				label_7.setBounds(240, 239, 76, 16);
				panel_1.add(label_7);
				
				JLabel lblStudentid = new JLabel("Username");
				lblStudentid.setBounds(567, 239, 76, 16);
				panel_1.add(lblStudentid);
				
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				textField_7.setBounds(567, 264, 198, 22);
				panel_1.add(textField_7);
				
				JPanel panel_3 = new JPanel();
				panel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						//issueBookDao.returnBook(, author, issue, username)
						int a = issueBookDao.returnBook(textField_2.getText(), textField_4.getText(), Integer.parseInt(textField_6.getText()), textField_7.getText());
						if( a > 0 ){
							textField_2.setText(null);
							textField_4.setText(null);
							textField_6.setText(null);
							textField_7.setText(null);
							
							
						}
					}
				});
				panel_3.setLayout(null);
				panel_3.setBackground(new Color(0, 0, 153));
				panel_3.setBounds(407, 297, 198, 33);
				panel_1.add(panel_3);
				
				JLabel lblReturnBook_1 = new JLabel("Return Book");
				lblReturnBook_1.setForeground(Color.WHITE);
				lblReturnBook_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblReturnBook_1.setBounds(60, 0, 93, 29);
				panel_3.add(lblReturnBook_1);
				
				JLabel label_9 = new JLabel("");
				label_9.setIcon(new ImageIcon("icon//barcode.png"));
				label_9.setVerticalAlignment(SwingConstants.TOP);
				label_9.setBounds(643, 288, 57, 33);
				panel_1.add(label_9);

	}
}
