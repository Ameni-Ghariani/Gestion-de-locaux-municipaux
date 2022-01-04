package com.gestion_locaux.metier;

import java.time.LocalDate;
import java.util.Date;


public class Facture {

	private Date date;
	private float montant;
	private int num;
	public Reservation m_Reservation;


	public Facture(){

	}

	
	@Override
	public String toString() {
		return "Facture [date=" + date + ", montant=" + montant + ", num=" + num + ", m_Reservation=" + m_Reservation
				+ "]";
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Facture))
			return false;
		Facture other = (Facture) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Float.floatToIntBits(montant) != Float.floatToIntBits(other.montant))
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Reservation getM_Reservation() {
		return m_Reservation;
	}


	public void setM_Reservation(Reservation m_Reservation) {
		this.m_Reservation = m_Reservation;
	}


	public Facture(Date date, float montant, int num, Reservation m_Reservation) {
		super();
		this.date = date;
		this.montant = montant;
		this.num = num;
		this.m_Reservation = m_Reservation;

	}

	public void finalize() throws Throwable {

	}
	public void mettre(){

	}

	public void supprimer(){

	}


	
}//end Facture