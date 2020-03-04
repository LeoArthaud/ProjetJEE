package controller;

import javax.servlet.http.HttpServletRequest;

public class ControllerForms {
	private boolean[] resultat;

	public boolean getResultat(int i) {
		return resultat[i];
	}
	public void setResultat(int i, Boolean resultat) {
		this.resultat[i] = resultat;
	}	
	public boolean[] getResultat() {
		return resultat;
	}
	public void setResultat(boolean[] resultat) {
		this.resultat = resultat;
	}
	public void ControleProduit(HttpServletRequest request) {}

}
