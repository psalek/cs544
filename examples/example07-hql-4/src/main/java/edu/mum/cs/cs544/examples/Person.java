package edu.mum.cs.cs544.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int id;
	
	private String firstname;
	private String lastname;
	
	@OneToMany(mappedBy="person")
	private List<Pet> pets = new ArrayList<Pet>();

	public Person() {
	}

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pet> getPets() {
		return Collections.unmodifiableList(pets);
	}
	
	public void addPet(Pet pet) {
		pet.setPerson(this);
		pets.add(pet);
	}
	
	public void removePet(Pet pet) {
		pet.setPerson(null);
		pets.remove(pet);
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
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", pets=" + pets + "]";
	}

}
