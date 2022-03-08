/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Admin;
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
public class ServiceAdmin implements IService<Admin>{
    Connection cnx; 

    public ServiceAdmin() {
        cnx = MyDB.getInstance().getConnection(); 
    }
    @Override
    public void ajout(Admin t) {
         try {String req = "insert into admin (Nom , Prenom, Tel_Portable,Adresse,Fk_Actualite_Id,Compte_Id) values "
               + " ( '" + t.getNom() + "', '" + t.getPrenom() + "'"
                 + ", '" + t.getTel_Portable() + "', '" + t.getAdresse() + "', '" + t.getFk_Actualite_Id() + "', '" + t.getCompte_Id() + "')" ;
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Admin t) {
 try {
            String req = "update admin set Nomh = ? , Prenom = ? , Tel_Portable = ?, Adresse = ?  where Admin_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setString(3, t.getTel_Portable());
            ps.setString(4, t.getAdresse()); 
          
            ps.setInt(5 , t.getAdmin_Id());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }    }

  
     @Override
       public void supprimer(int Admin_Id) {
        try {
            String req = "delete from Admin where Admin_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Admin_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override 
        public List<Admin> afficher() {
        List<Admin> list = new ArrayList<>();
        try {
            String req ="select * from Admin";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               Admin a = new Admin();
                a.setAdmin_Id (rs.getInt("Admin_Id"));
                a.setNom(rs.getString("Nom"));
                a.setPrenom(rs.getString("Prenom"));
                a.setTel_Portable(rs.getString("Tel_Portable"));
                a.setAdresse(rs.getString("Adresse"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
