package jsfConnection;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import control.DeputyControl;
import control.PoliticalPartyControl;

@ManagedBean
public class AutoComplete {

	public List<String> completeDeputies(String prefix) {
		List<String> deputies = new ArrayList<String>();
		DeputyControl deputyControl = new DeputyControl();
		deputies = deputyControl.getAllNameOfAllDeputies(prefix);
		return deputies;
	}
	
	public List<String> completeParties(String prefix) {
		List<String> parties = new ArrayList<String>();
		PoliticalPartyControl partyControl = new PoliticalPartyControl();
		parties = partyControl.getAllNameOfAllParties(prefix);
		return parties;
	}
}
