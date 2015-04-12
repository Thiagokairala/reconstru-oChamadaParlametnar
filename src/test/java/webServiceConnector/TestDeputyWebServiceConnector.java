package webServiceConnector;

import static org.junit.Assert.assertTrue;

import java.util.List;

import model.Deputy;
import model.PoliticalParty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDeputyWebServiceConnector {

	private DeputyConnector deputyConnector;

	@Before
	public void testSetUp() {
		deputyConnector = new DeputyConnector();
	}

	@Test
	public void testGetAllDeputies() throws Exception {
		List<Deputy> deputy = deputyConnector.getAllDeputies();
		assertTrue(deputy.size() != 0);
	}

	@Test
	public void testGetAllPoliticalParties() throws Exception {
		List<PoliticalParty> list = deputyConnector.getAllPoliticalParties();
		assertTrue(list.size() != 0);
	}

	@After
	public void tearDown() {
		deputyConnector = null;
	}
}
