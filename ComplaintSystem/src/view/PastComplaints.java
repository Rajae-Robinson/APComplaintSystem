package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Client;
import model.Query;
import model.Student;
import model.Complaint;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class PastComplaints extends JPanel implements ActionListener {
    private JButton goButton;
    private JTable table;
    private JScrollPane scrollPane; 
    private JRadioButton complaintrdbtn; // declare instance variable
    private JRadioButton queryrdbtn; // declare instance variable
    private String listOption = "Complaint";

    public PastComplaints() {
        setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(51, 113, 1047, 366);
        add(scrollPane);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(36, 10, 1105, 68);
        add(panel_5);
        panel_5.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setBounds(115, 36, 119, 13);
        panel_5.add(lblNewLabel_2);
        
        complaintrdbtn = new JRadioButton("Complaint");
        complaintrdbtn.setSelected(true); // Set complaint as selected by default
        complaintrdbtn.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		  if (e.getStateChange() == ItemEvent.SELECTED) {
        			  listOption = "Complaint";
 	             }
        	}
        });
        complaintrdbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        complaintrdbtn.setBounds(36, 22, 158, 21);
        panel_5.add(complaintrdbtn);
        
        queryrdbtn = new JRadioButton("Query");
        queryrdbtn.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		  if (e.getStateChange() == ItemEvent.SELECTED) {
        			  listOption = "Query";
 	             }
        		 //JOptionPane.showMessageDialog(table, "Query selected");
	            // return;
        		// go button
        	}
        });
        queryrdbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        queryrdbtn.setBounds(204, 24, 139, 21);
        panel_5.add(queryrdbtn);
        
//        JRadioButton group = new JRadioButton();
//        group.add(complaintrdbtn);
//        group.add(queryrdbtn);

        goButton = new JButton("Go");
        goButton.setBounds(602, 16, 119, 42);
        panel_5.add(goButton);
        goButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        goButton.addActionListener(this);
        
        viewTable();
    }

    public void actionPerformed(ActionEvent e) {
        // Handle the search button click here
    	if (e.getSource()== goButton) {
    		// get text from the search box (whatever id)
    		// if there is no text call view table
    		viewTable();
    		
    		// If there is text do below
    		// If complaint
    		//client.sendAction("findComplaint");
    		//client.sendID(textFromSearchField);
    		// Complaint complaint = client.recieveComplaint();
    		// showSearchResult(complaint);
    		
    		// If Query
    		// client.sendAction("findQuery");
    		// client.sendID(textFromSearchField);
    		// Query query = client.recieveQuery();
    		// showSearchResult(query);
    	}
    }
    
    private void showSearchResult(Complaint complaint) {
    	 String[] columnNames = {"Complaint ID", "Student ID", "Category", "Responder ID", "Response Date", "Response"};
         DefaultTableModel model = new DefaultTableModel(columnNames, 0);


         Object[] rowData = {complaint.getComplaintID(), complaint.getStudentID(), complaint.getCategory(), complaint.getResponderID(), complaint.getResponseDate(), complaint.getResponse()};
         model.addRow(rowData);

         table = new JTable(model);

 		scrollPane.setViewportView(table);
    }
    
    private void showSearchResult(Query query) {
   	 String[] columnNames = {"Query ID", "Student ID", "Category", "Responder ID", "Response Date", "Response"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        Object[] rowData = {query.getQueryID(), query.getStudentID(), query.getCategory(), query.getResponderID(), query.getResponseDate(), query.getResponse()};
        model.addRow(rowData);

        table = new JTable(model);

		scrollPane.setViewportView(table);
   }

    private void viewTable() {   
        List<Complaint> complaintList = new ArrayList<Complaint>();
        List<Query> queryList = new ArrayList<Query>();
        
        if(listOption.equals("Complaint")) {
            Client client = new Client();
            client.sendAction("getComplaintsForStudent");
            client.sendID(Integer.parseInt(LoginScreen.loginID));
            complaintList = client.receiveComplaintList();
        }

        if(listOption.equals("Query")) {
            Client client = new Client();
            client.sendAction("getQueriesForStudent");
            client.sendID(Integer.parseInt(LoginScreen.loginID));
            queryList = client.receiveQueryList();
        }

        String[] columnNames = {"ID", "Student ID", "Category", "Responder ID", "Response Date", "Response"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        if(listOption == "Complaint") {
            for (Complaint complaint : complaintList) {
                Object[] rowData = {complaint.getComplaintID(), complaint.getStudentID(), complaint.getCategory(), complaint.getResponderID(), complaint.getResponseDate(), complaint.getResponse()};
                model.addRow(rowData);
            }
        }

        if(listOption == "Query") {
            for (Query query : queryList) {
                Object[] rowData = {query.getQueryID(), query.getStudentID(), query.getCategory(), query.getResponderID(), query.getResponseDate(), query.getResponse()};
                model.addRow(rowData);
            }
        }


        table = new JTable(model);

		scrollPane.setViewportView(table);
    }
}