package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Ranking
 *
 */
@Entity
@Table
public class Ranking implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	private double percentage;

	private static final long serialVersionUID = 1L;

	public Ranking() {
		super();
	}

	public double getPercentage() {

		return percentage*100;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
