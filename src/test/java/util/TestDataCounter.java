package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDataCounter {

	@Test
	public void testContructor() {
		DateCounter dateCounter = new DateCounter();
		assertNotNull(dateCounter);
	}

	@Test
	public void testFindElectionYearSameYear() {
		int yearToTest = DateCounter.findElectionYear(2015);
		assertTrue(yearToTest == 2015);
	}

	@Test
	public void testFindElectionYearYearHasToChange() {
		int yearToTest = DateCounter.findElectionYear(2014);
		assertTrue(yearToTest == 2011);
	}
}
