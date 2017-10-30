package edu.mum.cs.cs544.examples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {
	@Id()
	@Column(name="country_id")
	@GeneratedValue
	private long id;
	
	@Column(name="country")
	private String name;
	
	public Country() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("%03d %s", id, name);
	}

}
