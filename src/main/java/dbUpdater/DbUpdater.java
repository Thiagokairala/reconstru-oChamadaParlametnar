package dbUpdater;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;
import model.PoliticalParty;
import model.Session;
import webServiceConnector.DeputyConnector;
import webServiceConnector.SessionConnector;
import dao.DeputyDao;
import dao.PoliticalPartyDao;
import dao.SessionDao;

public class DbUpdater {
	public void updateTables() throws RemoteException, MalformedURLException,
			ServiceException {

		updateAllPoliticalParties();
		List<PoliticalParty> politicalParties = this.getAllPoliticalParties();
		updateAllDeputies(politicalParties);
		updateAllSessions();
		updateDeputiesSessions();
	}

	private List<PoliticalParty> getAllPoliticalParties() {
		PoliticalPartyDao politicalPartyDao = new PoliticalPartyDao();
		List<PoliticalParty> politicalParties = politicalPartyDao.findAll();
		return politicalParties;
	}

	private List<PoliticalParty> updateAllPoliticalParties()
			throws MalformedURLException, RemoteException, ServiceException {
		DeputyConnector deputyConnector = new DeputyConnector();
		PoliticalPartyDao politicalPartyDao = new PoliticalPartyDao();

		List<PoliticalParty> politicalParties = deputyConnector
				.getAllPoliticalParties();
		politicalPartyDao.saveListOfPoliticalParties(politicalParties);

		return politicalParties;

	}

	private void updateDeputiesSessions() throws RemoteException,
			MalformedURLException, ServiceException {
		DeputyDao deputyDao = new DeputyDao();
		SessionConnector sessionConnector = new SessionConnector();
		List<Deputy> deputies = deputyDao.getAllDeputies();

		int i = 0;
		int size = deputies.size();
		for (Deputy deputy : deputies) {
			List<Session> sessionsAttended = sessionConnector
					.getAllSessions(deputy);
			deputy.setSessionsAttended(sessionsAttended);
			System.out.println(((double) i / (double) size) * 100
					+ "% Parlamentares atualizados.");
			i++;
		}
		deputyDao.updateListOfDeputies(deputies);
	}

	private void updateAllSessions() throws RemoteException,
			MalformedURLException, ServiceException {
		SessionConnector sessionConnector = new SessionConnector();
		SessionDao sessionDao = new SessionDao();

		List<Session> sessions = sessionConnector.getAllSessions();

		sessionDao.saveListOfSessions(sessions);

	}

	private void updateAllDeputies(List<PoliticalParty> politicalParties)
			throws RemoteException, MalformedURLException, ServiceException {
		DeputyConnector deputyConnector = new DeputyConnector();
		DeputyDao deputyDao = new DeputyDao();
		List<Deputy> deputies = deputyConnector.getAllDeputies();

		deputyDao.saveListOfDeputies(deputies, politicalParties);
	}

}
