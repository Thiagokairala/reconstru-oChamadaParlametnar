package webServiceConnector;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.rpc.ServiceException;

import model.Deputy;
import model.Session;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Node;

import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarPresencasDiaResponseListarPresencasDiaResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarPresencasParlamentarResponseListarPresencasParlamentarResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesLocator;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesSoapStub;

public class SessionConnector {
	public SessionConnector() {

	}

	// public List<Deputy> getAllDeputies() throws RemoteException,
	// MalformedURLException, ServiceException {
	// MessageElement deputiesXML = this.getDeputyResponse();
	// List<Deputy> deputies = new ArrayList<Deputy>();
	//
	// @SuppressWarnings("unchecked")
	// Iterator<MessageElement> iterator = deputiesXML.getChildElements();
	//
	// while (iterator.hasNext()) {
	// MessageElement deputyXML = iterator.next();
	// Deputy deputy = parseDeputy(deputyXML);
	// deputies.add(deputy);
	// }
	// return deputies;
	// }

	public List<Session> getAllSessions() throws MalformedURLException,
			RemoteException, ServiceException {
		MessageElement sessionsXML = this.getAllSessionsResponse();
		List<Session> sessions = new ArrayList<Session>();

		Iterator<MessageElement> iterator = sessionsXML.getChildElements();

		while (iterator.hasNext()) {
			MessageElement sessionXML = iterator.next();
			Session session = this.parseSession(sessionXML);
			sessions.add(session);
		}
		return sessions;
	}

	private Session parseSession(MessageElement sessionXML) {
		Session session = new Session();

		return session;
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

	/**
	 * This method makes the first connection with the web service, getting a
	 * stub for the soap protocol.
	 * 
	 * @return {@link DeputadosSoapStub} containing the stub of the protocol.
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */

	public SessoesReunioesSoapStub getConnection()
			throws MalformedURLException, ServiceException {
		URL url;
		url = new URL(
				"http://www.camara.gov.br/SitCamaraWS/SessoesReunioes.asmx?wsdl");
		SessoesReunioesSoapStub service = (SessoesReunioesSoapStub) new SessoesReunioesLocator()
				.getSessoesReunioesSoap(url);

		return service;
	}

	public MessageElement getAllSessionsResponse()
			throws MalformedURLException, ServiceException, RemoteException {
		SessoesReunioesSoapStub service = this.getConnection();

		Calendar date = new GregorianCalendar(2015, 1, 1);
		Calendar today = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy");

		ListarPresencasParlamentarResponseListarPresencasParlamentarResult sessions = service
				.listarPresencasParlamentar(df.format(date.getTime()),
						df.format(today.getTime()), "440");
		MessageElement sessionsOnXML = sessions.get_any()[0];
		return sessionsOnXML;
	}

	public MessageElement getSessionResponse(Calendar date)
			throws RemoteException, MalformedURLException, ServiceException {
		SessoesReunioesSoapStub service = this.getConnection();

		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy");

		ListarPresencasDiaResponseListarPresencasDiaResult sessions = service
				.listarPresencasDia(df.format(date.getTime()), "", "", "");

		MessageElement messageElement = sessions.get_any()[0];

		return messageElement;
	}
}
