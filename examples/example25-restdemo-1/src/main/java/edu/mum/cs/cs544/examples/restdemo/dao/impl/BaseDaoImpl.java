package edu.mum.cs.cs544.examples.restdemo.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.cs544.examples.restdemo.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public T add(T t) {
		sessionFactory.getCurrentSession().save(t);
		return t;
	}

	public T update(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
		return t;
	}

	public boolean delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete((T) session.load(type, id));
		return true;
	}

	public T get(long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}
}
