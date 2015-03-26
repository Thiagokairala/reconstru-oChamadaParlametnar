package dao;

import java.util.Iterator;
import java.util.List;

import model.Deputy;

public class DeputyDao extends GenericDao<Long, Deputy> {
	public DeputyDao() {
		super();
	}

	public void saveDeputy(Deputy deputy) {
		try {
			super.beginTransaction();
			deputy.validate();
			super.save(deputy);
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.rollBack();
		}
		this.close();
	}

	public void saveListOfDeputies(List<Deputy> deputies) {
		try {
			super.beginTransaction();
			Iterator<Deputy> it = deputies.iterator();
			while (it.hasNext()) {
				Deputy deputy = it.next();
				deputy.validate();
				super.save(deputy);
			}
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			super.rollBack();
		}
		this.close();
	}

	public List<Deputy> findAll() {
		return super.findAll();
	}
}