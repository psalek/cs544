package edu.mum.cs.cs544.examples.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private int id;
	
	private String street; 
	private String apartment; 
	private String city; 
	private String state; 
	private String zip;
	
	public Address() {
		super();
	}

	public Address(String street, String apartment, String city, String state, String zip) {
		super();
		this.street = street;
		this.apartment = apartment;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", apartment=" + apartment + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	} 

}
