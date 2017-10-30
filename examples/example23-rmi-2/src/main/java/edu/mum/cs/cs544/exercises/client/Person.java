package edu.mum.cs.cs544.exercises.client;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 5997639848192309789L;

	private String firstname;
	private String lastname;

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
