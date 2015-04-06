package webServiceConnector;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Session;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import util.DateCounter;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;

import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarPresencasParlamentarResponseListarPresencasParlamentarResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesLocator;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesSoapStub;

public class SessionConnector {
	private final String DEPUTY_REGISTRY = "440";
	private final int POSITION_OF_SESSIONS = 5;

	public List<Session> getAllSessions() throws MalformedURLException,
			RemoteException, ServiceException {
		MessageElement sessionsXML = this.getAllSessionsResponse();
		List<Session> sessions = new ArrayList<Session>();
		this.parseSessions(
				sessionsXML.getChildNodes().item(POSITION_OF_SESSIONS),
				sessions);

		return sessions;
	}

	/************************************************************
	 * Methods to get the xml from web service.
	 ************************************************************/

	private MessageElement getAllSessionsResponse() throws RemoteException,
			MalformedURLException, ServiceException {

		DateCounter dateCounter = new DateCounter();

		String dateBeginingString = dateCounter.getBeginingDate();
		String dateEndString = dateCounter.getToday();

		SessoesReunioesSoapStub service = this.getConnection();

		ListarPresencasParlamentarResponseListarPresencasParlamentarResult sessions = service
				.listarPresencasParlamentar(dateBeginingString, dateEndString,
						DEPUTY_REGISTRY);

		MessageElement messageElement = sessions.get_any()[0];

		return messageElement;
	}

	/*****************************************************************
	 * Methods of parse
	 *****************************************************************/
	private List<Session> parseSessions(Node item, List<Session> sessions) {

		NodeList nodeList = item.getChildNodes();

		int size = nodeList.getLength();
		for (int i = 0; i < size; i++) {
			try {
				if (nodeList.item(i).getNodeName().equalsIgnoreCase("sessao")) {
					Session session = this.parseSession(nodeList.item(i));
					sessions.add(session);
				} else {
					parseSessions(nodeList.item(i), sessions);
				}
			} catch (NullPointerException e) {
				// nothing to do.
			}
		}

		return sessions;
	}

	private Session parseSession(Node item) {
		Session session = new Session();
		MessageElement messageElement = (MessageElement) item;
		String descriptionPlusDate = messageElement
				.getElementsByTagName("descricao").item(0).getFirstChild()
				.getNodeValue();

		String[] splitDescription = descriptionPlusDate.split("-");
		session.setDate(splitDescription[1].substring(1));
		session.setDescription(splitDescription[0]);

		return session;
	}

	/*****************************************************************
	 * Methods of connection
	 *****************************************************************/

	/**
	 * This method makes the first connection with the web service, getting a
	 * stub for the soap protocol.
	 * 
	 * @return {@link DeputadosSoapStub} containing the stub of the protocol.
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */

	private SessoesReunioesSoapStub getConnection()
			throws MalformedURLException, ServiceException {
		URL url;
		url = new URL(
				"http://www.camara.gov.br/SitCamaraWS/SessoesReunioes.asmx?wsdl");
		SessoesReunioesSoapStub service = (SessoesReunioesSoapStub) new SessoesReunioesLocator()
				.getSessoesReunioesSoap(url);

		return service;
	}
}
