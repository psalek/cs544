package edu.mum.cs.cs544.examples.dataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import edu.mum.cs.cs544.examples.entity.Customer;
import edu.mum.cs.cs544.examples.utility.HibernateUtil;

public class CustomerDAO {
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void create(Customer customer) {
		sf.getCurrentSession().persist(customer);
	}

	public Customer get(int id) {
		return (Customer) sf.getCurrentSession().get(Customer.class, id);
	}

	public void update(Customer customer) {
		sf.getCurrentSession().saveOrUpdate(customer);
	}

	public void delete(Customer customer) {
		sf.getCurrentSession().delete(customer);
	}
	
	public List<Customer> getCustomerList() {
		Query q = sf.getCurrentSession().getNamedQuery("Customer.All");
		return q.list();
	}
}

