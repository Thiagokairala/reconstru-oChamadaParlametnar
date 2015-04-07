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

	public Deputy getOneDeputy(int idParliamentary) {
		Deputy deputy;

		try {
			deputy = this.getOneDeputyFromWebService(idParliamentary);
		} catch (WebServiceNotAvailable e) {
			deputy = this.getOneDeputyFromDataBase(idParliamentary);
		}

		assert (deputy != null);
		return deputy;
	}

	public List<Deputy> getAllDeputies() {
		List<Deputy> listWithAllDeputies;

		try {
			listWithAllDeputies = this.getAllDeputiesFromWebService();
		} catch (WebServiceNotAvailable e) {
			listWithAllDeputies = this.getAllDeputiesFromDataBase();
		}

		assert (listWithAllDeputies != null);
		assert (listWithAllDeputies.size() != 0);
		return listWithAllDeputies;
	}

	/***********************************************************
	 * Private methods of the class
	 ***********************************************************/

	private Deputy getOneDeputyFromWebService(int idParliamentary)
			throws WebServiceNotAvailable {
		DeputyConnector deputyConnector = new DeputyConnector();
		Deputy deputy;
		try {
			deputy = deputyConnector.getOneDeputy(idParliamentary);
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
		return deputy;
	}

	private Deputy getOneDeputyFromDataBase(long idParliamentary) {
		DeputyDao deputyDao = new DeputyDao();
		Deputy deputy = deputyDao.getById(idParliamentary);
		return deputy;
	}

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
