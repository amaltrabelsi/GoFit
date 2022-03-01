/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reservation;
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
public class ServiceReservation implements IService<reservation> {

    Connection cnx;

    public ServiceReservation() {
        cnx = MyDB.getInstance().getConnection();
    }

   @Override
    public void ajout(reservation r) {
        try {
            String req = "insert into reservation (Date_Debut,Date_Fin,Duree,Infos_Supp) values"
                    + "('" + r.getDate_Debut() + "', '" + r.getDate_Fin() + "','" + r.getDuree() + "','" + r.getInfos_Supp()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
    
        } catch (SQLException ex) {
         
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(reservation r) {
        try {
            String req = "update reservation set  Duree = ? ,Date_Debut = ? , Date_Fin = ? , Infos_Supp = ? where Reservation_Id  = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, r.getDuree());
            ps.setDate(2, r.getDate_Debut());
            ps.setDate(3, r.getDate_Fin());
             ps.setString(4, r.getInfos_Supp());
            ps.setInt(5, r.getReservation_Id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from reservation where Reservation_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<reservation> afficher() {
        List<reservation> list = new ArrayList<>();
        try {
            String req ="select * from Reservation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                reservation p = new reservation();
                p.setReservation_Id(rs.getInt(1));
                p.setDate_Debut(rs.getDate("Date_Debut"));
                p.setDate_Fin(rs.getDate("Date_Fin"));
                p.setDuree(rs.getString("Duree"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
