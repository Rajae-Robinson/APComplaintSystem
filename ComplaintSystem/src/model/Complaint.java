package model;

import java.util.Date;
import java.util.ArrayList;
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
@Table(name = "complaint")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "complaintID")
	private int complaintID;
	
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

	public void createComplaint() {
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

    public List<Complaint> readAll() throws HibernateException {
		List<Complaint> complaints = new ArrayList<>();
		Session session = null;
		
		try {
            session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            complaints = session.createQuery("from Complaint", Complaint.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        }
		
		return complaints;
	}
    
    public void deleteComplaint(int complaintID) {
    	Session session = null;

        try {
        	session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Complaint query = session.get(Complaint.class, complaintID);
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
