package edu.mum.cs.cs544.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SecondaryTable(name="Birth")
public class Pet {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Temporal(value = TemporalType.DATE)
	@Column(table="Birth")
	private Date birthdate;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Person person;
	
	@OneToMany
	@JoinColumn(name="toy_id")
	private List<Toy> toys = new ArrayList<Toy>();

	public Pet() {
	}

	public Pet(String name, Date birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Toy> getToys() {
		return Collections.unmodifiableList(toys);
	}
	
	public void addToy(Toy toy) {
		toys.add(toy);
	}
	
	public void removeToy(Toy toy) {
		toys.remove(toy);
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", toys=" + toys + "]";
	}

}
