package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Complaint {
	private int complaintID;
    private int studentID;
    private String category;
    private String details;
    private Date responseDATE;
    private int responderID;
    private String response;
    
    public Complaint(int complaintID, int studentID, String category, String details, Date responseDATE,
			int responderID, String response) {
		this.complaintID = complaintID;
		this.studentID = studentID;
		this.category = category;
		this.details = details;
		this.responseDATE = responseDATE;
		this.responderID = responderID;
		this.response = response;
	}

	public void createComplaint() {
    	// Use Hibernate to create complaint in Complaint table
    }

    public List<Complaint> readAll() {
		List<Complaint> complaints = new ArrayList<>();
		
		// Read all complaints from database using Hibernate
		// ...
		
		return complaints;
	}
    
    public void deleteComplaint() {
    	// Use Hibernate to delete complaint in Complaint table
    }

}
