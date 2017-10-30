package edu.mum.cs.cs544.examples.restdemo.dao;

public interface BaseDao<T> {

	T add(T t);

	T update(T t);

	boolean delete(long id);

	T get(long id);

}
