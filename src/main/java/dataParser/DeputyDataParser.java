package dataParser;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;
import model.PoliticalParty;
import webServiceConnector.DeputyConnector;
import dao.DeputyDao;
import dao.PoliticalPartyDao;
import exception.DeputyNotFoundException;
import exception.WebServiceNotAvailable;

public class DeputyDataParser {

	public Deputy getOneDeputy(int idParliamentary) {
		Deputy deputy;

		deputy = this.getOneDeputyFromDataBase(idParliamentary);

		assert (deputy != null);
		return deputy;
	}

	public List<PoliticalParty> getAllPoliticalParties() {
		List<PoliticalParty> politicalParties;
		politicalParties = this.getAllPoliticalPartiesFromDataBase();

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

	public List<Deputy> getAllDeputies() {
		List<Deputy> listWithAllDeputies;

		listWithAllDeputies = this.getAllDeputiesFromDataBase();

		assert (listWithAllDeputies != null);
		assert (listWithAllDeputies.size() != 0);
		return listWithAllDeputies;
	}

	public Deputy getOneDeputy(String deputyName)
			throws DeputyNotFoundException {
		List<Deputy> deputies = this.getAllDeputies();
		Deputy deputyComplete = null;

		for (Deputy deputy : deputies) {
			boolean exists = deputy.getCivilName().equalsIgnoreCase(deputyName)
					|| deputy.getTreatmentName().equalsIgnoreCase(deputyName);
			if (exists) {
				deputyComplete = deputy;
			}
		}

		if (deputyComplete == null) {
			throw new DeputyNotFoundException("Invalid username");
		} else {
			return deputyComplete;
		}
	}

	public List<Deputy> getAllDeputiesFromDB() {
		List<Deputy> deputies = this.getAllDeputiesFromDataBase();

		assert (deputies.size() != 0);
		return deputies;
	}

	/***********************************************************
	 * Private methods of the class
	 ***********************************************************/

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

	private Deputy getOneDeputyFromWebService(int idParliamentary)
			throws WebServiceNotAvailable {
		DeputyConnector deputyConnector = new DeputyConnector();
		Deputy deputy;
		try {
			deputy = deputyConnector.getOneDeputy(idParliamentary);
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
		return deputy;
	}

	private Deputy getOneDeputyFromDataBase(long idParliamentary) {
		DeputyDao deputyDao = new DeputyDao();
		Deputy deputy = deputyDao.getById(idParliamentary);
		return deputy;
	}

	private List<Deputy> getAllDeputiesFromDataBase() {
		List<Deputy> listWithAllDeputies;

		DeputyDao deputyDao = new DeputyDao();
		listWithAllDeputies = deputyDao.findAll();
		return listWithAllDeputies;
	}

	private List<Deputy> getAllDeputiesFromWebService()
			throws WebServiceNotAvailable {
		List<Deputy> listWithAllDeputies;

		try {
			DeputyConnector deputyConnector = new DeputyConnector();
			listWithAllDeputies = deputyConnector.getAllDeputies();
			return listWithAllDeputies;
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
	}

}
