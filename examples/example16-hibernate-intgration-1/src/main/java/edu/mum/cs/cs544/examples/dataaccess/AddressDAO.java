package edu.mum.cs.cs544.examples.dataaccess;

import org.hibernate.SessionFactory;

import edu.mum.cs.cs544.examples.entity.Address;
import edu.mum.cs.cs544.examples.utility.HibernateUtil;

public class AddressDAO {
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void create(Address addr) {
		sf.getCurrentSession().persist(addr);
	}

	public Address get(int id) {
		return (Address) sf.getCurrentSession().get(Address.class, id);
	}

	public void update(Address addr) {
		sf.getCurrentSession().saveOrUpdate(addr);
	}

	public void delete(Address addr) {
		sf.getCurrentSession().delete(addr);
	}
}
