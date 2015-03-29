package dataParser;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import dao.DeputyDao;
import model.Deputy;
import webServiceConnector.DeputyConnector;
import exception.WebServiceNotAvailable;

public class DeputyDataParser {
	
	public Deputy getOneDeputy(int ) {
		Deputy deputy;
		
		DeputyConnector deputyConnector = new DeputyConnector();
		deputyConnector.getOneDeputy
		return deputy;
	}

	public List<Deputy> getAllDeputies() {
		List<Deputy> listWithAllDeputies;

		try {
			listWithAllDeputies = this.getAllDeputiesFromWebService();
		} catch (WebServiceNotAvailable e) {
			listWithAllDeputies = this.getAllDeputiesFromDataBase();
		}

		return listWithAllDeputies;
	}

	/***********************************************************
	 * Private methods of the class
	 ***********************************************************/

	private List<Deputy> getAllDeputiesFromDataBase() {
		List<Deputy> listWithAllDeputies;

		DeputyDao deputyDao = new DeputyDao();
		listWithAllDeputies = deputyDao.findAll();
		return listWithAllDeputies;
	}

	private List<Deputy> getAllDeputiesFromWebService()
			throws WebServiceNotAvailable {
		List<Deputy> listWithAllDeputies;

		try {
			DeputyConnector deputyConnector = new DeputyConnector();
			listWithAllDeputies = deputyConnector.getAllDeputies();
			return listWithAllDeputies;
		} catch (RemoteException e) {
			throw new WebServiceNotAvailable(
					"The method threw a RemoteException");
		} catch (MalformedURLException e) {
			throw new WebServiceNotAvailable(
					"The method threw a MalformedURLException");
		} catch (ServiceException e) {
			throw new WebServiceNotAvailable(
					"The method threw a ServiceException");
		}
	}
}
