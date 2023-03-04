package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import controller.SessionFactoryBuilder;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "password")
	private String password;
	
	public Login() {
		this.id = 2006677;
		this.password = "password";
	}
	
	public Login(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public boolean authenticate() throws HibernateException {
	    Session session = null;
	    try {
	        session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        Query<Login> query = session.createQuery("from Login where id = :id and password = :password", Login.class);
	        query.setParameter("id", this.id);
	        query.setParameter("password", this.password);
	        Login login = query.uniqueResult();
	        session.getTransaction().commit();
	        return login != null;
	    } catch (HibernateException e) {
	        if (session != null && session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        throw e;
	    }
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
