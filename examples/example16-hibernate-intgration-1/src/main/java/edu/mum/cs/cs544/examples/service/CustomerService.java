package edu.mum.cs.cs544.examples.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.mum.cs.cs544.examples.dataaccess.AddressDAO;
import edu.mum.cs.cs544.examples.dataaccess.CreditCardDAO;
import edu.mum.cs.cs544.examples.dataaccess.CustomerDAO;
import edu.mum.cs.cs544.examples.entity.Address;
import edu.mum.cs.cs544.examples.entity.CreditCard;
import edu.mum.cs.cs544.examples.entity.Customer;
import edu.mum.cs.cs544.examples.utility.HibernateUtil;

public class CustomerService {
	private CustomerDAO customerDao = new CustomerDAO();
	private AddressDAO addressDao = new AddressDAO();
	private CreditCardDAO ccDao = new CreditCardDAO();
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void addNewCustomer(Customer customer, Address customerAddress, CreditCard creditCard, Address billingAddress) { 
		creditCard.setBillingAddress(billingAddress); 
		customer.setAddress(customerAddress); 
		customer.setCreditCard(creditCard); 
		
		Transaction tx = sf.getCurrentSession().beginTransaction(); 
		
		addressDao.create(customerAddress); 
		addressDao.create(billingAddress); 
		ccDao.create(creditCard); 
		customerDao.create(customer); 
		
		tx.commit(); 
	}
	
	public List<Customer> getCustomerList() {
		Transaction tx = sf.getCurrentSession().beginTransaction(); 
		List<Customer> customerList = customerDao.getCustomerList(); 
		System.out.println("Finished loading the list of customers...");
		tx.commit(); 
		
		return customerList;
	}
}
