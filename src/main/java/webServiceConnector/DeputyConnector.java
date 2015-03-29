package webServiceConnector;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosLocator;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.Deputados.ObterDeputadosResponseObterDeputadosResult;

public class DeputyConnector {
	public DeputyConnector() {

	}

	public List<Deputy> getAllDeputies() throws RemoteException,
			MalformedURLException, ServiceException {
		MessageElement deputiesXML = this.getDeputyResponse();
		List<Deputy> deputies = new ArrayList<Deputy>();

		@SuppressWarnings("unchecked")
		Iterator<MessageElement> iterator = deputiesXML.getChildElements();

		while (iterator.hasNext()) {
			MessageElement deputyXML = iterator.next();
			Deputy deputy = parseDeputy(deputyXML);
			deputies.add(deputy);
		}
		return deputies;
	}

	private Deputy parseDeputy(MessageElement deputyXML) {
		Deputy deputy = new Deputy();

		deputy.setCivilName(this.getTextFromXML(deputyXML, "nome"));
		deputy.setTreatmentName(this.getTextFromXML(deputyXML,
				"nomeParlamentar"));
		deputy.setIdParliamentary(this.getTextFromXML(deputyXML, "ideCadastro"));
		deputy.setGender(this.getTextFromXML(deputyXML, "sexo"));
		deputy.setUf(this.getTextFromXML(deputyXML, "uf"));
		deputy.setPoliticalParty(this.getTextFromXML(deputyXML, "partido"));
		deputy.setOfficeNumber(Integer.parseInt(this.getTextFromXML(deputyXML,
				"gabinete")));
		deputy.setOfficeBuilding(Integer.parseInt(this.getTextFromXML(
				deputyXML, "anexo")));
		deputy.setPhone(this.getTextFromXML(deputyXML, "fone"));
		deputy.setEmail(this.getTextFromXML(deputyXML, "email"));

		return deputy;
	}

	private String getTextFromXML(MessageElement deputyXML, String nameOfTag) {
		Node node = deputyXML.getElementsByTagName(nameOfTag).item(0);
		String valueAsText = node.getFirstChild().getNodeValue();
		return valueAsText;
	}

	private MessageElement getDeputyResponse() throws RemoteException,
			MalformedURLException, ServiceException {
		DeputadosSoapStub service = this.getConnection();
		ObterDeputadosResponseObterDeputadosResult deputies = service
				.obterDeputados();
		MessageElement messageElement = deputies.get_any()[0];

		return messageElement;
	}

	/************************************************************
	 * 
	 */
	
	/**
	 * This method makes the first connection with the web service, getting a
	 * stub for the soap protocol.
	 * 
	 * @return {@link DeputadosSoapStub} containing the stub of the protocol.
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */
	private DeputadosSoapStub getConnection() throws MalformedURLException,
			ServiceException {
		URL url;
		url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx");
		DeputadosSoapStub service = (DeputadosSoapStub) new DeputadosLocator()
				.getDeputadosSoap(url);

		return service;
	}

}