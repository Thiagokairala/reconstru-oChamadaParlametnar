package dao;

import static org.junit.Assert.assertTrue;
import model.Deputy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestDeputyDao {
	DeputyDao deputyDao;

	@Before
	public void setUp() {
		deputyDao = Mockito.mock(DeputyDao.class);
	}

	@Test
	public void testSaveDeputy() throws Exception {
		Deputy deputy = new Deputy();
		deputyDao.saveDeputy(deputy);
		Mockito.verify(deputyDao).saveDeputy(deputy);
	}

	@Test
	public void testGetAllDeputiesMethodCall() {
		deputyDao.getAllDeputies();
		Mockito.verify(deputyDao).getAllDeputies();
	}

	@Test
	public void testGetAllDeputiesTestCloseConnection() {
		DeputyDao deputyDao = new DeputyDao();

		deputyDao.getAllDeputies();
		assertTrue(GenericDao.getEntityManager().isOpen() == false);
	}
}
