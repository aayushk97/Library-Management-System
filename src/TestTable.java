package LibraryManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTable;


public class TestTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane sp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTable frame = new TestTable();
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
	public TestTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(46, 45, 350, 171);
		contentPane.add(panel);
		panel.setLayout(null);
		String data[][]={{"1","2","3"},{"1","2","3"},{"1","2","3"}};
		String column[]={"One","Two","Two"};
		table = new JTable(data,column);
		
		table.setBounds(10, 161, 330, -149);
		sp=new JScrollPane(table);
		panel.add(sp);
	}
}
