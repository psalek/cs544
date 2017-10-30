package edu.mum.cs.cs544.examples.restdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.examples.restdemo.dao.CustomerDao;
import edu.mum.cs.cs544.examples.restdemo.domain.Customer;
import edu.mum.cs.cs544.examples.restdemo.service.CustomerService;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public Customer addCustomer(Customer customer) {
		return customerDao.add(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return customerDao.update(customer);
	}

	public boolean deleteCustomerById(long id) {
		return customerDao.delete(id);
	}

	public Customer getCustomerById(long id) {
		return customerDao.get(id);
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAll();
	}

	public boolean saveAll(List<Customer> customers) {
		for (Customer customer : customers) {
			addCustomer(customer);
		}
		return false;
	}

}
