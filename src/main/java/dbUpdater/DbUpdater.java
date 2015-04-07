package dbUpdater;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;
import model.Session;
import webServiceConnector.DeputyConnector;
import webServiceConnector.SessionConnector;
import dao.DeputyDao;
import dao.SessionDao;

public class DbUpdater {
	public void updateTables() throws RemoteException, MalformedURLException,
			ServiceException {
		updateAllDeputies();
		updateAllSessions();
		updateDeputiesSessions();
	}

	private void updateDeputiesSessions() throws RemoteException,
			MalformedURLException, ServiceException {
		DeputyConnector deputyConnector = new DeputyConnector();
		DeputyDao deputyDao = new DeputyDao();
		SessionConnector sessionConnector = new SessionConnector();
		List<Deputy> deputies = deputyConnector.getAllDeputies();

		int i = 0;
		int size = deputies.size();
		for (Deputy deputy : deputies) {
			List<Session> sessionsAttended = sessionConnector
					.getAllSessions(deputy);
			deputy.setSessionsAttended(sessionsAttended);
			deputyDao.update(deputy);
			System.out.println(((double) i / (double) size) * 100
					+ "% Parlamentares atualizados.");
			i++;
		}

	}

	private void updateAllSessions() throws RemoteException,
			MalformedURLException, ServiceException {
		SessionConnector sessionConnector = new SessionConnector();
		SessionDao sessionDao = new SessionDao();

		List<Session> sessions = sessionConnector.getAllSessions();

		sessionDao.saveListOfSessions(sessions);

	}

	private void updateAllDeputies() throws RemoteException,
			MalformedURLException, ServiceException {
		DeputyConnector deputyConnector = new DeputyConnector();
		DeputyDao deputyDao = new DeputyDao();
		List<Deputy> deputies = deputyConnector.getAllDeputies();

		deputyDao.saveListOfDeputies(deputies);
	}

}
