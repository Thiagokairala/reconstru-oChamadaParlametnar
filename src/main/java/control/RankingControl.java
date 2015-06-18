package control;

import java.util.Collections;
import java.util.List;

import model.Deputy;
import dao.DeputyDao;

public class RankingControl {

	private DeputyDao deputyDao;

	public RankingControl() {
		this.deputyDao = new DeputyDao();
	}

	public List<Deputy> getRankingDeputy() {
		System.out.println("foi");

		List<Deputy> deputies = deputyDao.findAll();

		Collections.sort(deputies);

		return deputies;
	}

}
