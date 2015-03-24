package webServiceConnector;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.message.MessageElement;

import model.Deputy;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosLocator;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.Deputados.ObterDeputadosResponseObterDeputadosResult;

public class DeputyConnector {
	public DeputyConnector() {

	}

	/**
	 * This method makes the first connection with the web service, getting a
	 * stub for the soap protocol.
	 * 
	 * @return {@link DeputadosSoapStub} containing the stub of the protocol.
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */
	public DeputadosSoapStub getConnection() throws MalformedURLException,
			ServiceException {
		URL url;
		url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx");
		DeputadosSoapStub service = (DeputadosSoapStub) new DeputadosLocator()
				.getDeputadosSoap(url);

		return service;
	}

	public ObterDeputadosResponseObterDeputadosResult getDeputyResponse()
			throws RemoteException, MalformedURLException, ServiceException {
		DeputadosSoapStub service = this.getConnection();
		ObterDeputadosResponseObterDeputadosResult deputados = service
				.obterDeputados();

		return deputados;
	}

	public MessageElement getAllDeputies() throws RemoteException,
			MalformedURLException, ServiceException {
		ObterDeputadosResponseObterDeputadosResult service = this
				.getDeputyResponse();

		return service.get_any()[0];
	}

}