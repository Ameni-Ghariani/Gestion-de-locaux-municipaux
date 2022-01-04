package com.gestion_locaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gestion_locaux.metier.Batiment;
import com.gestion_locaux.metier.Equipement;
import com.gestion_locaux.metier.PlageHoraire;
import com.gestion_locaux.metier.Reservation;
import com.gestion_locaux.metier.Salle;

public class SalleDAO {
	public Salle findById(int s1) { //s1 est un num de salle
		String rq="select * from salle where num=?";
		Salle s= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, s1);
			ResultSet res= st.executeQuery();
			
			int num = 0 ;
			double superficie=0;
			int BatimentID  =0;
			int EquipementID   =0;
		
			BatimentDAO b = new BatimentDAO();
			EquipementDAO eq = new EquipementDAO();
			
			if(res.next())
				
				num = res.getInt(1);
			superficie= res.getDouble(2);
			BatimentID = res.getInt(3);
			EquipementID = res.getInt(4);
			Batiment bb = b.findById(BatimentID);
			Equipement ee = eq.findById(EquipementID);
				 s = new Salle(num,superficie,bb,ee);
				//s=new Salle(res.getInt(1),res.getDouble(2),res.getInt(3),res.getInt(4));
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu être exécutée ");
		}
		return s;
	}
	
	//=========================save  ================================
		public void save(Salle s) {
			int n=0;
			String rq1="update salle set superficie= ?, BatimentID=?, EquipementID  =? where num =?";
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st=cnx.prepareStatement(rq1);
				st.setInt(1,s.getNum());
				st.setDouble(2,s.getSuperficie());
				st.setInt(3,s.getM_Batiment().getBatimentID());
				st.setInt(4,s.getM_Equipement().getEquipementID());

				n= st.executeUpdate();//n: nbre de lignes modifiées
				st.close();
				if(n==1) {
					System.out.println("Mise à jour du Salle avec succès ");
				}
			} catch (SQLException e) {
				System.out.println("Mise à jour du Salle a échoué ");
			}
			if(n==0)//La salle b n'existe pas ds la table salle de la BD
				    //je vais l'insérer
				{try {
				String rq2="insert into salle (num,superficie,BatimentID,EquipementID) values (?,?,?,?)";
				st=cnx.prepareStatement(rq2);			
				st.setInt(1,s.getNum());
				st.setDouble(2,s.getSuperficie());
				st.setInt(3,s.getM_Batiment().getBatimentID());
				st.setInt(4,s.getM_Equipement().getEquipementID());

				n= st.executeUpdate();
				System.out.println("Ajout du salle avec succès ");
				st.close();
				} catch (SQLException e) {
					System.out.println("L'ajout du salle a échoué ");
				}
				}
		}
	//=============================
		public void delete(int s) {//s: num du salle
			int n=0;
			String rq="DELETE from salle where num=?";
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st=cnx.prepareStatement(rq);
				st.setInt(1, s);
				n= st.executeUpdate();
				if(n==1)
					System.out.println("La salle a été archivé avec succès ");
				else //n=0
					System.out.println("Aucune salle n'a été archivé  ");
				st.close();
			}catch(SQLException e) {
				System.out.println("La requete delete n'a pas été exécutée");
			}
	}

	
}