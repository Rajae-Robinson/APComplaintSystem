package view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PastQueries {
	private JFrame pastQueriesFrame = new DefaultFrame();
	
	public PastQueries() {
		pastQueriesFrame.setLayout(new GridBagLayout());
		String[] columnNames = {"Type", "ID", "Advisor", "Last Response Date"};
		Object[][] data = {
		    {"Complaint", 2530, "John", "Sept."},
		    {"Query", 3078, "Mary", "Nov"},
		};

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable(model);
		table.setEnabled(false);
		table.setCellSelectionEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(450, 200));

		JLabel heading = new JLabel("Past Queries");
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		pastQueriesFrame.add(heading, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pastQueriesFrame.add(table, gbc);
		pastQueriesFrame.setVisible(true);
	}
	
	public JFrame getPastQueriesFrame() {
		return pastQueriesFrame;
	}
}
