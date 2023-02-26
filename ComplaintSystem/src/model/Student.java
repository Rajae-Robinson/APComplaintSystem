package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    
    
    public Student(int studentID, String firstName, String lastName, String email, String contactNumber) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}


	public List<Student> readAll() {
		List<Student> students = new ArrayList<>();
		
		// Read all students from database using Hibernate
		// ...
		
		return students;
	}
}
