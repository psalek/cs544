package cs544.exercise25_1.service;

import cs544.exercise25_1.generated.customer.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService implements ICustomerService {
	private Map<String, Customer> customers = new HashMap<String, Customer>();

	public void addCustomer(Customer customer) {
		System.out.println("Adding: "+customer.getName() + " " + customer.getCustomerNumber());
		customers.put(customer.getCustomerNumber(), customer);
	}

	public void deleteCustomer(String customerNumber) {
		System.out.println("deleting: "+customerNumber);
		customers.remove(customerNumber);
	}

	public Customer getCustomer(String customerNumber) {
		System.out.println("Retrieving: "+customerNumber);
		return customers.get(customerNumber);
	}

	public Collection<Customer> getCustomers() {
		System.out.println("Retrieving: "+customers.values());
		return customers.values();
	}

	public void updateCustomer(Customer customer) {
		System.out.println("Updating: "+customer);
		customers.put(customer.getCustomerNumber(), customer);
	}

}
