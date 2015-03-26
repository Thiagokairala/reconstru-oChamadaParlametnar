package model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class Session {
	@Id
	@GeneratedValue
	private long id;
	private Calendar date;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "deputy_session", joinColumns = { @JoinColumn(name = "session_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "deputy_id", nullable = false, updatable = false) })
	private List<Deputy> deputies;

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void validate() {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null");
		}
	}
}