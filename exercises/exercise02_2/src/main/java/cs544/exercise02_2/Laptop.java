package cs544.exercise02_2;

import java.util.Date;

public class Laptop {
	private long id;
	private String brand;
	private String model;
	private Date purchase_date;

	public Laptop() {
	}

	public Laptop(String brand, String model, Date purchase_date) {
		this.brand = brand;
		this.model = model;
		this.purchase_date = purchase_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchaseDate) {
		purchase_date = purchaseDate;
	}

}
