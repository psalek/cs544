package edu.mum.cs.cs544.examples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CustomerDAO dao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createRecords() {
		Session session = sessionFactory.getCurrentSession();

		Customer john = new Customer("John", "Doe");
		session.persist(john);

		Car car1 = new Car("BMW", "2015", 30221.00, john);
		session.persist(car1);

		Car car2 = new Car("Mercedes", "2016", 4088.00, john);
		session.persist(car2);

		session.save(john);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public void readRecords() {
		Session session = null;
		session = sessionFactory.getCurrentSession();

		// retieve all cars
		@SuppressWarnings("unchecked")
		List<Car> carList = session.createQuery("from Car").list();

		System.out.println("\nList of cars:");
		for (Car car : carList) {
			System.out.println(car);
		}
		System.out.println();
	}
}
