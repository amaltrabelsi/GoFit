/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Client;
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
public class ServiceClient implements IService<Client> {
    Connection cnx; 

    public ServiceClient() {
        cnx = MyDB.getInstance().getConnection(); 
    }

    @Override
    public void ajout(Client t) {
  try {String req = "insert into client (Nom_Client , Prenom_Client,Region,Adresse, Date_Naiss, Tel_Portable, Fk_Historique_Id , Fk_Reservation_Id, Fk_Commentaire_Id , Fk_Avis_Id , Fk_AvisCovid_Id, Compte_Id) values "
               + " ( '" + t.getNom_Client() + "', '" + t.getPrenom_Client() + "', '" + t.getRegion() + "' "
          + ", '" + t.getAdresse() + "' , '" + t.getDate_Naiss() + "','" + t.getTel_Portable() + "', '" + t.getFk_Historique_Id() + "', '" + t.getFk_Reservation_Id() + "'"
                + ", '" + t.getFk_Commentaire_Id() + "', '" + t.getFk_Avis_Id() + "', '" + t.getFk_AvisCovid_Id()+ "', '" + t.getCompte_Id() + "')" ;
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void modifier(Client t) {
 try {
            String req = "update client set Nom_Client = ? , Prenom_Client = ? , Region = ? , Adresse = ? , Date_Naiss = ?, Tel_Portable = ?  where Client_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom_Client());
            ps.setString(2, t.getPrenom_Client());
            ps.setString(3, t.getRegion());
            ps.setString(4, t.getAdresse()); 
            ps.setDate(5, t.getDate_Naiss());
            ps.setString(6, t.getTel_Portable());
       ;
            ps.setInt(7 , t.getClient_Id());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }    }

   
   @Override
       public void supprimer(int Client_Id) {
        try {
            String req = "delete from Client where Client_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Client_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
 
        public List<Client> afficher() {
        List<Client> list = new ArrayList<>();
        try {
            String req ="select * from  Client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
              Client c = new Client();
                c.setClient_Id (rs.getInt("Client_Id"));
                c.setNom_Client(rs.getString("Nom_Client"));
                c.setPrenom_Client(rs.getString("Prenom_Client"));
                c.setTel_Portable(rs.getString("Tel_Portable"));
                c.setDate_Naiss(rs.getDate("Date_Naiss"));
                c.setAdresse(rs.getString("Adresse"));
                
           
                 c.setRegion(rs.getString("Region"));
                list.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
        public List<Client> afficheranniversaire() {
              List<Client> list2 = new ArrayList<>();
        try {
              String req = "SELECT client_Id , emailClient , date_naiss FROM client WHERE MONTH(date_naiss) = MONTH(NOW()) AND DAY(date_naiss) = DAY(NOW())";
             Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
              Client c = new Client();
              c.setClient_Id(rs.getInt("Client_Id"));
            c.setDate_Naiss(rs.getDate("date_naiss"));
             c.setEmailClient(rs.getString("emailClient"));
              list2.add(c);
            }
        }    
        catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list2;
      

}
}