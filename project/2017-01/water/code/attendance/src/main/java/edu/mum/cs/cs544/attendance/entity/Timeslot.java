package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class Timeslot {
	@Id
	private int id;

	private String abbreviation;

	private String description;

	private LocalTime beginTime;

	private LocalTime endTime;

	public Timeslot() {
	}

	public Timeslot(String abbreviation, String description, LocalTime beginTime, LocalTime endTime) {
		this.abbreviation = abbreviation;
		this.description = description;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(LocalTime beginTime) {
		this.beginTime = beginTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
}
