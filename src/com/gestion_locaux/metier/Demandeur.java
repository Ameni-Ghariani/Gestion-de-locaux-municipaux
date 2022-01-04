package com.gestion_locaux.metier;

import java.util.List;

public class Demandeur {

	private String adresse;
	private int code;
	private String nomprenom;

	public Demandeur(){

	}

	public Demandeur(String nomprenom,String adresse,int code) {
		super();

		this.adresse = adresse;
		this.code = code;
		this.nomprenom = nomprenom;
	}

	
	@Override
	public String toString() {
		return "Demandeur [adresse=" + adresse + ", code=" + code + ", nomprenom=" + nomprenom + "]";
	}

	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Demandeur))
			return false;
		Demandeur other = (Demandeur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (code != other.code)
			return false;
		
		if (nomprenom == null) {
			if (other.nomprenom != null)
				return false;
		} else if (!nomprenom.equals(other.nomprenom))
			return false;
		return true;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}

	
	public void finalize() throws Throwable {

	}
	

	/**
	 * 
	 * @param newVal
	 */
	
}//end Demandeur