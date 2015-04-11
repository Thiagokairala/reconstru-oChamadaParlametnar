package jsfModels;

public enum DeputyRingProperty {
	CIVIL_NAME("Nome Civil"), TREATMENT_NAME("Nome de Tratamento"), PERCENTAGE_OF_PRESENCE(
			"Porcentagem de presença"), SESSIONS_ATTENDED("Sessões presentes"), TOTAL_OF_SESSIONS(
			"Total de sessões");

	public String property;

	private DeputyRingProperty(String property) {
		this.property = property;
	}

	public String getProperty() {
		return this.property;
	}
}