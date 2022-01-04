package com.gestion_locaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gestion_locaux.metier.Demandeur;
import com.gestion_locaux.metier.Reservation;


public class DemandeurDAO {
	public Demandeur findById(int d1) { 
		String rq="select * from demandeur where code=?";
		Demandeur d= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, d1);
			ResultSet res= st.executeQuery();
			if(res.next())//Il existe un demandeur ayant le code d1
				d=new Demandeur(res.getString(1), res.getString(2),res.getInt(3));
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu �tre ex�cut�e ");
		}
		return d;
	}
//=========================save  ================================
	public void save(Demandeur d) {
		int n=0; 
		String rq1="update demandeur set nomprenom=? adresse=? where code =?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq1);
			st.setString(1, d.getNomprenom() );
			st.setString(2,d.getAdresse());
			st.setInt(3, d.getCode() );

			
			n= st.executeUpdate();//n: nbre de lignes modifi�es

			st.close();
			if(n==1) {
				System.out.println("Mise � jour du demandeur avec succ�s ");
			}
		} catch (SQLException e) {
			System.out.println("Mise � jour du demandeur a �chou� ");
		}
		if(n==0)//Le demandeur d n'existe pas ds la table demandeur de la BD
			    //je vais l'ins�rer
			{try {
			String rq2="insert into demandeur(code,nomprenom,adresse) values (?,?,?)";
			st=cnx.prepareStatement(rq2);			
			st.setInt(1, d.getCode() );
			st.setString(2, d.getNomprenom() );
			st.setString(3,d.getAdresse());

			n= st.executeUpdate();
			System.out.println("Ajout du demandeur avec succ�s ");
			st.close();
			} catch (SQLException e) {
				System.out.println("ce demandeur est d�j� ajout�e ");
			}
			}
	}
//=============================
	public void delete(int b) {//b: code du demandeur
		int n=0;
		String rq="DELETE from demandeur where code=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, b);
			n= st.executeUpdate();
			if(n==1)
				System.out.println("Le demandeur a �t� archiv� avec succ�s ");
			else //n=0
				System.out.println("Aucun demandeur n'a �t� archiv�  ");
			st.close();
		}catch(SQLException e) {
			System.out.println("La requete demandeur n'a pas �t� ex�cut�e");
		}
}
	
}