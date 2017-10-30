package edu.mum.cs.cs544.examples;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student extends Person {
	@Column(name="ENTRY_DATE")
	private Date entryDate;
	
	@ManyToOne
	@JoinColumn(name="COURSE_OFFERING_ID")
	private CourseOffering courseOffering;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, Date entryDate) {
		super(firstName, lastName);
		this.entryDate = entryDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public CourseOffering getCourseOffering() {
		return courseOffering;
	}

	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}

	@Override
	public String toString() {
		return "Student [entryDate=" + entryDate + super.toString() + ", courseOffering=" + courseOffering + "]";
	}
}
