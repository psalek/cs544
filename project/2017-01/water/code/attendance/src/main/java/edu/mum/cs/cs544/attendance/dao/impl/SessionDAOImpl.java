package edu.mum.cs.cs544.attendance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.SessionDAO;
import edu.mum.cs.cs544.attendance.entity.Session;

@Transactional
@Repository
public class SessionDAOImpl extends BaseDAOImpl<Session> implements SessionDAO{

	public List<Session> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
