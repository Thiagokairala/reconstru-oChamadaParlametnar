package dao;

import java.util.ArrayList;
import java.util.List;

import model.Deputy;

import org.hibernate.metamodel.source.annotations.xml.mocker.MockHelper;
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
}
