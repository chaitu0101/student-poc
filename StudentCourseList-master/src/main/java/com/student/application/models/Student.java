
package com.student.application.models;

import java.io.Serializable;
import java.util.*;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;









@Entity
@Table(name = "Student_profile")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="seq")
	@Column(name="student_id")
	int studentId;
	

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "emailId")
	String emailId;
	

	@Column(name = "phone", nullable = false)
	String phone;
	
	@Column(name = "dob", nullable = false)
	String dob;

	@Embedded
	private Address address;
	
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "studentId") },
	inverseJoinColumns = { @JoinColumn(name = "courseId") })
	private Set<Courses> courses = new HashSet<Courses>(0);

	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}



	public Set<Courses> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	
	public boolean hasCourse(Courses courses) {
		for (Courses studentCourse: getCourses()) {
			if (studentCourse.getCourseId() == courses.getCourseId()) {
				return true;
			}
		}
		return false;
	}	

}