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
	
		public Session SearchForSession(Session dateSession ) 
				throws PoliticalPartyNotFoundException {
			List<Session> listWithSessions = sessionDataParser
					.getAllSessions();	
			List <Session> FindSession = listWithSessions;
			
			for(Session findSession : listWithSessions){
				listWithSessions.add(SearchForSession(findSession));
				
				if(dateSession == findSession) {
					return dateSession;
				}
				else{
					//...
					}
				}
						
				return dateSession ;
		}

}
