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

import model.Session;

import org.apache.axis.message.MessageElement;
import org.w3c.dom.Node;

import util.DateCounter;
import br.gov.camara.www.SitCamaraWS.Deputados.DeputadosSoapStub;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarDiscursosSessoesCongressoEncerradasResponseListarDiscursosSessoesCongressoEncerradasResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.ListarPresencasParlamentarResponseListarPresencasParlamentarResult;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesLocator;
import br.gov.camara.www.SitCamaraWS.SessoesReunioes.SessoesReunioesSoapStub;

public class SessionConnector {

	public List<Session> getAllSessions() throws MalformedURLException,
			RemoteException, ServiceException {
		MessageElement sessionsXML = this.getAllSessionsResponse();
		List<Session> sessions = new ArrayList<Session>();

		@SuppressWarnings("unchecked")
		Iterator<MessageElement> iterator = sessionsXML.getChildElements();

		while (iterator.hasNext()) {
			MessageElement sessionXML = iterator.next();
			Session session = this.parseSession(sessionXML);
			sessions.add(session);
		}

		return sessions;
	}

	/************************************************************
	 * Methods to get the xml from web service.
	 ************************************************************/

	private MessageElement getAllSessionsResponse() throws RemoteException,
			MalformedURLException, ServiceException {

		GregorianCalendar today = new GregorianCalendar();
		int yearToBegin = DateCounter
				.findElectionYear(today.get(Calendar.YEAR));

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

	/*****************************************************************
	 * Methods of parse
	 *****************************************************************/
	private Session parseSession(MessageElement sessionXML) {
		Session session = new Session();

		session.setDate(this.getTextFromXML(sessionXML, "data"));
		session.setLegislature(this.getTextFromXML(sessionXML, "legislatura"));

		return session;
	}

	private String getTextFromXML(MessageElement sessionXML, String nameOfTag) {
		Node node = sessionXML.getElementsByTagName(nameOfTag).item(0);
		String valueAsText = node.getFirstChild().getNodeValue();
		return valueAsText;
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
