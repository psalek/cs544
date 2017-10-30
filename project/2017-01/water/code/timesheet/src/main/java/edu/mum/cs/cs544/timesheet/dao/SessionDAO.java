package edu.mum.cs.cs544.timesheet.dao;

import java.util.List;

import edu.mum.cs.cs544.timesheet.entity.Session;

public interface SessionDAO extends BaseDAO<Session> {
	
	public List<Session> getAll();

}
