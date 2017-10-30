package edu.mum.cs.cs544.examples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City {
	@Id
	@Column(name="city_id")
	@GeneratedValue
	private Long id;
	
	@Column(name="city")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format("City: %s, %s", name, country);
	}
	
}
