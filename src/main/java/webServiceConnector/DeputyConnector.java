package webServiceConnector;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;
import model.PoliticalParty;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Node;

import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosLocator;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.Deputados.ObterDeputadosResponseObterDeputadosResult;
import br.gov.camara.www.SitCamaraWS.Deputados.ObterPartidosCDResponseObterPartidosCDResult;
import exception.PoliticalPartyExtinct;

public class DeputyConnector {
	public DeputyConnector() {

	}

	public List<Deputy> getAllDeputies() throws RemoteException,
			MalformedURLException, ServiceException {
		MessageElement deputiesXML = this.getDeputyResponse();
		List<Deputy> deputies = new ArrayList<Deputy>();

		@SuppressWarnings("unchecked")
		Iterator<MessageElement> iterator = deputiesXML.getChildElements();

		List<PoliticalParty> politicalParties = this.getAllPoliticalParties();

		while (iterator.hasNext()) {
			MessageElement deputyXML = iterator.next();
			Deputy deputy = parseDeputy(deputyXML);
			deputy.setPoliticalParty(this.findPoliticalPartyOnList(deputyXML,
					politicalParties));
			deputies.add(deputy);
		}
		return deputies;
	}

	private PoliticalParty findPoliticalPartyOnList(MessageElement deputyXML,
			List<PoliticalParty> politicalParties) {
		String politicalPartyAchronym = this.getTextFromXML(deputyXML,
				"partido");
		PoliticalParty selectedPoliticalParty = null;

		Iterator<PoliticalParty> iterator = politicalParties.iterator();
		while (iterator.hasNext()) {
			PoliticalParty politicalParty = iterator.next();
			if (politicalParty.getAchronym().equalsIgnoreCase(
					politicalPartyAchronym)) {
				selectedPoliticalParty = politicalParty;
			}
		}

		return selectedPoliticalParty;
	}

	public Deputy getOneDeputy(int idParliamentary) throws RemoteException,
			MalformedURLException, ServiceException {
		Deputy deputy = this.findTheCorrectDeputy(idParliamentary);
		return deputy;
	}

	private Deputy findTheCorrectDeputy(int idParliamentary)
			throws RemoteException, MalformedURLException, ServiceException {
		List<Deputy> listOfAllDeputies = this.getAllDeputies();
		Iterator<Deputy> iterator = listOfAllDeputies.iterator();
		Deputy deputy;

		do {
			deputy = iterator.next();
		} while (deputy.getId() != idParliamentary);

		return deputy;
	}

	public List<PoliticalParty> getAllPoliticalParties()
			throws MalformedURLException, RemoteException, ServiceException {
		MessageElement messageElement = this.getPoliticalPartyResponse();
		List<PoliticalParty> listOfParties = this
				.parsePoliticalParties(messageElement);
		return listOfParties;
	}

	private List<PoliticalParty> parsePoliticalParties(
			MessageElement messageElement) {
		@SuppressWarnings("unchecked")
		Iterator<MessageElement> iterator = messageElement.getChildElements();
		List<PoliticalParty> listOfParties = new ArrayList<PoliticalParty>();
		while (iterator.hasNext()) {
			MessageElement politicalPartyXML = iterator.next();
			try {
				PoliticalParty politicalParty = this
						.parsePoliticalParty(politicalPartyXML);
				listOfParties.add(politicalParty);
			} catch (PoliticalPartyExtinct e) {
				// Nothing to do.
			}
		}
		return listOfParties;
	}

	private PoliticalParty parsePoliticalParty(MessageElement politicalPartyXML)
			throws PoliticalPartyExtinct {
		try {
			String extinctionDate = this.getTextFromXML(politicalPartyXML,
					"dataExtincao");
			throw new PoliticalPartyExtinct("Political party is extinct since "
					+ extinctionDate);
		} catch (NullPointerException e) {
			PoliticalParty politicalParty = new PoliticalParty();
			politicalParty.setAchronym(this.getTextFromXML(politicalPartyXML,
					"siglaPartido"));
			politicalParty.setName(this.getTextFromXML(politicalPartyXML,
					"nomePartido"));
			return politicalParty;
		}
	}

	private Deputy parseDeputy(MessageElement deputyXML) {
		Deputy deputy = new Deputy();

		deputy.setCivilName(this.getTextFromXML(deputyXML, "nome"));
		deputy.setTreatmentName(this.getTextFromXML(deputyXML,
				"nomeParlamentar"));
		deputy.setId(Integer.parseInt(this.getTextFromXML(deputyXML,
				"ideCadastro")));
		deputy.setGender(this.getTextFromXML(deputyXML, "sexo"));
		deputy.setUf(this.getTextFromXML(deputyXML, "uf"));
		deputy.setOfficeNumber(Integer.parseInt(this.getTextFromXML(deputyXML,
				"gabinete")));
		deputy.setOfficeBuilding(Integer.parseInt(this.getTextFromXML(
				deputyXML, "anexo")));
		deputy.setPhone(this.getTextFromXML(deputyXML, "fone"));
		deputy.setEmail(this.getTextFromXML(deputyXML, "email"));
		deputy.setRegistry(this.getTextFromXML(deputyXML, "matricula"));

		return deputy;
	}

	private String getTextFromXML(MessageElement deputyXML, String nameOfTag) {
		Node node = deputyXML.getElementsByTagName(nameOfTag).item(0);
		String valueAsText = node.getFirstChild().getNodeValue();
		return valueAsText;
	}

	/********************************************************
	 * Methods of response
	 ********************************************************/

	private MessageElement getDeputyResponse() throws RemoteException,
			MalformedURLException, ServiceException {
		DeputadosSoapStub service = this.getConnection();
		ObterDeputadosResponseObterDeputadosResult deputies = service
				.obterDeputados();
		MessageElement messageElement = deputies.get_any()[0];

		return messageElement;
	}

	private MessageElement getPoliticalPartyResponse()
			throws MalformedURLException, ServiceException, RemoteException {
		DeputadosSoapStub service = this.getConnection();
		ObterPartidosCDResponseObterPartidosCDResult politicalParties = service
				.obterPartidosCD();
		MessageElement messageElement = politicalParties.get_any()[0];
		return messageElement;
	}

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