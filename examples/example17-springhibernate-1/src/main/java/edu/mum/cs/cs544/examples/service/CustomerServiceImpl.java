package edu.mum.cs.cs544.examples.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs544.examples.dao.CustomerDAO;
import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    SessionFactory sessionFactory;
	
	@Autowired
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public List<Customer> getAllCustomers() {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		List<Customer> customers = customerDAO.getAllCustomers();
		tx.commit();
		
		return customers;
	}

	public List<Customer> getCustomerList(Country country) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		List<Customer> customers = customerDAO.getCustomerList(country);
		tx.commit();
		
		return customers;
	}
	
	
}
