package edu.mum.cs.cs544.timesheet.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.timesheet.dao.SessionDAO;
import edu.mum.cs.cs544.timesheet.entity.Session;

@Transactional
@Repository
public class SessionDAOImpl extends BaseDAOImpl<Session> implements SessionDAO{

	public List<Session> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
