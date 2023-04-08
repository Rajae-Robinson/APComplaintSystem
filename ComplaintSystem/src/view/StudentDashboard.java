/*
 * Author: Sheneka Mitchell
 */
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
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private JButton submitbtn;
	private JButton goButton;
	private JTable table;
	private JTextField searchtextField;
	private JComboBox search_select_combobox;
	private Client client = new Client();
	protected Vector<?> rowData;
	
    private JRadioButton rdbtnQuery;
    private JRadioButton rdbtnComplaint;
    private String selectedType = "";
    private String selectedOption = "";
    private ButtonGroup radioGroup;


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
		tabbedPane.addTab("LODGE COMPLAINT/QUERY", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lbltype = new JLabel("Complaint/Query Type: ");
		lbltype.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltype.setBounds(529, 96, 169, 24);
		panel_1.add(lbltype);
		
		JLabel lbladdcomplaint = new JLabel("Complaint:");
		lbladdcomplaint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbladdcomplaint.setBounds(516, 178, 119, 24);
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
		textArea.setBounds(623, 179, 504, 247);
		panel_1.add(textArea);
		
		String[] options = {"", "Missing Grades", "Add/Drop module", "Fee Submission", "Financial Assistance ", "Lecturer Issues", "Grade Forgiveness", "Other"};
		comboBox = new JComboBox<String>(options);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(709, 93, 298, 31);
		panel_1.add(comboBox);
		
		JRadioButton rdbtncomplaint = new JRadioButton("Complaint");
		rdbtncomplaint.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtncomplaint.setBounds(656, 30, 103, 21);
		panel_1.add(rdbtncomplaint);

		JRadioButton rdbtnquery = new JRadioButton("Query");
		rdbtnquery.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnquery.setBounds(806, 30, 103, 21);
		panel_1.add(rdbtnquery);

		
		//so only one can be selected at a time
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnComplaint);
		radioGroup.add(rdbtnQuery);
		
	    // Add an item listener to the radio buttons to detect when they are clicked
	     rdbtnquery.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	             if (e.getStateChange() == ItemEvent.SELECTED) {
	                 selectedType = "Query";
	             }
	         }
	     });
	     rdbtncomplaint.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	             if (e.getStateChange() == ItemEvent.SELECTED) {
	            	
	                 selectedType = "Complaint";
	             }
	         }
	     });

				
		//SUBMIT BUTTON
		submitbtn = new JButton("SUBMIT");
		submitbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		submitbtn.addActionListener(this);
		submitbtn.setBounds(840, 437, 119, 42);
		panel_1.add(submitbtn);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(" VIEW PAST COMPLAINTS/QUERIES ", null, panel_2, null);
		panel_2.setLayout(null);

	
	    PastComplaints pastCPanel = new PastComplaints();
		pastCPanel.setBounds(0, 0, 1105, 550); // Set the bounds of the panel to fit inside panel_2
		panel_2.add(pastCPanel);
		
	
		// LIVE CHAT has to primarily deal with the TCP connect can be done after connection
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab(" LIVE CHAT ", null, panel_4, null);
		panel_4.setLayout(null);
		
		LiveChat livechat = new LiveChat();
		livechat.setBounds(0, 0, 1105, 550); // Set the bounds of the panel to fit inside panel_2
		panel_4.add(livechat);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab(" LIVE VIDEO", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Frequently Asked Questions", null, panel_3, null);
		panel_3.setLayout(null);
		
		FAQ fqa = new FAQ();
		fqa.setBounds(0, 0, 1105, 550); // Set the bounds of the panel to fit inside panel_2
		panel_3.add(fqa);
	}

	@Override
	
	
	public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == submitbtn  ) {
	    	  
	    	         // Get the text from the complaint/feedback area
	    	         selectedOption = textArea.getText();
	    	         
	    	         // Check that a type has been selected
	    	         if (selectedType.equals("")) {
	    	             JOptionPane.showMessageDialog(frame, "Please select a type (Complaint or Query)");
	    	             return;
	    	         }
	    	         
	    	         // Check that an option has been selected
	    	         if (selectedOption.equals("")) {
	    	             JOptionPane.showMessageDialog(frame, "Please enter your " + selectedType.toLowerCase());
	    	             return;
	    	         }

	    	  String userOpt = comboBox.getSelectedItem().toString();
	    	  if (selectedType.equals("Complaint"))
				{
	
					Complaint complaint = new Complaint(1, Integer.parseInt(LoginScreen.loginID), userOpt, textArea.getText());
					
					Client client = new Client();
					client.sendAction("createComplaint");
					client.sendComplaint(complaint);
						
					JOptionPane.showMessageDialog(frame, "COMPLAINT SUBMITED Successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);				        					
					
			    }
			else {
				Query query = new Query(1, Integer.parseInt(LoginScreen.loginID), userOpt, textArea.getText());
				
				Client client = new Client();
				client.sendAction("createQuery");
	             client.sendQuery(query);
	             JOptionPane.showMessageDialog(frame, "Query submitted successfully!");
	        
					
			   }
	    	  textArea.setText(null);
	    	  selectedType = "";

	    	  userOpt = " ";
	    	        }
	      
	}
}