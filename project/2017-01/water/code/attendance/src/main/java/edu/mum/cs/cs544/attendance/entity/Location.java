package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Location {
    @Id
    @GeneratedValue
    private int id;
    
    private String locationId;
    
    private String name;

    public Location() {
    }
    
    public Location(String locationId, String name) {
    	this.locationId = locationId;
        this.name = name;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
