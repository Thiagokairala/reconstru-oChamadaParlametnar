package control;

import java.util.ArrayList;
import java.util.List;

import model.Deputy;
import model.Session;
import model.Statistic;
import dataParser.DeputyDataParser;
import dataParser.SessionDataParser;
import exception.DeputyNotFoundException;

public class DeputyControl {
	private DeputyDataParser deputyDataParser = new DeputyDataParser();
	private SessionDataParser sessionDataParser = new SessionDataParser();

	public Statistic generateStatistic(String deputyName)
			throws DeputyNotFoundException {
		Statistic statistic = new Statistic();
		Deputy deputy = this.prepareDeputy(deputyName);
		statistic.setDeputy(deputy);
		int numberOfSessions = this.getNumberOfSessions();
		statistic.setTotalOfSessions(numberOfSessions);
		int numberOfSessionsAttended = this.getNumberOfSessionsAttended(deputy);
		statistic.setSessionsAttended(numberOfSessionsAttended);

		return statistic;
	}

	public List<String> getAllNameOfAllDeputies() {
		List<Deputy> allDeputies = deputyDataParser.getAllDeputiesFromDB();
		List<String> allNames = new ArrayList<String>();
		for (Deputy deputy : allDeputies) {
			String civilName = deputy.getCivilName();
			String treatmentName = deputy.getTreatmentName();

			allNames.add(civilName);
			allNames.add(treatmentName);
		}
		return allNames;
	}

	public List<String> getAllNameOfAllDeputies(String prefix) {
		List<Deputy> allDeputies = deputyDataParser.getAllDeputiesFromDB();

		List<String> allNames = new ArrayList<String>();
		for (Deputy deputy : allDeputies) {
			if (deputy.getCivilName().toLowerCase()
					.startsWith(prefix.toLowerCase())) {
				allNames.add(deputy.getCivilName());
			} else {
				// nothing to do.
			}

			if (deputy.getTreatmentName().toLowerCase()
					.startsWith(prefix.toLowerCase())) {
				allNames.add(deputy.getTreatmentName());
			} else {
				// nothing to do.
			}
		}
		return allNames;
	}

	public List<Deputy> getAllDeputies() {
		List<Deputy> allDeputies = deputyDataParser.getAllDeputies();
		return allDeputies;
	}

	private Deputy prepareDeputy(String deputyName)
			throws DeputyNotFoundException {
		Deputy deputy = deputyDataParser.getOneDeputy(deputyName);

		assert (deputy != null);
		assert (deputy.getCivilName().equalsIgnoreCase(deputyName) || deputy
				.getTreatmentName().equalsIgnoreCase(deputyName));
		return deputy;
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

}