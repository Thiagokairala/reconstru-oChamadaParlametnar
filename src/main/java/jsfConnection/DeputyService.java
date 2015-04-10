package jsfConnection;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Deputy;
import control.DeputyControl;

@ManagedBean(name = "deputyService", eager = true)
@ApplicationScoped
public class DeputyService {

	private List<Deputy> listOfDeputies;

	@PostConstruct
	public void init() {
		DeputyControl deputyControl = new DeputyControl();
		listOfDeputies = deputyControl.getAllDeputies();
	}

	public List<Deputy> getLiDeputies() {
		return this.listOfDeputies;
	}
}
