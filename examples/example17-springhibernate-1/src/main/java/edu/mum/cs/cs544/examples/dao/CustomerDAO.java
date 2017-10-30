package edu.mum.cs.cs544.examples.dao;

import java.util.List;

import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomerList(Country country);
}
