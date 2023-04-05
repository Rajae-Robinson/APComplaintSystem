package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StudentDashboard implements ActionListener {
	private JFrame frame;
	protected Object paneladd;
	private JTextField idtext;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField emailtext;
	private JTextField contact_text;
	private JComboBox<String> comboBox;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JButton goButton;
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
		
		JLabel idlbl = new JLabel("ID Number: ");
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
		
		idtext = new JTextField();
		idtext.setBounds(162, 31, 228, 24);
		idtext.setText(LoginScreen.loginID);
		idtext.setEditable(false);
		panel_1.add(idtext);
		idtext.setColumns(10);

		fnametext = new JTextField();
		fnametext.setColumns(10);
		fnametext.setBounds(162, 74, 228, 24);
		fnametext.setEditable(false);
		fnametext.setText(stu.getFirstName());
		panel_1.add(fnametext);

		lnametext = new JTextField();
		lnametext.setColumns(10);
		lnametext.setBounds(162, 117, 228, 24);
		lnametext.setEditable(false);
		lnametext.setText(stu.getLastName());
		panel_1.add(lnametext);

		emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(162, 161, 228, 24);
		emailtext.setEditable(false);
		emailtext.setText(stu.getEmail());
		panel_1.add(emailtext);

		contact_text = new JTextField();
		contact_text.setColumns(10);
		contact_text.setBounds(162, 208, 228, 24);
		contact_text.setText(stu.getContactNumber());
		contact_text.setEditable(false);
		panel_1.add(contact_text);
				
		textArea = new JTextArea();
		textArea.setBounds(623, 145, 504, 266);
		panel_1.add(textArea);
		
		String[] options = {"","Missing Grades", "Add/Drop module", "Fee Submission", "Financial Complaint", "Lecturer Issues", "Other"};
		comboBox = new JComboBox<String>(options);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(698, 46, 298, 31);
		panel_1.add(comboBox);	
		
//		JRadioButton complaintRadioButton = new JRadioButton("Complaint");
//		JRadioButton queryRadioButton = new JRadioButton("Query");

//		ButtonGroup buttonGroup = new ButtonGroup();
//		buttonGroup.add(complaintRadioButton);
//		buttonGroup.add(queryRadioButton);
//		complaintRadioButton.setBounds(840, 437, 119, 42);
//		queryRadioButton.setBounds(840, 437, 119, 42);
//		panel_1.add(complaintRadioButton);
//		panel_1.add(queryRadioButton);
				
		//SUBMIT BUTTON
		btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(840, 437, 119, 42);
		panel_1.add(btnNewButton);
		
		
			
		//View Complaints Table
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(" VIEW PAST COMPLAINTS/QUERIES ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 113, 1105, 390);
		panel_2.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(36, 10, 1105, 68);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(115, 36, 119, 13);
		panel_5.add(lblNewLabel_2);
		
		search_select_combobox = new JComboBox();
		search_select_combobox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"})); //other categories can be added
		search_select_combobox.setBounds(96, 27, 202, 30);
		panel_5.add(search_select_combobox);
		
		searchtextField = new JTextField();
		searchtextField.setBounds(354, 24, 431, 37);
		panel_5.add(searchtextField);
		searchtextField.setColumns(10);
		
		goButton = new JButton("Go");
		goButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		goButton.addActionListener(this);
		goButton.setBounds(840, 437, 119, 42);
		panel_2.add(goButton);
		
		String listOption = search_select_combobox.getSelectedItem().toString();
		List<Complaint> complaintList = new ArrayList<Complaint>();
		List<Query> queryList = new ArrayList<Query>();
		if(listOption.equalsIgnoreCase("Complaint")) {
			Client client = new Client();
			client.sendAction("getComplaintsForStudent");
			client.sendID(Integer.parseInt(LoginScreen.loginID));
			complaintList = client.receiveComplaintList();
		}
		
		if(listOption.equalsIgnoreCase("Query")) {
			Client client = new Client();
			client.sendAction("getQueriesForStudent");
			client.sendID(Integer.parseInt(LoginScreen.loginID));
			queryList = client.receiveListResponses(Query.class);
		}
		
		String[] columnNames = {"Complaint ID", "Student ID", "Category", "Responder ID", "Response"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
        if(listOption == "Complaint") {
        	for (Complaint complaint : complaintList) {
                Object[] rowData = {complaint.getComplaintID(), complaint.getStudentID(), complaint.getCategory(), complaint.getResponderID(), complaint.getResponse()};
                model.addRow(rowData);
            }
		}
		
		if(listOption == "Query") {
			for (Query query : queryList) {
                Object[] rowData = {query.getQueryID(), query.getStudentID(), query.getCategory(), query.getResponderID(), query.getResponse()};
                model.addRow(rowData);
            }
		}
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == btnNewButton) {
	    	  String userOpt = comboBox.getSelectedItem().toString();
	    	  if(!textArea.getText().trim().isEmpty() && !userOpt.isEmpty()) 
				{
	
					Complaint complaint = new Complaint(1, Integer.parseInt(LoginScreen.loginID), userOpt, textArea.getText());
					
					Client client = new Client();
					client.sendAction("createComplaint");
					client.sendComplaint(complaint);
					
						
					JOptionPane.showMessageDialog(frame, "COMPLAINT/QUERY SUBMITED", "Confirmation", JOptionPane.INFORMATION_MESSAGE);				        					
					
			    }
			else {
					JOptionPane.showMessageDialog(frame, "Please Enter All Data!", "Error", JOptionPane.ERROR_MESSAGE);
					
			   }
	      }
	      
	      if (e.getSource() == goButton) {
	    	String option = search_select_combobox.getSelectedItem().toString();
	    	String id = searchtextField.getText();
	    	if (option == "Complaint") {
	    		client.sendAction("findComplaint");
	    		client.sendID(id);
				client.receiveComplaint();
	    	}
	  		
	      }
	}
}