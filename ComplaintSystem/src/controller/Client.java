package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import model.Complaint;
import model.Query;
import model.Student;

public class Client {
	private static final int PORT = 8888;
	private static final String HOST = "127.0.0.1";
	private static Socket connectionSocket;
	private ObjectOutputStream objOS;
	private ObjectInputStream objIS;
	private String action = "";
	
	public Client() {
		this.createConnection();
		this.configureStreams();
	}
	
	private void createConnection() {
		try {
			connectionSocket = new Socket(HOST, PORT);
			System.out.println("Student Client Connected to server...");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objOS = new ObjectOutputStream(connectionSocket.getOutputStream());
			objIS = new ObjectInputStream(connectionSocket.getInputStream());
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void closeConnection() {
		try {
			objOS.close();
			objIS.close();
			connectionSocket.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendAction(String action) {
		this.action = action;
		try {
			objOS.writeObject(action);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendID(String id) {
		this.action = action;
		try {
			objOS.writeObject(action);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void authenticate(String id, String password) throws IOException {
		objOS.writeObject(id);
	    objOS.writeObject(password);
	    objOS.flush();
	}
	
	public <T> T receiveResponse(Class<T> clazz) {
		try {
			switch (action) {
			case "authenticate":
				return clazz.cast(objIS.readObject());
            case "findComplaint":
                return clazz.cast(objIS.readObject());
            case "findQuery":
                return clazz.cast(objIS.readObject());
            case "deleteComplaint":
                return clazz.cast(objIS.readObject());
            case "deleteQuery":
                return clazz.cast(objIS.readObject());
            default:
                System.err.println("Unknown action: " + action);
                break;
			}	
		} catch(ClassCastException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public <T> List<T> receiveListResponses(Class<T> clazz) {
		try {
			switch (action) {
            case "getStudents":
            	 List<Student> students = (List<Student>) objIS.readObject();
 	            return (List<T>) students;
            case "getComplaints":
            	List<Complaint> complaints = (List<Complaint>) objIS.readObject();
            	return (List<T>) complaints;
            case "getQueries":
            	List<Query> queries = (List<Query>) objIS.readObject();
            	return (List<T>) queries;
            default:
                // handle other actions
                break;
			}	
		} catch(ClassCastException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
