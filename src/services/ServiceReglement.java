/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reglement;
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
public class ServiceReglement implements IService<Reglement>{
Connection cnx ;
public ServiceReglement(){
    cnx = MyDB.getInstance().getConnection();
}    


    @Override
    public List<Reglement> afficher() {
        List<Reglement> list = new ArrayList<>();
        try {
           
            String req="SELECT * FROM reglement";
            Statement st = cnx.createStatement();
           ResultSet rs= st.executeQuery(req);
           while(rs.next()){
               Reglement r = new Reglement();
               r.setReglement_Id(rs.getInt("Reglement_Id"));
                r.setCode(rs.getInt("code"));
            

               list.add(r);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
    }
// list des reglemnt par client
    public List<Reglement> afficherListClientId(int Client_Id) {
        List<Reglement> list = new ArrayList<>();
        try {
           
            String req="SELECT * FROM reglement WHERE `code` = '" + Client_Id + "'";


            PreparedStatement ps = cnx.prepareStatement(req);
                 
            Statement st = cnx.createStatement();


           ResultSet rs= st.executeQuery(req);
           while(rs.next()){
               Reglement r = new Reglement();
               r.setReglement_Id(rs.getInt("Reglement_Id"));
                r.setCode(rs.getInt("code"));
            

               list.add(r);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
    }

    @Override
    public void ajout(Reglement R) {
      try {
            String req="INSERT INTO reglement(Reglement_Id,code) VALUES (?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
          pst.setInt(1,R.getReglement_Id());

          pst.setInt(2, R.getCode());
          pst.executeUpdate();
            System.out.println("reglement ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 //we dont have modify
    @Override
    public void modifier(Reglement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   // reglement does not have a delete option i shoudnt implement it

    @Override
    public void supprimer(int Reglement_Id) {
                try {
            String req = "delete from commande where Commande_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Reglement_Id);
            ps.executeUpdate();
            System.out.println("reglement supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
