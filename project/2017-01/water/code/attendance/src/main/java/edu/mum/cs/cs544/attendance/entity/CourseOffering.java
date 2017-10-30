package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class CourseOffering {
    @Id
    @GeneratedValue
    private int courseOfferingId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private LocalDate startDate;

    private LocalDate endDate;
    
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    public CourseOffering() {}

    public CourseOffering(Course course, LocalDate startDate, LocalDate endDate) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(int courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
    
    
}
