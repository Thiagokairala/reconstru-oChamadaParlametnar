package jsfConnection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Deputy;
import control.DeputyControl;

@FacesConverter("deputyConverter")
public class DeputyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		DeputyControl deputyControl = new DeputyControl();

		for (Deputy deputy : deputyControl.getAllDeputies()) {
			if (deputy.getCivilName().equals(value)
					|| deputy.getTreatmentName().equals(value)) {

				return deputy;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value instanceof Deputy) {
			Deputy deputy = (Deputy) value;
			return deputy.getTreatmentName();
		}

		return "";
	}
}
