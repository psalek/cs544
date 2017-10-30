package edu.mum.cs.cs544.examples.dataaccess;

import org.hibernate.SessionFactory;

import edu.mum.cs.cs544.examples.entity.CreditCard;
import edu.mum.cs.cs544.examples.utility.HibernateUtil;

public class CreditCardDAO {
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void create(CreditCard creditCard) {
		sf.getCurrentSession().persist(creditCard);
	}

	public CreditCard get(int id) {
		return (CreditCard) sf.getCurrentSession().get(CreditCard.class, id);
	}

	public void update(CreditCard creditCard) {
		sf.getCurrentSession().saveOrUpdate(creditCard);
	}

	public void delete(CreditCard creditCard) {
		sf.getCurrentSession().delete(creditCard);
	}
}
