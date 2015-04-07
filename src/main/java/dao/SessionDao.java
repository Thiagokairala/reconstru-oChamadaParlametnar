package dao;

import java.util.List;

import model.Session;

public class SessionDao extends GenericDao<Long, Session> {
	public SessionDao() {
		super();
	}

	public void saveSession(Session session) {
		try {
			super.beginTransaction();
			session.validate();
			super.save(session);
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			super.rollBack();
		}
	}

	public List<Session> getAllSessions() {
		return super.findAll();
	}
}