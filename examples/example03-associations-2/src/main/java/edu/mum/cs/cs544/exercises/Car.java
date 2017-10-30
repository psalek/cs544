package edu.mum.cs.cs544.exercises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String year;
	private double price;
	
	@ManyToOne
	@JoinTable(name="CUSTOMER_CAR")
	private Customer owner;

	public Car() {
	}

	public Car(String brand, String year, double price, Customer owner) {
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(year);
		sb.append(" ");
		sb.append(brand);
		sb.append(", Priced: ");
		sb.append(price);
		sb.append(", Owned by: ");
		sb.append(owner);
		
		return sb.toString();
	}

}
