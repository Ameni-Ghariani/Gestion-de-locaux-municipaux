package com.gestion_locaux.DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gestion_locaux.metier.Batiment;
import com.gestion_locaux.metier.Reservation;
import com.gestion_locaux.metier.Salle;



public class BatimentDAO {

	public Batiment findById(int b1) { //b1 est un BatimentID
		String rq="select * from batiment where BatimentID=?";
		Batiment b= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, b1);
			ResultSet res= st.executeQuery();
			if(res.next())
				b=new Batiment(res.getString(1),res.getInt(2));
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu �tre ex�cut�e ");
		}
		return b;
	}
//=========================save  ================================
	public void save(Batiment b) {
		int n=0;
		String rq1="update batiment set adresse= ? where BatimentID =?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq1);
			st.setString(1,b.getAdresse());
			st.setInt(2,b.getBatimentID());

			n= st.executeUpdate();//n: nbre de lignes modifi�es
			st.close();
			if(n==1) {
				System.out.println("Mise � jour du batiment avec succ�s ");
			}
		} catch (SQLException e) {
			System.out.println("Mise � jour du batiment a �chou� ");
		}
		if(n==0)//Le batiment b n'existe pas ds la table batiment de la BD
			    //je vais l'ins�rer
			{try {
			String rq2="insert into batiment(adresse,batimentID) values (?,?)";
			st=cnx.prepareStatement(rq2);			
			st.setString(1,b.getAdresse());
			st.setInt(2,b.getBatimentID());

			n= st.executeUpdate();
			System.out.println("Ajout du batiment avec succ�s ");
			st.close();
			} catch (SQLException e) {
				System.out.println("L'ajout du batiment a �chou� ");
			}
			}
	}
//=============================
	public void delete(int i) {//b: batimentID du batiment
		int n=0;
		String rq="DELETE from batiment where batimentID=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, i);
			n= st.executeUpdate();
			if(n==1)
				System.out.println("Le batiment a �t� archiv� avec succ�s ");
			else //n=0
				System.out.println("Aucun batiment n'a �t� archiv�  ");
			st.close();
		}catch(SQLException e) {
			System.out.println("La requete delete n'a pas �t� ex�cut�e");
		}
}

	
}