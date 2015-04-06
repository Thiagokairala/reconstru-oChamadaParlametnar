package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCounter {
	private GregorianCalendar today;
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public DateCounter() {
		this.today = new GregorianCalendar();
	}

	public String getBeginingDate() {
		int todaysYear = today.get(Calendar.YEAR);
		int beginingYear = this.findElectionYear(todaysYear);
		GregorianCalendar beginingDate = new GregorianCalendar(beginingYear, 1,
				1);
		Date date = beginingDate.getTime();
		String beginingDateString = df.format(date);
		return beginingDateString;
	}

	public String getToday() {
		Date date = today.getTime();
		String todaysDate = df.format(date);
		return todaysDate;
	}

	private int findElectionYear(int currentYear) {
		while (currentYear % 4 != 3) {
			currentYear--;
		}

		return currentYear;
	}
}
