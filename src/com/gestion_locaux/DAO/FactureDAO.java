package com.gestion_locaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;

import javax.management.Query;

import com.gestion_locaux.metier.Facture;
import com.gestion_locaux.metier.Reservation;





public class FactureDAO {
	public void save (Facture f) {
		String rq= "update  facture set date=?, montant=?,num_reservation=? where num=? ";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st= null;
	int n=0;
			try {
				st = cnx.prepareStatement(rq);
				st.setObject(1,f.getDate());
				st.setFloat(2, f.getMontant());
				st.setInt(3,f.getNum());
				st.setInt(4,f.getM_Reservation().getNum());

				n= st.executeUpdate();
				st.close();
				if(n==1) {
					//System.out.println("Mise à jour du facture avec succès ");
				}
			} catch (SQLException e) {
				System.out.println("Exception dans MAJ de la facture ");
			}
			if(n==0) //n=0 => ajouter la facture
			{ String rq2= "insert into facture(date,montant,num,num_reservation) values (?,?,?,?)";
			try {
				st = cnx.prepareStatement(rq2);
				st.setObject(1,f.getDate());
				st.setFloat(2, f.getMontant());
				st.setInt(3,f.getNum());
				st.setInt(4,f.getM_Reservation().getNum());

				n= st.executeUpdate();
				st.close();
				System.out.println("Facture ajoutée avec succès");
			} catch (SQLException e) {
				System.out.println("Facture est déjà dans la base de donnée ");
			}
			}}
	
	
	//---------------------------delete------------------------------	
		public void delete (int n) {
				String rq1= "select dateFacture from facture where num=?";
				Connection cnx= SConnection.getInstance();
				long annee=0; //la différence entre la date actuelle et la date de la facture (en terme d'années)
				PreparedStatement st1=null;
				try {
					st1 = cnx.prepareStatement(rq1);
					st1.setInt(1, n);
					ResultSet res=st1.executeQuery();
					if(res.next())
						{
						LocalDate ld= res.getDate(1).toLocalDate(); 
						LocalDate auj= LocalDate.now();
						annee= ChronoUnit.YEARS.between(ld, auj);
						System.out.println("annee == "+ annee);
						}
					st1.close(); 
				} catch (SQLException e) {
					System.out.println("La requête rq1 n'a pas pu être exécutée");
				}
		//----Si annee<10 (la facture date moins de 10 ans)
				if(annee<10) {
				String rq= "update facture where num=?";
				PreparedStatement st2;
				try {
					st2 = cnx.prepareStatement(rq);
					st2.setInt(1, n);
					int n2= st2.executeUpdate(); 
					if (n2 == 1)
						System.out.println("La facture est archivée avec succès");
					else
						System.out.println("Problème dans l'archivage de facture");
					st2.close(); 
				} catch (SQLException e) {
					System.out.println("La requête de l'archivage de la facture n'a pas été exécutée");
				}
			}
			else { //Supprimer la facture
				String rq3= "delete from facture where num=?";
				PreparedStatement st;
				int n2=0;
				try {
						st = cnx.prepareStatement(rq3);
						st.setInt(1, n);
						n2= st.executeUpdate();
						st.close(); 
					    System.out.println("La suppression de facture est effectuée avec succès!");
				} catch (SQLException e) {
					System.out.println("Exception dans la suppression de facture !!");
				}
			}
		}
	//----------------------------findById------------------------------------
		public Facture findById(int n){ //n: n° de facture
			Facture f1= null;
			String s= "select * from facture where num=?"; 
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
				st = cnx.prepareStatement(s);
				st.setInt(1, n);		
				ResultSet res=st.executeQuery();
				
				int num = 0 ;
				Date date = null ;
				float montant = 0 ;
				int mreservation = 0 ;
				
				ReservationDAO pa = new ReservationDAO();

				
				if (res.next()) 
					num = res.getInt(3);
				date = res.getObject(1, Date.class) ;
				montant = res.getFloat(2) ;
				mreservation = res.getInt(4);
				
					  
					  
				Reservation r = pa.findById(mreservation);
					 f1 = new Facture(date,montant,num,r);
					
				  st.close(); 
			} catch (SQLException e) {
				System.out.println("La requete de recherche de facture n'a pas été exécutée");
			}
			return f1;
			//-----------------------------find_all----------------------
			
}
}