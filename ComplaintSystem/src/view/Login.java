package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login {
	public Login() {
		JFrame loginFrame = new DefaultFrame();
		loginFrame.setLayout(new GridBagLayout());
		
		ImageIcon logo = new ImageIcon("../img/logo.png");
		JLabel heading = new JLabel("Complaint & Query System");
		heading.setIcon(logo);
//		heading.setHorizontalTextPosition(JLabel.CENTER);
//        heading.setVerticalTextPosition(JLabel.BOTTOM);
        
        
        
     // Create the radio buttons and add them to a button group
        JRadioButton studentButton = new JRadioButton("Student");
        JRadioButton staffButton = new JRadioButton("Staff");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(studentButton);
        buttonGroup.add(staffButton);
        JPanel radioBtns = new JPanel();
        radioBtns.setLayout(new FlowLayout());
        
        // Create the input fields and their labels
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(7);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20); // 20 is the number of columns in the password field
        
        JButton loginButton = new JButton("Login");
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 10, 0);
        loginFrame.add(heading, gc);
		
        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 10, 0);
        radioBtns.add(studentButton);
        radioBtns.add(staffButton);
        loginFrame.add(radioBtns, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        loginFrame.add(idLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        loginFrame.add(idField, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        loginFrame.add(passwordLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        loginFrame.add(passwordField, gc);
        
        gc.gridx = 3;
        gc.gridy = 4;
        loginFrame.add(loginButton, gc);
        
		loginFrame.setVisible(true);
	}
	
}
