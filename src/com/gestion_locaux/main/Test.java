package com.gestion_locaux.main;

import java.sql.Time;
import java.sql.Date;

import com.gestion_locaux.DAO.BatimentDAO;
import com.gestion_locaux.DAO.DemandeurDAO;
import com.gestion_locaux.DAO.EquipementDAO;
import com.gestion_locaux.DAO.FactureDAO;
import com.gestion_locaux.DAO.PlageHoraireDAO;
import com.gestion_locaux.DAO.ReservationDAO;
import com.gestion_locaux.DAO.SalleDAO;
import com.gestion_locaux.metier.Batiment;
import com.gestion_locaux.metier.Demandeur;
import com.gestion_locaux.metier.Equipement;
import com.gestion_locaux.metier.Facture;
import com.gestion_locaux.metier.PlageHoraire;
import com.gestion_locaux.metier.Reservation;
import com.gestion_locaux.metier.Salle;

public class Test {

	public static void main(String[] args) {
		// -------------------batiment---------------

		BatimentDAO bdao = new BatimentDAO();
		Batiment b1 = new Batiment("bat1", 1);
		Batiment b2 = new Batiment("bat2", 2);
		// Batiment b3= new Batiment("bat3",3);

		bdao.save(b1);
		/*System.out.println("*****Sauvegarde/MAJ du Batiment b1");
		/*bdao.save(b2);
		System.out.println("*****Sauvegarde/MAJ du Batiment b2");
		
		 * bdao.save(b3); System.out.println("*****Sauvegarde/MAJ du Batiment b3");
		 * 
		 * if(bdao.findById(1)==null) System.out.println("La Batiment n'existe pas !!");
		 * else System.out.println("La Batiment a pour adresse :"+
		 * bdao.findById(3).getAdresse()+
		 * ", et id : "+bdao.findById(3).getBatimentID()); bdao.delete(3);
		 */

		// --------------demandeur------------

		DemandeurDAO ddao = new DemandeurDAO();
		Demandeur d1 = new Demandeur("ELINE", "BERLIN", 3);
		ddao.save(d1);
		
		Demandeur d3 = new Demandeur("iyed", "BERLIN", 4);
		ddao.save(d3);
		 Demandeur d2= new Demandeur("LILYEN","BERLIN",4); ddao.save(d2);
		 /*
		 * 
		 * if(ddao.findById(1)==null)
		 * System.out.println("Le Demandeur n'existe pas !!"); else
		 * System.out.println("La Demandeur pour code =" +ddao.findById(1).getCode()+
		 * ", nomprenom = "+ddao.findById(1).getNomprenom()+
		 * ", et adresse = "+ddao.findById(1).getAdresse()); //ddao.delete(1);
		 */
		
		  //---------------Equipement-------------------------------
		  
		  
		  EquipementDAO edao= new EquipementDAO();
		  
		Equipement e1= new Equipement(5,"TABLEAU"); edao.save(e1);
		 /*  
		 * Equipement e2= new Equipement(4,"cuisine"); edao.save(e2);
		 * //if(edao.findById(1)==null)
		 * System.out.println("L'Equipement n'existe pas !!"); else
		 * System.out.println("L'Equipement de l'id num= "+edao.findById(1).
		 * getEquipementID()+ " est un = "+edao.findById(1).getEquipement_name());
		 * edao.delete(5);
		 */

		
		
		  //----------------plagehoraire---------------------
		  
		  
		  PlageHoraireDAO pdao= new PlageHoraireDAO();
		  Date date=new Date(2021,01,23);
		  Time td= new Time (8, 15, 00);
		  Time tf= new Time(13, 15, 00);
		  
		  
		  
		  PlageHoraire p1= new PlageHoraire(date,td,tf,5); pdao.save(p1);
		 

		
		  //----------------salle----------------------
		  
		  
		  
		  
		  SalleDAO sdao= new SalleDAO();
		  
		  Salle s1= new Salle(6,2.3f,b1,e1); 
		  Salle s2= new Salle(7,4.3f,b2,e1);
		  sdao.save(s1); //sdao.delete(3);
		  sdao.save(s2);
		  Salle s3= new Salle(8,8.3f,b2,e1);
		  sdao.save(s3);


		 

		
		  //--------------------reservation--------------------------
		  
		  
		  
			
			  ReservationDAO rdao= new ReservationDAO();
			  
			  Reservation r1= new Reservation(2,23f,p1,s1,d1); rdao.save(r1);
			  Reservation r2= new Reservation(3,28f,p1,s3,d2); rdao.save(r2);

			 
		  
		 

		
		  //---------------------------facture--------------------------------------
		  
		  
		  FactureDAO fdao= new FactureDAO();
		  Facture f1= new Facture(date,2.2f,1,r1); fdao.save(f1);
		  Facture f2= new Facture(date,3.2f,2,r2); fdao.save(f2);
		  Facture f3= new Facture(date,2.2f,1,r1); fdao.save(f3);

		 

	}

}
