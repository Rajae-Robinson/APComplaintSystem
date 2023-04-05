package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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
import model.Complaint;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class StudentDashboard {

	private JFrame frame;
	protected Object paneladd;
	private JTextField emailtext;
	private JTextField contact_text;
	private JTable table;
	private JTextField searchtextField;
	private JComboBox search_select_combobox;
	private Client client = new Client();
	protected Vector<?> rowData;


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
//			System.out.println(student);
//		}
		
		client.sendAction("findStudent");
		client.sendID(LoginScreen.loginID);
		Student stu = client.receiveStudent();

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
		
	/*	JLabel idlbl = new JLabel("ID Number: ");
		idlbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		idlbl.setBounds(55, 27, 119, 24);
		panel_1.add(idlbl);
		
		JLabel fnamelbl = new JLabel("First Name: ");
		fnamelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		fnamelbl.setBounds(55, 70, 119, 24);
		panel_1.add(fnamelbl);
		
		JLabel namelbl = new JLabel("Last Name: ");
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		namelbl.setBounds(55, 113, 119, 24);
		panel_1.add(namelbl);
		
		JLabel lblemail = new JLabel("Email: ");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblemail.setBounds(55, 157, 119, 24);
		panel_1.add(lblemail);
		
		JLabel lblcontact = new JLabel("Contact Number:");
		lblcontact.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcontact.setBounds(55, 204, 119, 24);
		panel_1.add(lblcontact);
		*/
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(" LODGE COMPLAINT ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lbltype = new JLabel("Complaint/Query Type: ");
		lbltype.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltype.setBounds(531, 43, 169, 24);
		panel_1.add(lbltype);
		
		JLabel lbladdcomplaint = new JLabel("Complaint:");
		lbladdcomplaint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbladdcomplaint.setBounds(531, 144, 119, 24);
		panel_1.add(lbladdcomplaint);
		
			//Labels from database
			
			JLabel id_label = new JLabel();
			id_label.setBounds(29, 30, 228, 24);
			id_label.setText(LoginScreen.loginID);
			panel_1.add(id_label);
			
			
			JLabel fname_label = new JLabel();
			fname_label.setBounds(29, 74, 140, 24);
			fname_label.setText(stu.getFirstName());
			panel_1.add(fname_label);
			
			
			JLabel lname_label = new JLabel();
			lname_label.setBounds(162, 74, 162, 24);
			lname_label.setText(stu.getLastName());
			panel_1.add(lname_label);
			
			JLabel email_label = new JLabel();
			email_label.setBounds(29, 133, 228, 24);
			email_label.setText(stu.getEmail());
			panel_1.add(email_label);
			
				JLabel contact_label = new JLabel();
				contact_label.setBounds(29, 186, 228, 24);
				contact_label.setText(stu.getContactNumber());
				panel_1.add(contact_label);
				
				JTextArea textArea = new JTextArea();
				textArea.setBounds(623, 145, 504, 266);
				panel_1.add(textArea);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Missing Grades", "Add/Drop module", "Fee Submission", "Financial Complaint", "Lecturer Issues", "Other"}));
				comboBox.setBounds(698, 46, 298, 31);
				panel_1.add(comboBox);
				
				
		//SUBMIT BUTTON
	JButton btnNewButton = new JButton("SUBMIT");
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	//setComboBox to String
	String useropt = (String) comboBox.getSelectedItem();
	btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
			if(!textArea.getText().trim().isEmpty() && !useropt.equals(null) ) 
			{

				Complaint complaint = new Complaint(1, Integer.parseInt(LoginScreen.loginID),useropt, textArea.getText());
				
				Client client = new Client();
				
				client.sendAction("createComplaint");

				client.sendAction(useropt);
				client.sendComplaint(complaint);
				
					
				JOptionPane.showMessageDialog(frame, "COMPLAINT/QUERY SUBMITED", "Confirmation", JOptionPane.INFORMATION_MESSAGE);				        					
				
		    }
		else {
				JOptionPane.showMessageDialog(frame, "Please Enter All Data!", "Error", JOptionPane.ERROR_MESSAGE);
				
		   }
			}
		});
	btnNewButton.setBounds(840, 437, 119, 42);
	panel_1.add(btnNewButton);
		
	//Lodge Query
			
			JPanel panel_7 = new JPanel();
			tabbedPane.addTab("LODGE QUERY", null, panel_7, null);
			panel_7.setLayout(null);
			
			JLabel contact_label_1 = new JLabel();
			contact_label_1.setText(stu.getContactNumber());
			contact_label_1.setBounds(26, 188, 228, 24);
			panel_7.add(contact_label_1);
			
			JLabel email_label_1 = new JLabel();
			email_label_1.setText(stu.getEmail());
			email_label_1.setBounds(26, 142, 228, 24);
			panel_7.add(email_label_1);
			
			JLabel lname_label_1 = new JLabel();
			lname_label_1.setText(stu.getLastName());
			lname_label_1.setBounds(163, 95, 179, 24);
			panel_7.add(lname_label_1);
			
			JLabel fname_label_1 = new JLabel();
			fname_label_1.setText(stu.getFirstName());
			fname_label_1.setBounds(26, 95, 143, 24);
			panel_7.add(fname_label_1);
		
			
			JLabel id_label_1 = new JLabel();
			id_label_1.setText(LoginScreen.loginID);
			id_label_1.setBounds(26, 43, 228, 24);
			panel_7.add(id_label_1);
			
//View Complaints Table
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(" VIEW COMPLAINTS ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 113, 1105, 390);
		panel_2.add(scrollPane);
		
	
		List<Complaint> complaints = ("FROM Complaint").list();
		client.receiveListResponses("FROM Complaint");

		// Step 7: Convert the list of Complaint objects to a Vector
		Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();
		for (Complaint complaint : complaint) {
		    Vector<Object> row = new Vector<Object>();
		    row.add(complaint.getComplaintID());
		    row.add(complaint.getStudentID());
		    row.add(complaint.getCategory());
		    row.add(complaint.getDetails());
		    row.add(complaint.getResponseDate());
		    row.add(complaint.getResponderID());
		    row.add(complaint.getResponse());
		}
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Complaint ID");
		columnNames.add("Student ID");
		columnNames.add("Category");
		columnNames.add("Student ID");
		columnNames.add("Description");
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
		table.setModel(model);
		
		//Table for View Complaints... needs database connection to view
		/*table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = {"Query ID", "Student ID", "Category", "Complaint/Query", "Response Date", "Responder ID", "Response"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
				
	*/
		
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