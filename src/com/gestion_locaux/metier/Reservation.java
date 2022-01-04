package com.gestion_locaux.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gestion_locaux.DAO.ReservationDAO;



public class Reservation {

	public int num;
	public float prix;
	public PlageHoraire m_PlageHoraire;
	public Salle m_Salle;
	public Demandeur m_Demandeur;


	
	public Reservation(){

	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reservation))
			return false;
		Reservation other = (Reservation) obj;
		if (m_Demandeur == null) {
			if (other.m_Demandeur != null)
				return false;
		} else if (!m_Demandeur.equals(other.m_Demandeur))
			return false;
		if (m_PlageHoraire == null) {
			if (other.m_PlageHoraire != null)
				return false;
		} else if (!m_PlageHoraire.equals(other.m_PlageHoraire))
			return false;
		if (m_Salle == null) {
			if (other.m_Salle != null)
				return false;
		} else if (!m_Salle.equals(other.m_Salle))
			return false;
		if (num != other.num)
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		return true;
	}






	@Override
	public String toString() {
		return "Reservation [num=" + num + ", prix=" + prix + ", m_Salle=" + m_Salle + ", m_Demandeur=" + m_Demandeur
				+ ", m_PlageHoraire=" + m_PlageHoraire + "]";
	}












	public Reservation(int num, float prix, PlageHoraire m_PlageHoraire, Salle m_Salle, Demandeur m_Demandeur) {
		super();
		this.num = num;
		this.prix = prix;
		this.m_PlageHoraire = m_PlageHoraire;
		this.m_Salle = m_Salle;
		this.m_Demandeur = m_Demandeur;
	}


	public Salle getM_Salle() {
		return m_Salle;
	}






	public void setM_Salle(Salle m_Salle) {
		this.m_Salle = m_Salle;
	}






	public Demandeur getM_Demandeur() {
		return m_Demandeur;
	}






	public void setM_Demandeur(Demandeur m_Demandeur) {
		this.m_Demandeur = m_Demandeur;
	}






	public PlageHoraire getM_PlageHoraire() {
		return m_PlageHoraire;
	}






	public void setM_PlageHoraire(PlageHoraire m_PlageHoraire) {
		this.m_PlageHoraire = m_PlageHoraire;
	}






	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	

	

	public void finalize() throws Throwable {

	}
	public void ajouter( Demandeur d , int s , String p, float montant , LocalDate date){
		num++;
		float m = CalculePrixLocation( s ,p);
	}

	
	public static float CalculePrixLocation(int s ,String plageHoraire) {
		int prix = 0;
		if(s<300) {
			if(plageHoraire=="semi-journée") {
			return prix=250;
			}
			if(plageHoraire=="journée") {
				return prix=350;
				}
			if(plageHoraire=="soirée") {
				return prix=500;
				}
				
			
		}
		else
		{
			if(plageHoraire=="semi-journée") {
				return prix=400;
				}
				if(plageHoraire=="journée") {
					return prix=700;
					}
				if(plageHoraire=="soirée") {
					return prix=500;
					}
		}
		return prix;
	}
	
	public void annuler(){

	}

	public void calculerPrix(){

	}

	public void confirmer(){

	}


	
}//end Reservation