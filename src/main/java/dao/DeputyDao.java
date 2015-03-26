package dao;

import javax.persistence.EntityManager;

import model.Deputy;
 ;
 
public class DeputyDao extends GenericDao<Long, Deputy> {
    public DeputyDao(EntityManager entityManager) {
        super(entityManager);
    }
}