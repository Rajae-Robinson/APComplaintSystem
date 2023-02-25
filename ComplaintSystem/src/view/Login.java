package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	private JFrame loginFrame = new DefaultFrame();
	private JButton loginButton;
	private JTextField idField;
	private JPasswordField passwordField;
	
	public Login() {
		loginFrame.setLayout(new GridBagLayout());
		
		JLabel heading = new JLabel("Student Complaint & Query System");
        
        
        // Create the input fields and their labels
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(7);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20); // 20 is the number of columns in the password field
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 10, 0);
        loginFrame.add(heading, gc);
		
        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 10, 0);
        
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

	@Override
	public void actionPerformed(ActionEvent e) {
		 // Handle login button click event
	      if (e.getSource() == loginButton) {
	         String id = idField.getText();
	         char[] passwordChars = passwordField.getPassword();
	         String password = new String(passwordChars);

	         // Check id and password here in database here
	         // ...

	         // Display message
	         JOptionPane.showMessageDialog(loginFrame, "Login successful");
	         // Navigate to dashboard screen
	      }
	}
	
}
