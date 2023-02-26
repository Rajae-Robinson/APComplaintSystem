package model;

public class Login {
	private int id;
	private String password;
	
	public Login(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public boolean authenticate() {
		// Search Login table for user auth credentials
		// Show approriate error messages with JOptionPane
		return false;
	}

}
