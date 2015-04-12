package dao;

import java.util.Iterator;
import java.util.List;

import model.PoliticalParty;

public class PoliticalPartyDao extends GenericDao<Long, PoliticalParty> {
	public PoliticalPartyDao() {
		super();
	}

	public void savePoliticalParty(PoliticalParty politicalParty) {
		try {
			super.beginTransaction();
			super.save(politicalParty);
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.rollBack();
		}
		super.close();
	}

	public void saveListOfPoliticalParties(List<PoliticalParty> politicalParties) {
		try {
			super.beginTransaction();
			Iterator<PoliticalParty> it = politicalParties.iterator();
			while (it.hasNext()) {
				PoliticalParty politicalParty = it.next();
				super.save(politicalParty);
			}
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			super.rollBack();
		}
		super.close();
	}

	public List<PoliticalParty> getAllPoliticalParties() {
		List<PoliticalParty> politicalParties = super.findAll();
		super.close();
		return politicalParties;
	}

}
