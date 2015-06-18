package dao;

import model.Ranking;

public class RankingDao extends GenericDao<Long, Ranking> {
	public RankingDao() {
		super();
	}

	public void saveRanking(Ranking ranking) {
		try {
			super.beginTransaction();
			super.save(ranking);
			super.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.rollBack();
		}
	}
}
