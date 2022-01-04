package com.gestion_locaux.metier;

import java.sql.Time;

import java.sql.Date;

public class PlageHoraire {
	public Date date;
	public Time heureDebut;
	public Time heureFin;
	public int PlagehoraireID ; 

	
	
	public String getPlage(PlageHoraire h ) {
		String typePlage= "a";
		if (h.getPlagehoraireID()==1) {
			typePlage="demi_journée";
		}
		else if (h.getPlagehoraireID()==2){
			typePlage="journée";
		}
		else 
			typePlage="soirée";
		return typePlage ; 
	}
	

	public PlageHoraire(){

	}

	
	


	public int getPlagehoraireID() {
		return PlagehoraireID;
	}


	public void setPlagehoraireID(int plagehoraireID) {
		PlagehoraireID = plagehoraireID;
	}


	

	@Override
	public String toString() {
		return "PlageHoraire [PlagehoraireID=" + PlagehoraireID + ", date=" + date + ", heureDebut=" + heureDebut
				+ ", heureFin=" + heureFin + "]";
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PlageHoraire))
			return false;
		PlageHoraire other = (PlageHoraire) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (heureDebut == null) {
			if (other.heureDebut != null)
				return false;
		} else if (!heureDebut.equals(other.heureDebut))
			return false;
		if (heureFin == null) {
			if (other.heureFin != null)
				return false;
		} else if (!heureFin.equals(other.heureFin))
			return false;
		
		return true;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Date getDate() {
		return date;
	}

	public void String(Date date) {
		this.date = date;
	}

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}

	

	

	public PlageHoraire(Date date, Time heureDebut, Time heureFin, int plagehoraireID) {
		super();
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		PlagehoraireID = plagehoraireID;
	}


	public void finalize() throws Throwable {

	}
	

	public void libererPlage(){

	}

	public boolean libre(){
		return false;
	}

	public void reserverPlage(){

	}

	/**
	 * 
	 * @param newVal
	 */
	
}//end PlageHoraire