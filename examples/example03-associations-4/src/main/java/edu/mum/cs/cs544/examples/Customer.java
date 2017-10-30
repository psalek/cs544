package edu.mum.cs.cs544.examples;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	private String lastName;

	@OneToMany //(mappedBy="owner")
	@JoinColumn(name="customerId")
	private List<Car> cars = new ArrayList<Car>();

	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void addCar(Car car) {
		cars.add(car);
	}

    public void removeCar(Car c) {
        cars.remove(c);
    }
    
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
