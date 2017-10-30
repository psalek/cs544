package edu.mum.cs.cs544.examples;

import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MY_PERSON")
public class Person {
	private long id;
	private String firstname;
	private String lastname;

	public Person() {
	}

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return firstname + " " + lastname;
	}

	public void setName(String name) {
		StringTokenizer st = new StringTokenizer(name);
		firstname = st.nextToken();
		lastname = st.nextToken();
	}

	@Transient
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Transient
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person [" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}