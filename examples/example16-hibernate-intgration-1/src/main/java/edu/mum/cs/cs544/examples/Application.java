package edu.mum.cs.cs544.examples;

import java.util.List;

import edu.mum.cs.cs544.examples.entity.Address;
import edu.mum.cs.cs544.examples.entity.CreditCard;
import edu.mum.cs.cs544.examples.entity.Customer;
import edu.mum.cs.cs544.examples.service.CustomerService;

public class Application {

	public static void main(String[] args) {
		Customer customer = new Customer("Joe", "Smith");

		Address customerAddress = new Address("2000 N Court Street", "20A", "Fairfield", "Iowa", "52556");
		
		CreditCard creditCard = new CreditCard("MasterCard", "5400 1234 5678 9123");
		
		Address billingAddress = new Address("1000 N 4th Street", "Box 314", "Fairfield", "Iowa", "52557");
		
		CustomerService customerService = new CustomerService();
		
		customerService.addNewCustomer(customer, customerAddress, creditCard, billingAddress);
		
		List<Customer> customers = customerService.getCustomerList();
		
		System.out.println("\n\nList of customers:");
		for(Customer c : customers) {
			System.out.println(c);
		}
		
		System.exit(0);
    }
}
