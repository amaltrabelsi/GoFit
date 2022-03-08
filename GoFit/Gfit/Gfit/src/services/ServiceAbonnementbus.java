/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Abonnementbus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class ServiceAbonnementbus implements IService<Abonnementbus>{
 Connection cnx ;
public ServiceAbonnementbus(){
    cnx = MyDB.getInstance().getConnection();
}    
    @Override
    public void ajout(Abonnementbus A) {
              try {
            String req="INSERT INTO abonnementbus(AbonnementBus_Id,FK_ClientC_Id,FK_Business_Id) VALUES (?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
          pst.setInt(1,A.getAbonnementBus_Id());

          pst.setInt(2, A.getFK_ClientC_Id());
          pst.setInt(3, A.getFK_Business_Id());
          pst.executeUpdate();
            System.out.println("abonnementbus ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
// pas de modification d'un abonnement
    @Override
    public void modifier(Abonnementbus t) { }

    @Override
    public void supprimer(int AbonnementBus_Id) {
        try {
            String req = "delete from abonnementCoach where AbonnementBus_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, AbonnementBus_Id);
            ps.executeUpdate();
            System.out.println("AbonnementCoach supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Abonnementbus> afficher() {
        List<Abonnementbus> list = new ArrayList<>();
        try {
           
            String req="SELECT * FROM abonnementbus";
            Statement st = cnx.createStatement();
           ResultSet rs= st.executeQuery(req);
           while(rs.next()){
               Abonnementbus A = new Abonnementbus();
               A.setAbonnementBus_Id(rs.getInt("AbonnementBus_Id"));
                A.setFK_ClientC_Id(rs.getInt("FK_ClientC_Id"));
                A.setFK_Business_Id(rs.getInt("FK_Business_Id"));
            

               list.add(A);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
      
    }   
}
