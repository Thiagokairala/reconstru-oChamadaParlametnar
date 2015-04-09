package jsfConnection;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.Deputy;

@ManagedBean (name = "deputyMB")
@ViewScoped
public class DeputyMB {

	/*@ManagedProperty(value = "#{deputyBO}")
	private DeputyMB deputyBO;
	*/
	private Deputy deputy;
	private List<Deputy> deputies;
	private List<Deputy> treatmentName;
	private int clicou = 1;
	public void setNameDeputy(String name) {
		deputy = new Deputy();
		deputy.setTreatmentName(name);
		clicou = 0;
	}
	
	public String getNameDeputy() {
		if(clicou == 0){
			return deputy.getTreatmentName();
		} else{
			return null;
		}
		}

}
