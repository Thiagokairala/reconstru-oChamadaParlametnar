package webServiceConnector;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Session;

import org.junit.Test;

public class TestSessionsWebServiceConnector {

	@Test
	public void test() throws RemoteException, MalformedURLException,
			ServiceException {
		SessionConnector sessionConnector = new SessionConnector();
		List<Session> sessions = sessionConnector.getAllSessions();
		assertTrue(sessions.size() > 0);
	}

}
