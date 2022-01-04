package com.gestion_locaux.metier;

import java.util.List;

public class Batiment {

	private String adresse;
	private int BatimentID;
	private List<Salle> m_Salle;

	public Batiment(){

	}

	
	public Batiment(String adresse, int batimentID) {
		super();
		this.adresse = adresse;
		BatimentID = batimentID;
	}

	@Override
	public String toString() {
		return "Batiment [adresse=" + adresse + ", m_Salle=" + m_Salle + "]";
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Batiment))
			return false;
		Batiment other = (Batiment) obj;
		if (BatimentID != other.BatimentID)
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (m_Salle == null) {
			if (other.m_Salle != null)
				return false;
		} else if (!m_Salle.equals(other.m_Salle))
			return false;
		return true;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Salle> getM_Salle() {
		return m_Salle;
	}

	public void setM_Salle(List<Salle> m_Salle) {
		this.m_Salle = m_Salle;
	}

	public void finalize() throws Throwable {

	}
	public List<Salle> getSalle(){
		return m_Salle;
	}

	public int getBatimentID() {
		return BatimentID;
	}


	public void setBatimentID(int batimentID) {
		BatimentID = batimentID;
	}


	/**
	 * 
	 * @param newVal
	 */
	public void setSalle(List<Salle> newVal){
		m_Salle = newVal;
	}
}//end Batiment