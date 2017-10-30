package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Session {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "courseOfferingId")
    private CourseOffering courseOffering;

    @ManyToOne
    @JoinColumn(name = "timeSlotId")
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
