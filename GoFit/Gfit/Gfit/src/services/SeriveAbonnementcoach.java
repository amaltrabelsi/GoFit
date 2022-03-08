/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
//SELECT * FROM `abonnementcoach` WHERE Fk_Client_Id=2

import entities.Abonnementcoach;
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
public class SeriveAbonnementcoach implements IService<Abonnementcoach>{
Connection cnx ;
public SeriveAbonnementcoach(){
    cnx = MyDB.getInstance().getConnection();
}    
    @Override
    public void ajout(Abonnementcoach A) {
              try {
            String req="INSERT INTO abonnementcoach(AbonnementCoach_Id,FK_Client_Id,FK_Coach_Id) VALUES (?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
          pst.setInt(1,A.getAbonnementCoach_Id());

          pst.setInt(2, A.getFK_Client_Id());
          pst.setInt(3, A.getFK_Coach_Id());
          pst.executeUpdate();
            System.out.println("abonnementcoach ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
// pas de modification d'un abonnement
    @Override
    public void modifier(Abonnementcoach t) { }

    @Override
    public void supprimer(int AbonnementCoach_Id) {
        try {
            String req = "delete from abonnementCoach where AbonnementCoach_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, AbonnementCoach_Id);
            ps.executeUpdate();
            System.out.println("AbonnementCoach supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Abonnementcoach> afficher() {
        List<Abonnementcoach> list = new ArrayList<>();
        try {
           
            String req="SELECT * FROM abonnementcoach";
            Statement st = cnx.createStatement();
           ResultSet rs= st.executeQuery(req);
           while(rs.next()){
               Abonnementcoach A = new Abonnementcoach();
               A.setAbonnementCoach_Id(rs.getInt("AbonnementCoach_Id"));
                A.setFK_Client_Id(rs.getInt("FK_Client_Id"));
                A.setFK_Coach_Id(rs.getInt("FK_Coach_Id"));
            

               list.add(A);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
      
    }
    
}
