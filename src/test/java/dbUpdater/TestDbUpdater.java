package dbUpdater;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

public class TestDbUpdater {

	@Test
	public void testDbUpdater() throws RemoteException, MalformedURLException,
			ServiceException {
		DbUpdater dbUpdater = new DbUpdater();
		dbUpdater.updateTables();	
	}

}
