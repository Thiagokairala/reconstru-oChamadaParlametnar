package dao;

import java.util.List;

import model.Session;
 
public class SessionsService {
    private SessionsDao dao;
     
    private SimpleEntityManager simpleEntityManager;
     
    public SessionsService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new SessionsDao(simpleEntityManager.getEntityManager());
    }
     
    public void save(Session product){
        try{
            simpleEntityManager.beginTransaction();
            product.validate();
            dao.save(product);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Session> findAll(){
        return dao.findAll();
    }
}