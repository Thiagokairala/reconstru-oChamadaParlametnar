package dataParser;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import webServiceConnector.DeputyConnector;
import model.PoliticalParty;
import dao.PoliticalPartyDao;
import exception.WebServiceNotAvailable;

public class PoliticalPartyParser {
	public PoliticalParty getOneParty(long idParty) {
		PoliticalParty party;

			party = this.getOnePartyFromDataBase(idParty);
		

		assert (party != null);
		return party;
	}
	
	private PoliticalParty getOnePartyFromDataBase(long idParty) {
		PoliticalPartyDao partyDao = new PoliticalPartyDao();
		PoliticalParty party = partyDao.getById(idParty);
		return party;
	}
	
	public List<PoliticalParty> getAllPoliticalParties() {
		List<PoliticalParty> politicalParties;

		try {
			politicalParties = this.getAllPoliticalPartiesFromWebService();
		} catch (WebServiceNotAvailable e) {
			politicalParties = this.getAllPoliticalPartiesFromDataBase();
		}
		assert (politicalParties != null);
		assert (politicalParties.size() > 0);

		return politicalParties;
	}

	public List<PoliticalParty> getAllPoliticalPartiesFromDataBase() {
		PoliticalPartyDao politicaPartyDao = new PoliticalPartyDao();
		List<PoliticalParty> politicalParties = politicaPartyDao
				.getAllPoliticalParties();
		
		assert (politicalParties != null);
		assert (politicalParties.size() > 0);
		return politicalParties;
	}
	
	private List<PoliticalParty> getAllPoliticalPartiesFromWebService()
			throws WebServiceNotAvailable {
		DeputyConnector deputyConnector = new DeputyConnector();
		List<PoliticalParty> politicalParties;
		try {
			politicalParties = deputyConnector.getAllPoliticalParties();
		} catch (RemoteException e) {
			throw new WebServiceNotAvailable(
					"The method threw a RemoteException");
		} catch (MalformedURLException e) {
			throw new WebServiceNotAvailable(
					"The method threw a MalformedURLException");
		} catch (ServiceException e) {
			throw new WebServiceNotAvailable(
					"The method threw a ServiceException");
		}
		return politicalParties;
	}
}
