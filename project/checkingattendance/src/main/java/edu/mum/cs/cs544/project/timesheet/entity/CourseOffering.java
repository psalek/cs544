package edu.mum.cs.cs544.project.timesheet.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by tony on 1/23/17.
 */
@Entity
public class CourseOffering {
    @Id
    private String courseOfferingId;

    @ManyToOne
    private Course course;

    private LocalDate startDate;

    private LocalDate endDate;

    public CourseOffering() {}

    public CourseOffering(String courseOfferingId, Course course, LocalDate startDate, LocalDate endDate) {
        this.courseOfferingId = courseOfferingId;
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
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
}
