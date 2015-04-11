package jsfConnection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jsfModels.DeputyInformationRing;
import jsfModels.DeputyRingProperty;
import model.Deputy;
import model.Statistic;

import org.primefaces.model.chart.PieChartModel;

import control.DeputyControl;
import exception.DeputyNotFoundException;

@ManagedBean
@SessionScoped
public class DeputyMB {
	private Deputy deputy;
	private String deputyName;
	private Statistic statistic;

	private List<DeputyInformationRing> ring;
	private DeputyInformationRing selectedInformation;

	private PieChartModel pieChart;

	public String generateStatistics() {
		String nextPage;
		DeputyControl deputyControl = new DeputyControl();
		try {
			statistic = deputyControl.generateStatistic(deputyName);

			double sessionsAttended = (double) statistic.getSessionsAttended();
			double totalOfSessions = (double) statistic.getTotalOfSessions();
			double percentageOfPresence = sessionsAttended / totalOfSessions;

			prepareRing(percentageOfPresence, sessionsAttended,
					totalOfSessions, statistic.getDeputy().getCivilName(),
					statistic.getDeputy().getTreatmentName());
			createPieModel();
			nextPage = "deputyStatisticsResult";
		} catch (DeputyNotFoundException e) {
			nextPage = "deputyNotFound";
		}

		return nextPage;
	}

	private void prepareRing(double percentageOfPresence,
			double sessionsAttended, double totalOfSessions, String civilName,
			String treatmentName) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		ring = new ArrayList<DeputyInformationRing>();
		ring.add(prepareRingNode(DeputyRingProperty.CIVIL_NAME, civilName));
		ring.add(prepareRingNode(DeputyRingProperty.TREATMENT_NAME,
				treatmentName));
		ring.add(prepareRingNode(DeputyRingProperty.PERCENTAGE_OF_PRESENCE,
				decimalFormat.format(percentageOfPresence)));
		ring.add(prepareRingNode(DeputyRingProperty.SESSIONS_ATTENDED,
				decimalFormat.format(sessionsAttended)));
		ring.add(prepareRingNode(DeputyRingProperty.TOTAL_OF_SESSIONS,
				decimalFormat.format(totalOfSessions)));

	}

	private DeputyInformationRing prepareRingNode(DeputyRingProperty property,
			String propertyValue) {
		DeputyInformationRing deputyInformationRing = new DeputyInformationRing();

		deputyInformationRing.setProperty(property.getProperty());
		deputyInformationRing.setPropertyValue(propertyValue);

		return deputyInformationRing;
	}

	private void createPieModel() {
		pieChart = new PieChartModel();

		pieChart.set("Presente", this.statistic.getSessionsAttended());
		pieChart.set("Ausente", this.statistic.getTotalOfSessions()
				- this.statistic.getSessionsAttended());

		pieChart.setTitle("Presença");
		pieChart.setLegendPosition("e");
		pieChart.setFill(false);
		pieChart.setShowDataLabels(true);
		pieChart.setDiameter(150);
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

	public Statistic getStatistic() {
		return statistic;
	}

	public void setStatistic(Statistic statistic) {
		this.statistic = statistic;
	}

	public PieChartModel getPieChart() {
		return pieChart;
	}

	public void setPieChart(PieChartModel pieChart) {
		this.pieChart = pieChart;
	}

	public List<DeputyInformationRing> getRing() {
		return ring;
	}

	public void setRing(List<DeputyInformationRing> ring) {
		this.ring = ring;
	}

	public DeputyInformationRing getSelectedInformation() {
		return selectedInformation;
	}

	public void setSelectedInformation(DeputyInformationRing selectedInformation) {
		this.selectedInformation = selectedInformation;
	}

}
