package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Deputy;
import model.PoliticalParty;

public class DeputyDao extends GenericDao<Long, Deputy> {
	public DeputyDao() {
		super();
	}

	public void saveDeputy(Deputy deputy) {
		try {
			super.beginTransaction();
			super.save(deputy);
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.rollBack();
		}
		super.close();
	}

	public void saveListOfDeputies(List<Deputy> deputies,
			List<PoliticalParty> politicalParties) {
		try {
			Map<String, PoliticalParty> politicalPartiesMap = this
					.prepareMap(politicalParties);
			super.beginTransaction();
			Iterator<Deputy> it = deputies.iterator();
			while (it.hasNext()) {
				Deputy deputy = it.next();
				deputy.setPoliticalParty(politicalPartiesMap.get(deputy
						.getPoliticalParty().getAchronym()));
				super.save(deputy);
			}
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			super.rollBack();
		}
		super.close();
	}

	private Map<String, PoliticalParty> prepareMap(
			List<PoliticalParty> politicalParties) {
		Map<String, PoliticalParty> mapOfPoliticalParties = new HashMap<String, PoliticalParty>();
		for (PoliticalParty politicalParty : politicalParties) {
			mapOfPoliticalParties.put(politicalParty.getAchronym(),
					politicalParty);
		}
		return mapOfPoliticalParties;
	}

	public List<Deputy> getAllDeputies() {
		List<Deputy> deputies = super.findAll();
		super.close();
		return deputies;
	}

	public void update(Deputy deputy) {
		super.beginTransaction();
		super.update(deputy);
		super.commit();
		super.close();
	}

	public void updateListOfDeputies(List<Deputy> deputies) {
		super.beginTransaction();

		for (Deputy deputy : deputies) {
			super.save(deputy);
		}
		super.commit();
		super.close();

	}

}