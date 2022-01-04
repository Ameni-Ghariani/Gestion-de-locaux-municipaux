package com.gestion_locaux.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gestion_locaux.metier.Equipement;


public class EquipementDAO {
	 
		  public Equipement findById(int eq) { 
				String rq="select * from equipement where EquipementID=?";
				Equipement e1= null;
				Connection cnx= SConnection.getInstance();
				PreparedStatement st;
				try {
					st=cnx.prepareStatement(rq);
					st.setInt(1, eq);
					ResultSet res= st.executeQuery();
					if(res.next())//Il existe un Equipement ayant id 
						e1=new Equipement(res.getInt(1),res.getString(2));
					st.close();
				} catch (SQLException e) {
					System.out.println("La requete1 n'a pas pu �tre ex�cut�e ");
				}
				return e1;
			}
		  
		  //-------------------------------------------------------------------------
		  public void save(Equipement eq) {
				int n=0;
				String rq1="update equipement set equipement_name=? where EquipementID=?";
				Connection cnx= SConnection.getInstance();
				PreparedStatement st;
				try {
					st=cnx.prepareStatement(rq1);
					st.setInt(1,eq.getEquipementID());
					st.setString(2,eq.getEquipement_name());

					
					n= st.executeUpdate();//n: nbre de lignes modifi�es
					st.close();
					if(n==1) {
						System.out.println("Mise � jour de l'Equipement avec succ�s ");
					}
				} catch (SQLException e) {
					System.out.println("equippement d�j� dans la bd ");
				}
				if(n==0)//l'Equipement eq n'existe pas ds la table Equipement de la BD
					    //je vais l'ins�rer
					{try {
					String rq2="insert into equipement(EquipementID,equipement_name) values (?,?)";
					st=cnx.prepareStatement(rq2);			
					st.setInt(1,eq.getEquipementID());
					st.setString(2,eq.getEquipement_name());

					n= st.executeUpdate();
					System.out.println("Ajout de l'Equipement avec succ�s ");
					st.close();
					} catch (SQLException e) {
						System.out.println("cet equipementest est d�j� ajout�e ");
					}
					}
			}
         //--------------------------------------------------------------------------
		  public void delete(int eq) {//eq: l' id de l'Equipement
				int n=0;
				String rq="DELETE from equipement where EquipementID=?";
				Connection cnx= SConnection.getInstance();
				PreparedStatement st;
				try {
					st=cnx.prepareStatement(rq);
					st.setInt(1, eq);
					n= st.executeUpdate();
					if(n==1)
						System.out.println("l'Equipement a �t� archiv� avec succ�s ");
					else //n=0
						System.out.println("Aucun Equipement n'a �t� archiv�  ");
					st.close();
				}catch(SQLException e) {
					System.out.println("La requete delete n'a pas �t� ex�cut�e");
				}
		}

		}