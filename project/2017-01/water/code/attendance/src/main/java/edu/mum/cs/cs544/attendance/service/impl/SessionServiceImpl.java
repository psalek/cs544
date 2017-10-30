package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.entity.Session;
import edu.mum.cs.cs544.attendance.service.SessionService;

@Transactional
@Service
public class SessionServiceImpl implements SessionService{

	public Session addSession(Session session) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session updateSession(Session session) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteSessionById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Session getSessionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Session> getAllSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveAll(List<Session> sessions) {
		// TODO Auto-generated method stub
		return false;
	}

}
