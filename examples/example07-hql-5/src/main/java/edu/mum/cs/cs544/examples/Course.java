package edu.mum.cs.cs544.examples;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable( 
	name="CourseDescription", 
	pkJoinColumns=@PrimaryKeyJoinColumn(name="COURSE_ID") 
)
public class Course {
	@Id
	@Column(name="COURSE_ID")
	private String courseId;
	
	private String title;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(table="CourseDescription")
	private String description;

	public Course() {
		super();
	}

	public Course(String courseId, String title, String description) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.description = description;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
