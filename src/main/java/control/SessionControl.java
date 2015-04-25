package control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import model.Deputy;
import model.PoliticalParty;
import model.Session;
import model.Statistic;
import dataParser.DeputyDataParser;
import dataParser.PoliticalPartyParser;
import dataParser.SessionDataParser;
import exception.DeputyNotFoundException;
import exception.PoliticalPartyNotFoundException;

public class SessionControl {
	
		private SessionDataParser sessionDataParser = new  SessionDataParser();
		

		private Session SearchForSession(Session session ) throws PoliticalPartyNotFoundException {
			List<Session> listWithSessions = sessionDataParser
					.getAllSessions();	
				return session;
		
	}

}
