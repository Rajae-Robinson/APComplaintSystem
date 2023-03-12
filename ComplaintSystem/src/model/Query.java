package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import controller.SessionFactoryBuilder;

@Entity
@Table(name = "query")
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "queryID")
	private int queryID;
	
	@Column(name = "studentID")
    private int studentID;
	
	@Column(name = "category")
    private String category;
	
	@Column(name = "details")
    private String details;
	
	@Column(name = "responseDate")
    private Date responseDate;
	
	@Column(name = "responderID")
    private Integer responderID;
	
	@Column(name = "response")
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

	public void createQuery() {
		Session session = null;
		try {
			session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
	        session.save(this);
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        if (session.getTransaction() != null) {
	        	session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
    }

    public List<Query> readAll() throws HibernateException {
    	Session session = null;
		List<Query> queries = new ArrayList<>();
		
		try {
            session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            queries = session.createQuery("from Query", Query.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        }
		
		return queries;
	}
    
    public Query findQuery(int queryID) {
    	Session session = null;
        Query query = null;

        try {
        	session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            query = session.get(Query.class, queryID);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return query;
    }
    
    public void deleteQuery(int queryID) {
    	Session session = null;

        try {
        	session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query query = session.get(Query.class, queryID);
            session.delete(query);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
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
