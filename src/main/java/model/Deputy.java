package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPUTY")
public class Deputy {
	@Id
	@GeneratedValue
	private String treatmentName;
	private String civilName;
	private String idParliamentary;
	private String phone;
	private String email;
	private Date nascimento;
	private Gender gender;
	private Uf uf;
	private PoliticalParty politicalParty;
	private int officeNumber;
	private int officeBuilding;

	public Deputy() {

	}

	public Deputy(String treatmentName, String civilName,
			String idParliamentary, String phone, String email,
			java.util.Date nascimento) {
		this.treatmentName = treatmentName;
		this.civilName = civilName;
		this.idParliamentary = idParliamentary;
		this.phone = phone;
		this.email = email;
		this.nascimento = nascimento;
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

	public String getIdParliamentary() {
		return idParliamentary;
	}

	public void setIdParliamentary(String idParliamentary) {
		this.idParliamentary = idParliamentary;
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

	public void setGender(String textFromXML) {
		// TODO Auto-generated method stub

	}

	public void setUf(String textFromXML) {
		// TODO Auto-generated method stub

	}

	public void setPoliticalParty(String politicalPartyString) {
		PoliticalParty politicalParty = new PoliticalParty();
		politicalParty.setAchronym(politicalPartyString);
		this.politicalParty = politicalParty;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;

	}

	public void setOfficeBuilding(int officeBuilding) {
		this.officeBuilding = officeBuilding;
	}
}
