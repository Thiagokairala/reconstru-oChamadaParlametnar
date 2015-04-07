package dao;

import java.util.Iterator;
import java.util.List;

import model.Deputy;
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

	public void saveListOfSessions(List<Session> sessions) {
		try {
			super.beginTransaction();

			for (Session session : sessions) {
				session.validate();
				super.save(session);
			}
			super.commit();

		} catch (Exception e) {
			e.printStackTrace();
			super.rollBack();
		}
		super.close();
	}

	public List<Session> getAllSessions() {
		return super.findAll();
	}
}