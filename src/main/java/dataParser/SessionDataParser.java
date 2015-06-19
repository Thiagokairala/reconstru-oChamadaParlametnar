package dataParser;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;
import model.Session;
import webServiceConnector.SessionConnector;
import dao.SessionDao;
import exception.WebServiceNotAvailable;

public class SessionDataParser {
	public List<Session> getAllSessions() {
		List<Session> listWithAllSessions = null;

		try {
			listWithAllSessions = this.getAllSessionsFromWS();
		} catch (WebServiceNotAvailable e) {
			System.out.println("fudeu");
		}

		assert (listWithAllSessions != null);
		assert (listWithAllSessions.size() != 0);

		return listWithAllSessions;
	}

	public List<Session> getAllSessions(Deputy deputy) {
		List<Session> listWithAllSessions;

		try {
			listWithAllSessions = this.getAllSessionsFromWS(deputy);
		} catch (WebServiceNotAvailable e) {
			listWithAllSessions = deputy.getSessionsAttended();
		}

		assert (listWithAllSessions != null);
		assert (listWithAllSessions.size() != 0);

		return listWithAllSessions;
	}

	/****************************************************************
	 * Private methods
	 ****************************************************************/
	private List<Session> getAllSessionsFromWS() throws WebServiceNotAvailable {
		SessionConnector sessionConnector = new SessionConnector();
		List<Session> listWithSession;
		try {
			listWithSession = sessionConnector.getAllSessions();
		} catch (RemoteException e) {
			throw new WebServiceNotAvailable("RemoteException");
		} catch (MalformedURLException e) {
			throw new WebServiceNotAvailable("MalformedURLException");
		} catch (ServiceException e) {
			throw new WebServiceNotAvailable("ServiceException");
		}

		return listWithSession;
	}

	private List<Session> getAllSessionsFromWS(Deputy deputy)
			throws WebServiceNotAvailable {
		SessionConnector sessionConnector = new SessionConnector();
		List<Session> listWithSession;
		try {
			listWithSession = sessionConnector.getAllSessions(deputy);
		} catch (RemoteException e) {
			throw new WebServiceNotAvailable("RemoteException");
		} catch (MalformedURLException e) {
			throw new WebServiceNotAvailable("MalformedURLException");
		} catch (ServiceException e) {
			throw new WebServiceNotAvailable("ServiceException");
		}

		return listWithSession;
	}

	private List<Session> getAllSessionsFromDB() {
		SessionDao sessionDao = new SessionDao();
		List<Session> listWithAllSessions = sessionDao.getAllSessions();
		return listWithAllSessions;
	}

}
