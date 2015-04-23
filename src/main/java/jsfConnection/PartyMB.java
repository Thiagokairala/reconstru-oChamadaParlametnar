package jsfConnection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.PoliticalParty;
import control.DeputyControl;
import control.PoliticalPartyControl;
import exception.DeputyNotFoundException;

@ManagedBean
@SessionScoped
public class PartyMB {
	private PoliticalParty party;
	private String partyName;
	private Double percentage;
	
	public String generateStatistics() {
		String nextPage;
		PoliticalPartyControl deputyControl = new PoliticalPartyControl();
		try {
			percentage = deputyControl.generateStatisticParty(partyName);

			nextPage = "statisticParty";
		} catch (DeputyNotFoundException e) {
			nextPage = "partyNotFound";
		}

		return nextPage;
	}
	
	public PoliticalParty getParty() {
		return party;
	}
	public void setParty(PoliticalParty party) {
		this.party = party;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	
	
}
