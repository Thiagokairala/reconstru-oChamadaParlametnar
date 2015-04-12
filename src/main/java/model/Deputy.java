package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deputy")
public class Deputy {
	@Id
	private int id;
	private String treatmentName;
	private String civilName;
	private String phone;
	private String email;
	private Date birthday;
	private String gender;
	private String uf;
	@ManyToOne(cascade = { CascadeType.ALL })
	private PoliticalParty politicalParty;
	private int officeNumber;
	private int officeBuilding;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "deputy_session", joinColumns = { @JoinColumn(name = "deputy_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "session_id", nullable = false, updatable = false) })
	private List<Session> sessionsAttended;
	private String registry;

	public Deputy() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getCivilName() {
		return civilName;
	}

	public void setCivilName(String civilName) {
		this.civilName = civilName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public PoliticalParty getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(PoliticalParty politicalParty) {
		this.politicalParty = politicalParty;
	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public int getOfficeBuilding() {
		return officeBuilding;
	}

	public void setOfficeBuilding(int officeBuilding) {
		this.officeBuilding = officeBuilding;
	}

	public List<Session> getSessionsAttended() {
		return sessionsAttended;
	}

	public void setSessionsAttended(List<Session> sessionsAttended) {
		this.sessionsAttended = sessionsAttended;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

}
