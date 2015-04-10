package jsfConnection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Deputy;

@ManagedBean
@SessionScoped
public class DeputyMB {
	private Deputy deputy;
	private String deputyName;

	public String getStatistics() {
		
		return "resultadoEstatistica";
	}

	public Deputy getDeputy() {
		return deputy;
	}

	public void setDeputy(Deputy deputy) {
		this.deputy = deputy;
	}

	public String getDeputyName() {
		return deputyName;
	}

	public void setDeputyName(String deputyName) {
		this.deputyName = deputyName;
	}

}
