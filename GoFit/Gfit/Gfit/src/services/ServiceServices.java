
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.service;
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
 * @author farouk
 */
public class ServiceServices implements IService<service> {

    Connection cnx;

    public ServiceServices() {
        cnx = MyDB.getInstance().getConnection();
    }

   @Override
    public void ajout(service r) {
        try {
            String req = "insert into service (Ref_S,Type_S,Nom_Service,Description,Disponibilite,Horaire,Categorie) values"
                    + "('" + r.getRef_S() + "', '" + r.getType_S()+ "','" + r.getNom_Service() + "','" + r.getDescription() + "','"+ r.getDisponibilite() + "','"+ r.getHoraire() + "','"+ r.getCategorie()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
    
        } catch (SQLException ex) {
         
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(service r) {
        try {
            String req = "update service set  Ref_S=? ,Type_S=? ,Nom_Service=? ,Description=? ,Disponibilite=? ,Horaire=? ,Categorie =? where Service_Id  = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, r.getRef_S());
            ps.setString(2, r.getType_S());
            ps.setString(3, r.getNom_Service());
            ps.setString(4, r.getDescription());
            ps.setString(5, r.getDisponibilite());
            ps.setString(6, r.getHoraire());
            ps.setString(7, r.getCategorie());
            ps.setInt(8, r.getService_Id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from service where Service_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<service> afficher() {
        List<service> list = new ArrayList<>();
        try {
            String req ="select * from service ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
       
            while(rs.next()){
                service p = new service();
                p.setService_Id(rs.getInt(1));
                p.setRef_S(rs.getString(" Ref_S"));
                p.setType_S(rs.getString("Type_S"));
                p.setNom_Service(rs.getString("Nom_Service"));
                p.setDescription(rs.getString("Description"));
                p.setHoraire(rs.getString(" Horaire"));
                p.setCategorie(rs.getString("Categorie   "));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


}