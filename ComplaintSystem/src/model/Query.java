package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import controller.SessionFactoryBuilder;


public class Query implements Serializable {
	private static final long serialVersionUID = 8485189943949795110L;

	private int queryID;
    private int studentID;
    private String category;
    private String details;
    private Date responseDate;
    private Integer responderID;
    private String response;

	
	public Query() {
		this.queryID = 1;
		this.studentID = 1901709;
		this.category = "How to drop a module?";
		this.details = "I started a module late and I want to drop it.";
	}
	
    public Query(int queryID, int studentID, String category, String details) {
		this.queryID = queryID;
		this.studentID = studentID;
		this.category = category;
		this.details = details;
	}

	public int getQueryID() {
		return queryID;
	}

	public void setQueryID(int queryID) {
		this.queryID = queryID;
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
		return "Query [queryID=" + queryID + ", studentID=" + studentID + ", category=" + category + ", details="
				+ details + ", responseDate=" + responseDate + ", responderID=" + responderID + ", response=" + response
				+ "]";
	}
}
