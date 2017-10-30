package edu.mum.cs.cs544.attendance.dao;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Session;

public interface SessionDAO extends BaseDAO<Session> {
	
	public List<Session> getAll();

}
