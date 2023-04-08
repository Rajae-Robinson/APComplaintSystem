package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LiveChat extends JPanel{
	private JTextField textField;
	public LiveChat() {
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(302, 46, 459, 341);
		add(textArea);
		
		textField = new JTextField();
		textField.setBounds(302, 429, 329, 35);
		add(textField);
		textField.setColumns(10);
		
		JButton sendbtn = new JButton("SEND");
		sendbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		sendbtn.setBackground(new Color(0, 51, 102));
		sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sendbtn.setBounds(654, 429, 100, 35);
		add(sendbtn);
	}
}
