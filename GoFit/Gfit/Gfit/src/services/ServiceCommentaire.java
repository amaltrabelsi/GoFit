/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commentaire;
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
public class ServiceCommentaire implements IService<Commentaire> {
    
  Connection cnx; 

    public ServiceCommentaire() {
        cnx = MyDB.getInstance().getConnection(); 
    }
    
 
    @Override
   public void ajout(Commentaire t) {
        try {String req = "insert into commentaire (Titre, Contenu,Date_Comm) values "
               + " ( '" + t.getTitre() + "', '" + t.getContenu() + "' , '" + t.getDate_Comm() + "')" ;
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Override
       public void supprimer(int Commentaire_Id) {
        try {
            String req = "delete from Commentaire where Commentaire_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Commentaire_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    @Override
    public void modifier(Commentaire t) {
 try {
            String req = "update commentaire set Titre = ? , Contenu = ? , Date_Comm = ? where Commentaire_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getContenu());
            ps.setDate(3, t.getDate_Comm());
            ps.setInt(4 , t.getCommentaire_Id());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }       }
  
   @Override 
        public List<Commentaire> afficher() {
        List<Commentaire> list = new ArrayList<>();
        try {
            String req ="select * from Commentaire";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Commentaire c = new Commentaire();
                c.setCommentaire_Id (rs.getInt("Commentaire_Id"));
                c.setTitre(rs.getString("Titre"));
                c.setContenu(rs.getString("Contenu"));
                c.setDate_Comm(rs.getDate("Date_Comm"));
                list.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
    