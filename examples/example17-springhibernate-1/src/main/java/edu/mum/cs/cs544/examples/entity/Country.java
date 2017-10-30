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
	
	public Country(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Country: %s", name);
	}

}
