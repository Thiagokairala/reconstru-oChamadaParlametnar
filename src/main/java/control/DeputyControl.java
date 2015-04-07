package control;

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
