package edu.mum.cs.cs544.examples;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void add(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	}

	public Customer get(int id) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	public void update(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	public void delete(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}
	
	public List<Customer> getCustomerList() {
		Query q = sessionFactory.getCurrentSession().getNamedQuery("Customer.All");
		return q.list();
	}

}
