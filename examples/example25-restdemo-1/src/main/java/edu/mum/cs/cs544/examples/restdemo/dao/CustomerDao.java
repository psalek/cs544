package edu.mum.cs.cs544.examples.restdemo.dao;

import java.util.List;

import edu.mum.cs.cs544.examples.restdemo.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	List<Customer> getAll();

}
