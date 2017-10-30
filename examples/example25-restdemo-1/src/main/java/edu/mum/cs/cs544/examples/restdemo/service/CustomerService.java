package edu.mum.cs.cs544.examples.restdemo.service;

import java.util.List;

import edu.mum.cs.cs544.examples.restdemo.domain.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	boolean deleteCustomerById(long id);

	Customer getCustomerById(long id);

	List<Customer> getAllCustomers();

	boolean saveAll(List<Customer> customers);
	
}
