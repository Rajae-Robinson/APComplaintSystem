package view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Complaint;
import model.Query;

public class PastQueries {
	private JPanel pastQueriesFrame = new JPanel();
	
	public PastQueries() {
		pastQueriesFrame.setLayout(new GridBagLayout());
		JLabel queryHeading = new JLabel("Past Queries");
		
		JTable queryTable = new JTable();
		DefaultTableModel queryTableModel = new DefaultTableModel(
		        new Object[][]{},
		        new String[]{"Type", "ID", "Advisor", "Last Response Date"}
		);
		queryTable.setModel(queryTableModel);
		
		for (Query query : new Query().readAll()) {
		    String type = "Query";
		    int id = query.getQueryID();
		    int advisor = 0;
		    if(query.getResponderID() != null) {
		    	advisor = query.getResponderID();
		    }
		    Date lastResponseDate = query.getResponseDate();
		    queryTableModel.addRow(new Object[]{type, id, advisor, lastResponseDate});
		}
		queryTable.setEnabled(false);
		queryTable.setCellSelectionEnabled(false);
		queryTable.setPreferredScrollableViewportSize(new Dimension(450, 200));
		
		JLabel complaintsHeading = new JLabel("Past Complaints");
		
		JTable complaintTable = new JTable();
		DefaultTableModel complaintTableModel = new DefaultTableModel(
		        new Object[][]{},
		        new String[]{"Type", "ID", "Advisor", "Last Response Date"}
		);
		complaintTable.setModel(complaintTableModel);

		for (Complaint complaint : new Complaint().readAll()) {
		    String type = "Complaint";
		    int id = complaint.getComplaintID();
		    int advisor = 0;
		    if(complaint.getResponderID() != null) {
		    	advisor = complaint.getResponderID();
		    }
		    Date lastResponseDate = complaint.getResponseDate();
		    complaintTableModel.addRow(new Object[]{type, id, advisor, lastResponseDate});
		}
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		pastQueriesFrame.add(queryHeading, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pastQueriesFrame.add(queryTable, gbc);
		pastQueriesFrame.add(complaintsHeading);
		pastQueriesFrame.add(complaintTable);
		pastQueriesFrame.setVisible(true);
	}

	public JPanel getPastQueriesFrame() {
		return pastQueriesFrame;
	}
}
