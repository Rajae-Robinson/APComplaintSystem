package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FAQ extends JPanel {
	public FAQ() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Freaguently Asked Questions");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(405, 28, 374, 52);
		add(lblNewLabel);
		
		JTextArea textArea = new JTextArea("QUESTION 1: How can I reset moodle password?\n ANSWER: Contact tier1support@utech.edu.jm \n\n QUESTION 2: Where do I go when I have admission challenges?\r\n"
				+ "ANSWER:Students who are having admission challenges should speak with one of the following\n the Student Affairs Assistant, their Advisor, and the Programme Director or visit\n the Admissions Department’s Lab.\r\n\n"
				+ "QUESTION 3: What are the deadlines for the following?\r\n"
				+ "ANSWER:\n i) Grade Forgiveness\r\n"
				+ "-2nd week of classes\r\n"
				+ "ii) Add Drop\r\n"
				+ "-2nd week of classes,\r\n"
				+ "iii) Independent Study\r\n"
				+ "-3rd week of classes\r\n"
				+ "iv) Withdrawal from Module\r\n"
				+ "-Two weeks before the end of classes\r\n\n"
				+ "QUESTION 4:What are the requirements for Grade Forgiveness?\r\n"
				+ "ANSWER: The University only grants GradeForgiveness for Levels 1 and 2 modules;\r\n"
				+ "therefore only request for Years 1 and 2modules will be approved for Grade Forgiveness\r\n"
				+ "or visit the Admissions Department’s Lab.");
		add(textArea);
		textArea.setTabSize(9);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(137, 90, 902, 503);
	}
}
