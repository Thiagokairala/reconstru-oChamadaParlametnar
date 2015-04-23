package jsfConnection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.PoliticalParty;
import control.PoliticalPartyControl;
import exception.DeputyNotFoundException;
import exception.PoliticalPartyExtinct;

@ManagedBean
@SessionScoped
public class PartyMB {
	private PoliticalParty party;
	private String partyName;
	private Double percentage;
	
	public String generateStatistics() throws PoliticalPartyExtinct, DeputyNotFoundException {
		String nextPage;
		PoliticalPartyControl deputyControl = new PoliticalPartyControl();
		percentage = deputyControl.generateStatisticParty(partyName);

		nextPage = "statisticParty";

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
