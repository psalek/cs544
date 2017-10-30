package edu.mum.cs.cs544.examples;

public class CustomerServiceImpl implements CustomerService {
	public CustomerServiceImpl() {
		System.out.println("Calling constructor of CustomerServiceImpl");
	}

	public void addCustomer(String customername) {
		System.out.println("Calling addCustomer of CustomerServiceImpl for " + customername);
	}

	public void init() {
		System.out.println("Calling init method of CustomerService");
	}

	public void cleanup() {
		System.out.println("Calling cleanup method of CustomerService");
	}
}