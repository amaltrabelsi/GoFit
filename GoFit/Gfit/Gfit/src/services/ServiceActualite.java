/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Actualite;
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
public class ServiceActualite implements IService<Actualite>{
    Connection cnx; 

    public ServiceActualite() {
        cnx = MyDB.getInstance().getConnection(); 
    }
public List<Actualite>  rechercherparnom(String title){
        ArrayList<Actualite> list1 =new ArrayList<>();
        try{
            String req ="select * from actualite where Titre = '"+title+"'";
            System.out.println(req);
                Statement st = cnx.createStatement();
                            System.out.println(st);
            ResultSet rs =st.executeQuery(req);
            while(rs.next()){
              Actualite E =new Actualite();
             //   E.setActualite_Id(rs.getInt("Actualite_Id "));
                E.setDescription(rs.getString("Description"));
                E.setContenu(rs.getString("Contenu"));
                E.setCategorie(rs.getString("Categorie"));
                E.setTitre(rs.getString("Titre"));
                
                
       list1.add(E);
    }
            } catch (SQLException ex) {
        Logger.getLogger(ServiceActualite.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list1;
    }
    @Override
    public void ajout(Actualite t) {
  try {String req = "insert into actualite (Titre , Description, Contenu,Categorie) values "
               + " ( '" + t.getTitre() + "', '" + t.getDescription() + "', '" + t.getContenu() + "', '" + t.getCategorie() + "')" ;
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceActualite.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void modifier(Actualite t) {
 try {
            String req = "update actualite set Titre = ? , Description = ? , Contenu = ?  where Actualite_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getContenu());
           
            ps.setInt(4 , t.getActualite_Id());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceActualite.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
       public void supprimer(int Actualite_Id) {
        try {
            String req = "delete from Actualite where Actualite_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Actualite_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceActualite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    @Override
          public List<Actualite> afficher() {
        List<Actualite> list = new ArrayList<>();
        try {
            String req ="select * from Actualite";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               Actualite a = new Actualite();
                a.setActualite_Id (rs.getInt("Actualite_Id"));
                a.setTitre(rs.getString("Titre"));
                a.setDescription(rs.getString("Description"));
                a.setContenu(rs.getString("Contenu"));
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceActualite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
            public List<Actualite> afficherListView() {
        List<Actualite> list = new ArrayList<>();
        try {
            String req ="select * from Actualite";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               Actualite a = new Actualite();
               
                a.setTitre(rs.getString("Titre"));
                a.setDescription(rs.getString("Description"));
             
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceActualite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
