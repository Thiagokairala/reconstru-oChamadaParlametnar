package webServiceConnector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;

import org.apache.axis.message.MessageElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import dao.DeputyDao;

public class TestWebServiceConnector {

	private DeputyConnector deputyConnector;

	@Before
	public void testSetUp() {
		deputyConnector = new DeputyConnector();
	}

	// @Test
	public void testGetConnection() throws Exception {
		DeputadosSoapStub deputySoapStub = deputyConnector.getConnection();
		assertNotNull(deputySoapStub._getService());
	}

	// @Test
	public void testGetDeputyResponse() throws Exception {
		MessageElement response = deputyConnector.getDeputyResponse();

		assertNotNull(response);
	}

	// @Test
	public void testGetAllDeputies() throws Exception {
		List<Deputy> deputy = deputyConnector.getAllDeputies();
		assertTrue(deputy.size() != 0);
	}

	@After
	public void tearDown() {
		deputyConnector = null;
	}
}
