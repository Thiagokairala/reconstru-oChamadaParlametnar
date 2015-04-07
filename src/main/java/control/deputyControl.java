package control;

import dataParser.SessionDataParser;
import model.Deputy;
import model.Statistic;

public class deputyControl {
	public Statistic generateStatistic(Deputy deputy) {
		Statistic statistic = new Statistic();
		statistic.setDeputy(deputy);
		SessionDataParser sessionDataParser = new SessionDataParser();

		return statistic;
	}
}
