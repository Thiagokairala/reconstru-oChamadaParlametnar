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
import org.hibernate.exception.DataException;
import org.w3c.dom.Node;

import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarDiscursosPlenarioResponseListarDiscursosPlenarioResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarDiscursosSessoesCongressoEncerradasResponseListarDiscursosSessoesCongressoEncerradasResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarPresencasDiaResponseListarPresencasDiaResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarPresencasParlamentarResponseListarPresencasParlamentarResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesLocator;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesSoapStub;

public class SessionConnector {

	public List<Session> getAllSessions() throws MalformedURLException,
			RemoteException, ServiceException {
		MessageElement sessionsXML = this.getAllSessionsResponse();
		List<Session> sessions = new ArrayList<Session>();

		System.out.println(sessionsXML);
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
		System.out.println(sessionXML);

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

	private int findElectionYear(int currentYear) {
		while (currentYear % 4 != 3) {
			currentYear--;
		}

		return currentYear;
	}

	public MessageElement getAllSessionsResponse() throws RemoteException,
			MalformedURLException, ServiceException {

		GregorianCalendar today = new GregorianCalendar();
		int yearToBegin = this.findElectionYear(today.get(Calendar.YEAR));

		GregorianCalendar dateToBegin = new GregorianCalendar(yearToBegin, 1, 1);

		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy");

		String dateBeginingString = df.format(dateToBegin.getTime());
		String dateEndString = df.format(today.getTime());

		SessoesReunioesSoapStub service = this.getConnection();

		ListarDiscursosSessoesCongressoEncerradasResponseListarDiscursosSessoesCongressoEncerradasResult sessions = service
				.listarDiscursosSessoesCongressoEncerradas(dateBeginingString,
						dateEndString);

		MessageElement messageElement = sessions.get_any()[0];

		return messageElement;
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
