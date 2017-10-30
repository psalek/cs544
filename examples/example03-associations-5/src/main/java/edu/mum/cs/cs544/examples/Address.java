package edu.mum.cs.cs544.examples;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	@OneToOne(mappedBy="address")
	private Resident resident;

	public Address() {
	}

	public Address(String street, String city, String state, String zip, Resident resident) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.resident = resident;
		resident.setAddress(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public Resident getRresident() {
		return resident;
	}

	public void setRresident(Resident resident) {
		this.resident = resident;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", resident=" + resident + "]";
	}
	
}
