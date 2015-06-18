package jsfConnection;

import java.text.DecimalFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Deputy;
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
	private String percentageFormat;
	

	public String generateStatistics() throws PoliticalPartyExtinct, DeputyNotFoundException {
		String nextPage;
		PoliticalPartyControl deputyControl = new PoliticalPartyControl();
		percentage = deputyControl.generateStatisticParty(partyName);
		DecimalFormat df = new DecimalFormat("#,###.00");  
		percentageFormat = df.format(percentage); 
		nextPage = "statisticParty";

		return nextPage;
	}
	
	public List<Deputy> getAllDeputiesOfThisParty() throws DeputyNotFoundException {
		PoliticalPartyControl deputyControl = new PoliticalPartyControl();
		List<Deputy> deputiesOfThisParty = deputyControl.listAllDeputiesOfThisParty(partyName);
		return deputiesOfThisParty;
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
	
	public String getPercentageFormat() {
		return percentageFormat;
	}

	public void setPercentageFormat(String percentageFormat) {
		this.percentageFormat = percentageFormat;
	}
	
	
}
