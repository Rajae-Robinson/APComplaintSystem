/*
 * Author: Sheneka Mitchell and Rajae Robinson
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

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
			objOS.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendComplaint(Complaint complaint) {
		try {
			objOS.writeObject(complaint);
			objOS.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendID(String id) {
		try {
			objOS.writeObject(id);
			objOS.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendID(int id) {
		try {
			objOS.writeObject(id);
			objOS.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void authenticate(String id, String password) throws IOException {
		objOS.writeObject(id);
	    objOS.writeObject(password);
	    objOS.flush();
	}
	
	public boolean receiveAuthResp() {
		boolean authenticated = false;
		try {
			authenticated = (boolean) objIS.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authenticated;
	}
	
	public Student receiveStudent() {
		Student student = new Student();
		try {
			student = (Student) objIS.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public Query receiveQuery() {
		Query query = new Query();
		try {
			query = (Query) objIS.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return query;
	}
	
	public Complaint receiveComplaint() {
		Complaint complaint = new Complaint();
		try {
			complaint = (Complaint) objIS.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return complaint;
	}
	
	public List<Complaint> receiveComplaintList() {
		List<Complaint> complaints = null;
		try {
			complaints = (List<Complaint>) objIS.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return complaints;
	}
	
	public List<Query> receiveQueryList() {
		List<Query> queries = null;
		try {
			queries = (List<Query>) objIS.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return queries;
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
