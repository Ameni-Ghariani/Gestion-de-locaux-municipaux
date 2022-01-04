package com.gestion_locaux.metier;

import java.util.List;

public class Salle {

	public int num;
	public double superficie;
	public Batiment m_Batiment;
	public Equipement m_Equipement;




	public Salle(){

	}

	


	




	





	




	


	public Salle(int num, double superficie, Batiment m_Batiment, Equipement m_Equipement) {
		super();
		this.num = num;
		this.superficie = superficie;
		this.m_Batiment = m_Batiment;
		this.m_Equipement = m_Equipement;
	}























	@Override
	public String toString() {
		return "Salle [num=" + num + ", superficie=" + superficie + ", m_Batiment=" + m_Batiment + ", m_Equipement="
				+ m_Equipement + "]";
	}























	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_Batiment == null) ? 0 : m_Batiment.hashCode());
		result = prime * result + ((m_Equipement == null) ? 0 : m_Equipement.hashCode());
		result = prime * result + num;
		long temp;
		temp = Double.doubleToLongBits(superficie);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}























	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Salle))
			return false;
		Salle other = (Salle) obj;
		if (m_Batiment == null) {
			if (other.m_Batiment != null)
				return false;
		} else if (!m_Batiment.equals(other.m_Batiment))
			return false;
		if (m_Equipement == null) {
			if (other.m_Equipement != null)
				return false;
		} else if (!m_Equipement.equals(other.m_Equipement))
			return false;
		if (num != other.num)
			return false;
		if (Double.doubleToLongBits(superficie) != Double.doubleToLongBits(other.superficie))
			return false;
		return true;
	}























	public Batiment getM_Batiment() {
		return m_Batiment;
	}























	public void setM_Batiment(Batiment m_Batiment) {
		this.m_Batiment = m_Batiment;
	}























	public Equipement getM_Equipement() {
		return m_Equipement;
	}























	public void setM_Equipement(Equipement m_Equipement) {
		this.m_Equipement = m_Equipement;
	}























	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	

	
	

	public void finalize() throws Throwable {

	}
	
}//end Salle