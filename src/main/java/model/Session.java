package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPUTY")
public class Session {
	@Id
	@GeneratedValue
	private String info;
	private String idSession;
	private java.util.Date date;

	public Session() {

	}

	public Session(String info, String idSession, java.util.Date date) {
		this.idSession = idSession;
		this.info = info;
		this.date = date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public void validate() {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null");
		}
	}

}