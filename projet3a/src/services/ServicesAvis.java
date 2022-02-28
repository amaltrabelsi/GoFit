/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entites.Avis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.connexion;
/**
 *
 * @author HP 840 G3
 */
public class ServicesAvis  implements Iservices<Avis>{
    Connection cnx;
  

    public ServicesAvis() {
        cnx = connexion.getInstance().getConnection();
    }
    @Override
    public void ajout(Avis t) {
        try {
            String req = "insert into Avis (Valeur) values ('" + t.getValeur()+ "')";
                   Statement st = cnx.createStatement();
                    st.executeUpdate(req);
                  
               
                     
        } catch (SQLException ex) {
            Logger.getLogger(ServicesAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Avis t) {
        try {
            String req = "update Avis set Valeur = ? where Avis_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getValeur());
            ps.setInt(2, t.getAvis_Id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicesAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int Avis_Id) {
        try {
            String req = "delete from Avis where Avis_Id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, Avis_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Avis> afficher() {
        List<Avis> list = new ArrayList<>();
        try {
            String req ="select * from Avis ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
           	      			
            while(rs.next()){
                Avis s = new Avis();
                s.setAvis_Id(rs.getInt(1));
                s.setValeur(rs.getString("Valeur"));
                list.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicesAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
