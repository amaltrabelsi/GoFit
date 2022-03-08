/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Business;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author hp
 */
public class ServiceBusiness implements IService<Business> {
   
    Connection cnx; 

    public ServiceBusiness() {
        cnx = MyDB.getInstance().getConnection(); 
    }
    
    @Override
    public void ajout(Business t) {
        try {String req = "insert into business (Nom_Business, Nom_Gerant, Prenom_Gerant,Region,Adresse,Date_Fondation,Description,Tel_Portable,Tel_Fix,Note Compte_Id "
               +
") values "
               + " ( '" + t.getNom_Business() + "', '" + t.getNom_Gerant() + "','" + t.getPrenom_Gerant() + "', '" + t.getRegion() + "'"
                + ", '" + t.getAdresse() + "', '" + t.getDate_Fondation() + "', '" + t.getDescription() + "', '" + t.getTel_Portable() + "'"
                + ", '" + t.getTel_Fix() + "', '" + t.getCompte_Id() + "' , '" + t.getNote() + "'" ;
        
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void ajoutbusiness(Business t) {
        try {String req = "insert into business (Nom_Business,Nom_Gerant,Prenom_Gerant,Region,Adresse,Date_Fondation,Description,Tel_Portable,Tel_Fix ) values "
               + " ( '" + t.getNom_Business() + "','" + t.getNom_Gerant() + "','" + t.getPrenom_Gerant() + "','" + t.getRegion() + "','"
                + t.getAdresse() + "','" + t.getDate_Fondation() + "','" + t.getDescription() + "','" + t.getTel_Portable() + "','"
                 + t.getTel_Fix() + "')";
        System.out.println(req);
         Statement st = cnx.createStatement();
         System.out.println(st);
            st.executeUpdate(req);
                     System.out.println(st);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void modifier(Business t) {
         try {
            String req = "update business set Nom_Business = ? , Nom_Gerant = ? , Prenom_Gerant = ? ,Region = ? , Adresse = ?"
                    +", Date_Fondation = ? , Description = ? , Tel_Portable = ? , Tel_Fix = ?  where Business_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom_Business());
            ps.setString(2, t.getNom_Gerant());
            ps.setString(3, t.getPrenom_Gerant());
         
             ps.setString(4, t.getRegion());
             ps.setString(5, t.getAdresse()); 
            ps.setDate(6, t.getDate_Fondation());
            ps.setString(7, t.getDescription());
             ps.setString(8, t.getTel_Portable());
             ps.setString(9, t.getTel_Fix());

            ps.setInt(10 , t.getBusiness_Id());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       @Override
       public void supprimer(int Business_Id) {
        try {
            String req = "delete from Business where Business_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Business_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Override 
        public List<Business> afficher() {
        List<Business> list = new ArrayList<>();
        try {
            String req ="select * from  Business";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               Business b = new Business();
                b.setBusiness_Id (rs.getInt("Business_Id"));
                b.setNom_Business(rs.getString("Nom_Business"));
                  b.setNom_Business(rs.getString("Nom_Gerant"));
                b.setPrenom_Gerant(rs.getString("Prenom_Gerant"));
                b.setTel_Portable(rs.getString("Tel_Portable"));
                   b.setTel_Fix(rs.getString("Tel_Fix"));
                  b.setDate_Fondation(rs.getDate("Date_Fondation"));
                b.setAdresse(rs.getString("Adresse"));
                
                 b.setDescription(rs.getString("Description"));
           
                 b.setRegion(rs.getString("Region"));
                       b.setNote(rs.getInt("Note"));
                list.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
