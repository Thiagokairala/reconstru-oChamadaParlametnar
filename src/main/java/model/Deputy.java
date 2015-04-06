package model;

import java.util.Date;
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
@Table(name = "deputy")
public class Deputy {
	@Id
	private int id;
	private String treatmentName;
	private String civilName;
	private String phone;
	private String email;
	private Date nascimento;
	private String gender;
	private String uf;
	private String politicalParty;
	private int officeNumber;
	private int officeBuilding;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "deputy_session", joinColumns = { @JoinColumn(name = "deputy_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "session_id", nullable = false, updatable = false) })
	private List<Session> sessionsAttended;
	private String registry;

	public Deputy() {

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

	public int getId() {
		return id;
	}

	public void setId(int idParliamentary) {
		this.id = idParliamentary;
	}

	public void setId(String idParliamentary) {
		this.id = Integer.parseInt(idParliamentary);
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

	public java.util.Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(java.util.Date nascimento) {
		this.nascimento = nascimento;
	}

	public void validate() {
		if (treatmentName == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
	}

	public void setGender(String gender) {
		this.gender = gender;

	}

	public void setUf(String uf) {
		this.uf = uf;

	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;

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

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getRegistry() {
		return registry;
	}

}
