package model;

public class Statistic {
	private Deputy deputy;
	private int totalOfSessions;
	private int sessionsAttended;

	public Deputy getDeputy() {
		return deputy;
	}

	public void setDeputy(Deputy deputy) {
		this.deputy = deputy;
	}

	public int getTotalOfSessions() {
		return totalOfSessions;
	}

	public void setTotalOfSessions(int totalOfSessions) {
		this.totalOfSessions = totalOfSessions;
	}

	public int getSessionsAttended() {
		return sessionsAttended;
	}

	public void setSessionsAttended(int sessionsAttended) {
		this.sessionsAttended = sessionsAttended;
	}

}
