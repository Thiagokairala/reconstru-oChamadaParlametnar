package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Session;

public class SessionsDao extends GenericDao<Long, Session> {
	public SessionsDao(EntityManager entityManager) {
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

	public List<Session> findAll() {
		return super.findAll();
	}
}