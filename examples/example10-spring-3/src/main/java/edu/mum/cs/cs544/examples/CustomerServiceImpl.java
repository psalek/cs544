package edu.mum.cs.cs544.examples;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CustomerServiceImpl implements CustomerService {
	public CustomerServiceImpl() {
		System.out.println("Calling constructor of CustomerServiceImpl");
	}

	public void addCustomer(String customername) {
		System.out.println("Calling addCustomer of CustomerServiceImpl for " + customername);
	}

	@PostConstruct
	public void init() {
		System.out.println("Calling init method of CustomerService");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Calling cleanup method of CustomerService");
	}
}