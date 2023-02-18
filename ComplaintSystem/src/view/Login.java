package view;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login {
	public Login() {
		JFrame loginFrame = new DefaultFrame();
		loginFrame.setLayout(new FlowLayout());
		
		ImageIcon logo = new ImageIcon("../img/logo.png");
		JLabel heading = new JLabel("Complaint & Query System");
		heading.setIcon(logo);
		heading.setHorizontalTextPosition(JLabel.CENTER);
        heading.setVerticalTextPosition(JLabel.BOTTOM);
        
     // Create the radio buttons and add them to a button group
        JRadioButton studentButton = new JRadioButton("Student");
        JRadioButton staffButton = new JRadioButton("Staff");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(studentButton);
        buttonGroup.add(staffButton);
        
        // Create the input fields and their labels
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(7);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20); // 20 is the number of columns in the password field
        
        JButton loginButton = new JButton("Login");
        
		loginFrame.add(heading);
        loginFrame.add(studentButton);
        loginFrame.add(staffButton);
        loginFrame.add(idLabel);
        loginFrame.add(idField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);
		loginFrame.setVisible(true);
	}
	
}
