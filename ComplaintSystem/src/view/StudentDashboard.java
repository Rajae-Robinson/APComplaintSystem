package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Client;
import model.Query;
import model.Student;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class StudentDashboard {

	private JFrame frame;
	protected Object paneladd;
	private JTextField idtext;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField emailtext;
	private JTextField contact_text;
	private JTable table;
	private JTextField searchtextField;
	private JComboBox search_select_combobox;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard window = new StudentDashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentDashboard() {
		initialize();
	}

	private void initialize() {
		// Test Server
//		Client client = new Client();
//		client.sendAction("getStudents");
//		List<Student> stu = client.receiveListResponses(Student.class);
//		for (Student student: stu) {
//			System.out.println(stu);
//		}
//		Client client = new Client();
//		client.sendAction("deleteQuery");
//		client.sendID("14");
//		Boolean qu = client.receiveResponse(Boolean.class);
//		System.out.println(qu);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1238, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1204, 54);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT COMPLAINT & QUERY DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(313, 10, 544, 34);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 119, 1204, 540);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(" LODGE COMPLAINT ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel idlbl = new JLabel("ID Number: *");
		idlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		idlbl.setBounds(55, 27, 119, 24);
		panel_1.add(idlbl);
		
		JLabel fnamelbl = new JLabel("First Name: *");
		fnamelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		fnamelbl.setBounds(55, 70, 119, 24);
		panel_1.add(fnamelbl);
		
		JLabel namelbl = new JLabel("Last Name: *");
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		namelbl.setBounds(55, 113, 119, 24);
		panel_1.add(namelbl);
		
		JLabel lblemail = new JLabel("Email: *");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblemail.setBounds(55, 157, 119, 24);
		panel_1.add(lblemail);
		
		JLabel lblcontact = new JLabel("Contact Number:");
		lblcontact.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcontact.setBounds(55, 204, 119, 24);
		panel_1.add(lblcontact);
		
		JLabel lbltype = new JLabel("Complaint/Query Type: *");
		lbltype.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltype.setBounds(531, 43, 169, 24);
		panel_1.add(lbltype);
		
		JLabel lbladdcomplaint = new JLabel("Complaint:");
		lbladdcomplaint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbladdcomplaint.setBounds(531, 144, 119, 24);
		panel_1.add(lbladdcomplaint);
		
		idtext = new JTextField();
		idtext.setBounds(162, 31, 228, 24);
		panel_1.add(idtext);
		idtext.setColumns(10);
		
		fnametext = new JTextField();
		fnametext.setColumns(10);
		fnametext.setBounds(162, 74, 228, 24);
		panel_1.add(fnametext);
		
		lnametext = new JTextField();
		lnametext.setColumns(10);
		lnametext.setBounds(162, 117, 228, 24);
		panel_1.add(lnametext);
		
		emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(162, 161, 228, 24);
		panel_1.add(emailtext);
		
		contact_text = new JTextField();
		contact_text.setColumns(10);
		contact_text.setBounds(162, 208, 228, 24);
		panel_1.add(contact_text);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(623, 145, 504, 266);
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(840, 437, 119, 42);
		panel_1.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Missing Grades", "Add/Drop module", "Fee Submission", "Financial Complaint", "Lecturer Issues", "Other"}));
		comboBox.setBounds(698, 46, 298, 31);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(" VIEW COMPLAINTS ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 113, 1105, 390);
		panel_2.add(scrollPane);
		
		//Table for View Complaints... needs database connection to view
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Query ID", "Student ID", "Category", "Complaint/Query", "Response Date", "Responder ID", "Response"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(101);
		table.getColumnModel().getColumn(3).setPreferredWidth(154);
		table.getColumnModel().getColumn(4).setPreferredWidth(118);
		table.getColumnModel().getColumn(6).setPreferredWidth(214);
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(36, 10, 1105, 68);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Search Option");
		lblNewLabel_2.setBounds(115, 36, 119, 13);
		panel_5.add(lblNewLabel_2);
		
		searchtextField = new JTextField();
		searchtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String selection = (String)search_select_combobox.getSelectedItem();
					// needs database connection
					table.setModel(null);
					
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			
			}
		});
		searchtextField.setBounds(354, 24, 431, 37);
		panel_5.add(searchtextField);
		searchtextField.setColumns(10);
		
		search_select_combobox= new JComboBox();
		search_select_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Query ID", "Category"})); //other categories can be added
		search_select_combobox.setBounds(96, 27, 202, 30);
		panel_5.add(search_select_combobox);
		
		
		// LIVE CHAT has to primarily deal with the TCP connect can be done after connection
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab(" LIVE CHAT ", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab(" LIVE VIDEO", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Frequently Asked Questions", null, panel_3, null);
		panel_3.setLayout(null);
	}
}

