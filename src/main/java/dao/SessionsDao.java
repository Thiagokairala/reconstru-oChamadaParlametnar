package dao;

import javax.persistence.EntityManager;

import model.Session;
 ;
 
 public class SessionsDao extends GenericDao<Long, Session> {
	    public SessionsDao(EntityManager entityManager) {
	        super();
	    }
}