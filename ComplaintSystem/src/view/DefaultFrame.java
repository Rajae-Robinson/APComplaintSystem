package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DefaultFrame extends JFrame {
	public DefaultFrame() {
		this.setTitle("UTECH Complaint & Query System");
		this.setSize(1024, 768);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon logo = new ImageIcon("../img/logo.png");
		this.setIconImage(logo.getImage());
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
}
