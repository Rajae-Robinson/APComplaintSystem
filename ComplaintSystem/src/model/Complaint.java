/*
 * Author: Sheneka Mitchell and Rajae Robinson
 */
package model;

import java.util.Date;
import java.io.Serializable;

public class Complaint implements Serializable {
	private static final long serialVersionUID = -8928497947145342486L;

	private int complaintID;
    private int studentID;
    private String category;
    private String details;
    private Date responseDate;
    private Integer responderID;
    private String response;
    
    public Complaint() {
		this.complaintID = 1;
		this.studentID = 1901709;
		this.category = "Missing grades";
		this.details = "'My grades are missing for Math.";
	}
    
    public Complaint(int complaintID, int studentID, String category, String details) {
		this.complaintID = complaintID;
		this.studentID = studentID;
		this.category = category;
		this.details = details;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public Integer getResponderID() {
		return responderID;
	}

	public void setResponderID(Integer responderID) {
		this.responderID = responderID;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", studentID=" + studentID + ", category=" + category
				+ ", details=" + details + ", responseDate=" + responseDate + ", responderID=" + responderID
				+ ", response=" + response + "]";
	}
}
