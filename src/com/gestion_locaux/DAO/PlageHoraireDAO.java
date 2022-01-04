package com.gestion_locaux.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.gestion_locaux.metier.PlageHoraire;



public class PlageHoraireDAO {
	//-----------------------------------------------save
	public void save (PlageHoraire p) {
	      int n=0;

	String rq= "update plagehoraire set date=?, heureDebut=? , heureFin=? where PlagehoraireID=?";
	Connection cnx= SConnection.getInstance();
	PreparedStatement st= null;
		try {
			st = cnx.prepareStatement(rq);
			st.setObject(1,p.getDate());
			st.setObject(2, p.getHeureDebut());
			st.setObject(3,p.getHeureFin());
			st.setInt(4,p.getPlagehoraireID());


			n= st.executeUpdate();
			st.close();
			if(n==1) {
				System.out.println("Mise à jour du plagehoraire avec succès ");

			}

		} catch (SQLException e) {
			//System.out.println("Exception dans MAJ de la plagehoraire ");
		}
		
				
		if(n==0) //n=0 => ajouter la plage horaire
		{ String rq2= "insert into plagehoraire(date, heureDebut,heureFin,PlagehoraireID) values (?,?,?,?)";
		try {
			st = cnx.prepareStatement(rq2);
			st.setObject(1,p.getDate());
			st.setObject(2, p.getHeureDebut());
			st.setObject(3,p.getHeureFin());
			st.setInt(4,p.getPlagehoraireID());
			n= st.executeUpdate();
			st.close();
			System.out.println("plagehoraire ajoutée avec succès");
		} catch (SQLException e) {
			System.out.println("Exception dans l'ajout de la plagehoraire ");
		}}}
		
		//-------------delete---------------------------------
		
		public void delete(int p) {//p: id du plage
			int n=0;
			String rq="DELETE from  plagehoraire  where PlagehoraireID =?";
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st=cnx.prepareStatement(rq);
				st.setInt(1, p);
				n= st.executeUpdate();
				if(n==1)
					System.out.println("La plagehoraire a été archivé avec succès ");
				else //n=0
					System.out.println("Aucune plagehoraire n'a été archivé  ");
				st.close();
			}catch(SQLException e) {
				System.out.println("La requete plagehoraire n'a pas été exécutée");
			}
}
		//--------------------findByid----------
		public PlageHoraire findById(int p1) { 
			String rq="select * from plagehoraire where PlagehoraireID=?";
			PlageHoraire p= null;
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st=cnx.prepareStatement(rq);
				st.setInt(1, p1);
				ResultSet res= st.executeQuery();
				
				int PlagehoraireID = 0 ;
				Date date = null ;
				Time heureDebut = null ;
				Time heureFin = null ;
				
				if(res.next())//Il existe un PlageHoraire ayant l'id p1
					
				{
					PlagehoraireID = res.getInt(4);
					date = res.getObject(1, Date.class) ;
					heureDebut = res.getObject(2, Time.class) ;
					heureFin = res.getObject(3, Time.class) ;
					
						  
						  
					
						 p = new PlageHoraire(date,heureDebut,heureFin,PlagehoraireID);
						
				}
					//p=new PlageHoraire(res.getDate(1).toLocalDate(),res.getTime(2).toLocalTime(),res.getTime(3).toLocalTime(),res.getInt(4));
				st.close();
			} catch (SQLException e) {
				System.out.println("La requete1 n'a pas pu être exécutée ");
			}
			return p;
}}