package edu.mum.cs.cs544.timesheet.dao;

public interface BaseDAO<T> {

	public T add(T t);

	public T update(T t);

	public boolean delete(int id);

	public T get(int id);

	
}
