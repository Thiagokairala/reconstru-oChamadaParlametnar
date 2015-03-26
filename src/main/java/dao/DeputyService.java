package dao;

import java.util.List;

import model.Deputy;
 
public class DeputyService {
    private DeputyDao dao;
     
    private SimpleEntityManager simpleEntityManager;
     
    public DeputyService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new DeputyDao(simpleEntityManager.getEntityManager());
    }
     
    public void save(Deputy deputy){
        try{
            simpleEntityManager.beginTransaction();
            deputy.validate();
            dao.save(deputy);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Deputy> findAll(){
        return dao.findAll();
    }
}