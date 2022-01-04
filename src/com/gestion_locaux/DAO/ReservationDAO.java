package com.gestion_locaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.gestion_locaux.metier.Demandeur;
import com.gestion_locaux.metier.PlageHoraire;
import com.gestion_locaux.metier.Reservation;
import com.gestion_locaux.metier.Salle;



public class ReservationDAO {

	public Reservation findById(int r1) { //r1 est un num de Reservation
		String rq="select * from reservation where num=?";
		Reservation r= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, r1);
			ResultSet res= st.executeQuery();
			
			int num = 0 ;
			float prix=0;
			int DemandeurID =0;
			int PlagehoraireID  =0;
			int SalleID  =0;
			
			DemandeurDAO d = new DemandeurDAO();
			PlageHoraireDAO ph = new PlageHoraireDAO();
			SalleDAO s = new SalleDAO();
			
			if(res.next())
			num = res.getInt(1);
			prix= res.getFloat(2);
			PlagehoraireID = res.getInt(3);
			SalleID = res.getInt(4);
			DemandeurID = res.getInt(5);

				  
			Demandeur dd = d.findById(DemandeurID);
			PlageHoraire pp = ph.findById(PlagehoraireID);
			Salle ss = s.findById(SalleID);
				 r = new Reservation(num,prix,pp,ss,dd);
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu être exécutée ");
		}
		return r;
	}
	
	//=========================save  ================================
		public void save(Reservation r) {
			int n=0;
			String rq1="update reservation set prix=?,PlagehoraireID=?,SalleID=?,DemandeurID=? where num =?";
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st=cnx.prepareStatement(rq1);
				st.setInt(1,r.getNum());
				st.setFloat(2,r.getPrix());
				st.setInt(3,r.getM_PlageHoraire().getPlagehoraireID());
				st.setInt(4,r.getM_Salle().getNum());
				st.setInt(5,r.getM_Demandeur().getCode());
				

				n= st.executeUpdate();//n: nbre de lignes modifiées
				st.close();
				if(n==1) {
					System.out.println("Mise à jour du reservation avec succès ");
				}
			} catch (SQLException e) {
				//System.out.println("Mise à jour du reservation a échoué ");
			}
			if(n==0)//La salle b n'existe pas ds la table salle de la BD
				    //je vais l'insérer
				{try {
				String rq2="insert into reservation (num,prix,PlagehoraireID,SalleID,DemandeurID) values (?,?,?,?,?)";
				st=cnx.prepareStatement(rq2);			
				st.setInt(1,r.getNum());
				st.setFloat(2,r.getPrix());
				st.setInt(3,r.getM_PlageHoraire().getPlagehoraireID());
				st.setInt(4,r.getM_Salle().getNum());
				st.setInt(5,r.getM_Demandeur().getCode());

				n= st.executeUpdate();
				System.out.println("Ajout du reservation avec succès ");
				st.close();
				} catch (SQLException e) {
					System.out.println("La reservation est déjà dans la base de donnée ");
				}
				}
			
		}
	//=============================
		public void delete(int r) {//s: num du salle
			int n=0;
			String rq="DELETE from reservation where num=?";
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st=cnx.prepareStatement(rq);
				st.setInt(1, r);
				n= st.executeUpdate();
				if(n==1)
					System.out.println("La reservation a été archivé avec succès ");
				else //n=0
					System.out.println("Aucune reservation n'a été archivé  ");
				st.close();
			}catch(SQLException e) {
				System.out.println("La requete delete n'a pas été exécutée");
			}
	}

		



	
}