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
public class AttendanceRecord {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Timeslot timeslot;

    @ManyToOne
    private Location location;

    private LocalDate date;

    public AttendanceRecord() {
    }

    public AttendanceRecord(Student student, Timeslot timeslot, Location location, LocalDate date) {
        this.student = student;
        this.timeslot = timeslot;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
