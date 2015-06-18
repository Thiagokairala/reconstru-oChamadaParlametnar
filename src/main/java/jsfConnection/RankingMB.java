package jsfConnection;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import control.RankingControl;
import model.Deputy;

@ManagedBean
@SessionScoped
public class RankingMB {
	public List<Deputy> getAllDeputies() {
		RankingControl rankingControl = new RankingControl();
		return rankingControl.getRankingDeputy();

	}
}
