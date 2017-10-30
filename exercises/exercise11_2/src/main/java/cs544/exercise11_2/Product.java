package cs544.exercise11_2;

public class Product {
	private int productNumber;
	private String name;
	private double price;

	public Product(int productNumber, String name, double price) {
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String toString() {
		return "productnumber=" + productNumber + "  ,name=" + name
				+ " ,price=" + price;
	}
}
