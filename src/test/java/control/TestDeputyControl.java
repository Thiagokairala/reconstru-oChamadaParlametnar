package control;

import model.Statistic;

import org.junit.Test;

import exception.DeputyNotFoundException;

public class TestDeputyControl {

	// @Test(expected = DeputyNotFoundException.class)
	public void testGenerateStatisticDeputyNotFound()
			throws DeputyNotFoundException {
		String deputyName = "teste";
		this.getStatistic(deputyName);
	}

	//@Test
	public void testGenerateStatisticCivilName() throws DeputyNotFoundException {
		String deputyName = "SÍLVIO SERAFIM COSTA";
		Statistic statistic = this.getStatistic(deputyName);
		System.out.println(statistic.getSessionsAttended());
	}

	private Statistic getStatistic(String deputyName)
			throws DeputyNotFoundException {
		DeputyControl deputyControl = new DeputyControl();
		return deputyControl.generateStatistic(deputyName);
	}

}
