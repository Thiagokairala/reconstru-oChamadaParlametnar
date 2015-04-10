package jsfConnection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Index {
	public String getDeputyNames() {
		System.out.println("ola");
		return "index";
	}

}
