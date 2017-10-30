package edu.mum.cs.cs544.project.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tony on 1/23/17.
 */
@Entity
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String barCode;

    public Student() {
    }

    public Student(String studentId, String firstName, String lastName, String barCode) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.barCode = barCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
