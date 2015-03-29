package util;

public class DateCounter {

	public static int findElectionYear(int currentYear) {
		while (currentYear % 4 != 3) {
			currentYear--;
		}

		return currentYear;
	}
}
