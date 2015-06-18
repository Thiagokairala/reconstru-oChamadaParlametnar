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

public class PoliticalPartyControl {
	
	private DeputyDataParser deputyDataParser = new DeputyDataParser();
	private SessionDataParser sessionDataParser = new SessionDataParser();
	private PoliticalPartyParser politicalPartyParser = new PoliticalPartyParser();
	
	public Double generateStatisticParty(String partyName)
			throws DeputyNotFoundException {
		Statistic statistic = new Statistic();
		DeputyControl deputyControl = new DeputyControl();
		List<Deputy> deputiesOfThisParty = new ArrayList<Deputy>();
		deputiesOfThisParty = listAllDeputiesOfThisParty(partyName);
		double percentage;
		double sum = 0; /* Is to calculate the sum of the percentages to compare with the total. */
		double numberOfDeputies = 0;

		numberOfDeputies = deputiesOfThisParty.size();
		for(Deputy deputy : deputiesOfThisParty){
			percentage = deputy.getRanking().getPercentage();		
			sum = sum + percentage;
			System.out.println("Porcentagem :" + percentage);
		}
		
		double statisticOfTheParty;
		statisticOfTheParty = (sum/numberOfDeputies) * 100;
		
		return statisticOfTheParty;
	}
	
	public List<Deputy> listAllDeputiesOfThisParty(String partyName) throws DeputyNotFoundException {
		
		List<Deputy> deputies = deputyDataParser.getAllDeputies();
		List<Deputy> deputiesOfThisParty = new ArrayList<Deputy>();
		
		for (Deputy deputy : deputies) {
			if (deputy.getPoliticalParty().getName().equals(partyName)) {
				deputiesOfThisParty.add(deputy);
			}
		}
		
		assert (deputiesOfThisParty != null);
		assert (deputies != null);
		
		return deputiesOfThisParty;
	}
	
	private int getNumberOfSessionsAttended(Deputy deputy) {
		List<Session> SessionsOfOneDeputy = sessionDataParser
				.getAllSessions(deputy);
		return SessionsOfOneDeputy.size();
	}

	private int getNumberOfSessions() {
		List<Session> listOfSessions = sessionDataParser.getAllSessions();
		int numberOfSessions = listOfSessions.size();

		return numberOfSessions;
	}
	
	public List<String> getAllNameOfAllParties(String prefix) {
		List<PoliticalParty> allParties = politicalPartyParser.getAllPoliticalParties();

		List<String> allNames = new ArrayList<String>();
		for (PoliticalParty party : allParties) {
			if (party.getName().toLowerCase()
					.startsWith(prefix.toLowerCase())) {
				allNames.add(party.getName());
			} else {
				// nothing to do.
			}

			if (party.getAchronym().toLowerCase()
					.startsWith(prefix.toLowerCase())) {
				allNames.add(party.getAchronym());
			} else {
				// nothing to do.
			}
		}
		return allNames;
	}
	

}
