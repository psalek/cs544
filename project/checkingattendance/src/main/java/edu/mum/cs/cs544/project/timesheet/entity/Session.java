package edu.mum.cs.cs544.project.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by tony on 1/23/17.
 */
@Entity
public class Session {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private CourseOffering courseOffering;

    @ManyToOne
    private Timeslot timeslot;

    private LocalDate date;

    public Session() {
    }

    public Session(CourseOffering courseOffering, Timeslot timeslot, LocalDate date) {
        this.courseOffering = courseOffering;
        this.timeslot = timeslot;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
