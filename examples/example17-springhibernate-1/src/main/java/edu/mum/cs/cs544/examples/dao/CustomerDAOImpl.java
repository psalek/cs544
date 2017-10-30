package edu.mum.cs.cs544.examples.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public List<Customer> getAllCustomers() {
       // Query
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer c");
        query.setParameter("countryName", "United States");

		return query.list();
	}


	public List<Customer> getCustomerList(Country country) {
        // Query
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer c where c.address.city.country.name = :countryName");
        query.setParameter("countryName", "United States");
		List<Customer> customers = query.list();

		return query.list();
	}
}
