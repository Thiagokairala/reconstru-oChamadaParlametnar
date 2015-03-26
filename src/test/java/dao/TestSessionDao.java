package dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Session;

import org.junit.Test;

public class TestSessionDao {

	@Test
	public void test() {
		Calendar date = new GregorianCalendar();
		date.set(2015, 1, 1);

		Session session = new Session();

		SessionDao sessionDao = new SessionDao();
		session.setDate(date);
		sessionDao.saveSession(session);

	}
}
