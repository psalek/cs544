package edu.mum.cs.cs544.examples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import edu.mum.cs.cs544.examples.entity.Address;

@Entity
@NamedQueries({ @NamedQuery(name = "Customer.All", query = "from Customer") })
public class Customer {
	@Id
	@Column(name="customer_id")
	@GeneratedValue	
	private Long id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Customer: ");
		sb.append(firstName);
		sb.append(" ");
		sb.append(lastName);
		
		sb.append(", email: ");
		sb.append(email);
		
		sb.append(", ");
		sb.append(address);
		
		return sb.toString();
	}
	
}
