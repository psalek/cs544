package edu.mum.cs.cs544.examples;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Faculty extends Person {
	
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Course course;

	public Faculty() {
	}

	public Faculty(String firstName, String lastName, Double salary) {
		super(firstName, lastName);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Faculty [salary=" + salary + super.toString() + ", course=" + course + "]";
	}
	
}
