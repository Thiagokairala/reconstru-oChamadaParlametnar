package webServiceConnector;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

public class TestSessionsWebServiceConnector {

	@Test
	public void test() throws RemoteException, MalformedURLException,
			ServiceException {
		SessionConnector sessionConnector = new SessionConnector();
		System.out.println(sessionConnector.getAllSessionsResponse());
	}

}
