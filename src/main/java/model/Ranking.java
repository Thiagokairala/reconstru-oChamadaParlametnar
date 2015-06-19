package model;

import java.io.Serializable;
import java.text.DecimalFormat;

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
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getPercentageString() {
		DecimalFormat df = new DecimalFormat("0.##");

		return df.format(this.percentage*100);
	}

}
