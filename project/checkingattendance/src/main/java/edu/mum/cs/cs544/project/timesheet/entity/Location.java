package edu.mum.cs.cs544.project.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tony on 1/23/17.
 */
@Entity
public class Location {
    @Id
    private String locationId;
    private String name;

    public Location() {
    }

    public Location(String locationId, String name) {
        this.locationId = locationId;
        this.name = name;
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
