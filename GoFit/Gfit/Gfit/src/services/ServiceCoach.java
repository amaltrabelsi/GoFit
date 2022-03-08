/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Coach;
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
public class ServiceCoach implements IService<Coach>{
    Connection cnx; 

    public ServiceCoach() {
        cnx = MyDB.getInstance().getConnection(); 
    }


    @Override
    public void ajout(Coach t) {
        try {String req = "insert into coach (Nom_Coach , Prenom_Coach, Tel_Portable,Adresse"
                + ",Specialite,Description, Qualification,Region,Fk_ReserC_Id,Compte_Id) values "
               + " ( '" + t.getNom_Coach() + "', '" + t.getPrenom_Coach() + "', '" + t.getTel_Portable() + "', '" + t.getAdresse() + "', '" + t.getSpecialite() + "'"
                + ", '" + t.getDescription() + "', '" + t.getQualification() + "', '" + t.getRegion() + "', '" + t.getFk_ReserC_Id() + "', '" + t.getCompte_Id() + "')" ;
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Coach t) {
 try {
            String req = "update coach set Nom_Coach = ? , Prenom_Coach = ? , Tel_Portable = ?, Adresse = ? ,Specialite = ? ,Qualification = ? , Region = ?  where Coach_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom_Coach());
            ps.setString(2, t.getPrenom_Coach());
            ps.setString(3, t.getTel_Portable());
            ps.setString(4, t.getAdresse()); 
            ps.setString(5, t.getSpecialite());
            ps.setString(6, t.getQualification());
            ps.setString(7, t.getRegion());
            ps.setInt(8 , t.getCoach_Id());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
@Override
      public void supprimer(int Coach_Id) {
        try {
            String req = "delete from Coach where Coach_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Coach_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override 
        public List<Coach> afficher() {
        List<Coach> list = new ArrayList<>();
        try {
            String req ="select * from Coach";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               Coach c = new Coach();
                c.setCoach_Id (rs.getInt("Coach_Id"));
                c.setNom_Coach(rs.getString("Nom_Coach"));
                c.setPrenom_Coach(rs.getString("Prenom_Coach"));
                c.setTel_Portable(rs.getString("Tel_Portable"));
                c.setAdresse(rs.getString("Adresse"));
                c.setSpecialite(rs.getString("Specialite"));
                 c.setDescription(rs.getString("Description"));
                   c.setQualification(rs.getString("Qualification"));
                     c.setRegion(rs.getString("Region"));
                list.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCoach.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
