package jsfConnection;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import control.DeputyControl;

@ManagedBean
public class AutoComplete {

	public List<String> completeDeputies(String prefix) {
		List<String> deputies = new ArrayList<String>();
		DeputyControl deputyControl = new DeputyControl();
		deputies = deputyControl.getAllNameOfAllDeputies(prefix);
		return deputies;
	}
}
