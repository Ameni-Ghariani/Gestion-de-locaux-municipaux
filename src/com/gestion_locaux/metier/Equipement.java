package com.gestion_locaux.metier;

public class Equipement {

	private int EquipementID;
	private String 	equipement_name;

	public Equipement(){

	}

	
	@Override
	public String toString() {
		return "Equipement [EquipementID=" + EquipementID + "]";
	}





	public int getEquipementID() {
		return EquipementID;
	}


	public void setEquipementID(int equipementID) {
		EquipementID = equipementID;
	}


	public Equipement(int equipementID, String equipement_name) {
		super();
		EquipementID = equipementID;
		this.equipement_name = equipement_name;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Equipement))
			return false;
		Equipement other = (Equipement) obj;
		if (EquipementID != other.EquipementID)
			return false;
		return true;
	}

	

	public String getEquipement_name() {
		return equipement_name;
	}


	public void setEquipement_name(String equipement_name) {
		this.equipement_name = equipement_name;
	}


	public void finalize() throws Throwable {

	}
	public void ajouter(){

	}

	public void deplacer(){

	}

	public void supprimer(){

	}
}//end Equipement