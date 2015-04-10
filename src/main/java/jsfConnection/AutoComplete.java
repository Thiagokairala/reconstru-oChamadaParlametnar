package jsfConnection;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutoComplete {

	public List<String> completeDeputies(String prefix) {
		List<String> deputies = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			deputies.add(Integer.toString(i));
		}

		return deputies;
	}
}
