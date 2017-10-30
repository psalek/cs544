package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Session;

public interface SessionService {
	
	public Session addSession(Session session);

	public Session updateSession(Session session);

	public boolean deleteSessionById(int id);

	public Session getSessionById(int id);

	public List<Session> getAllSessions();

	public boolean saveAll(List<Session> sessions);

}
