package edu.mum.cs.cs544.examples.service;

import java.util.List;

import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomerList(Country country);
}
