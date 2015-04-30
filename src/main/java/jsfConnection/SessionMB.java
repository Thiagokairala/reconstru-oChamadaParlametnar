package jsfConnection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jsfModels.DeputyInformationRing;
import jsfModels.DeputyRingProperty;
import model.Session;
import model.Statistic;

import org.primefaces.model.chart.PieChartModel;

import control.SessionControl;
import exception.PoliticalPartyNotFoundException;
import exception.SessionNotFoundException;

@ManagedBean
@SessionScoped
public class SessionMB {
	private Session session;
	private String Session_name;
	
	
	public String searchSession() throws SessionNotFoundException, PoliticalPartyNotFoundException {
		String next_page;
		SessionControl sessionControl = new SessionControl();
		session = sessionControl.SearchForSession(session);
		next_page = "SearchForSession";
		
		return next_page;
	}


	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}


	public String getSession_name() {
		return Session_name;
	}


	public void setSession_name(String session_name) {
		Session_name = session_name;
	}

}
