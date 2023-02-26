package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Query {
	private int queryID;
    private int studentID;
    private String category;
    private String details;
    private Date responseDate;
    private int responderID;
    private String response;
	
    public Query(int queryID, int studentID, String category, String details, Date responseDate, int responderID,
			String response) {
		this.queryID = queryID;
		this.studentID = studentID;
		this.category = category;
		this.details = details;
		this.responseDate = responseDate;
		this.responderID = responderID;
		this.response = response;
	}

	public void createQuery() {
    	// Use Hibernate to create query in Query table
    }

    public List<Query> readAll() {
		List<Query> queries = new ArrayList<>();
		
		// Read all complaints from database using Hibernate
		// ...
		
		return queries;
	}
    
    public void findQuery(int queryID) {
    	// Search Query table for query with a specific id
    }
    
    public void deleteQuery() {
    	// Use Hibernate to delete query in Query table
    }

}
