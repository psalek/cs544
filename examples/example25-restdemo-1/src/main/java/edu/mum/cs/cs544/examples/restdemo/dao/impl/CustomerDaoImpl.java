package edu.mum.cs.cs544.examples.restdemo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.examples.restdemo.dao.CustomerDao;
import edu.mum.cs.cs544.examples.restdemo.domain.Customer;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer>implements CustomerDao {

	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT c from Customer c");
		return new ArrayList<Customer>(query.list());
	}

}
