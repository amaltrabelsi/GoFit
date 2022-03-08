/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Reclamation;
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
 * @author HP 840 G3
 */
public class ServicesReclamation implements IService<Reclamation>{
    Connection cnx;
  

    public ServicesReclamation() {
        cnx = MyDB.getInstance().getConnection();
    }
    @Override
    public void ajout(Reclamation t) {
        try {
            String req = "insert into Reclamation (Contenu ,mdpgmail ,Categorie,date) values"
                    + " ('" + t.getContenu() + "' ,'" + t.getmdpgmail() + "' ,'" + t.getCategorie() + "','" + t.getDate() + "'  )";
                   Statement st = cnx.createStatement();
                    st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Reclamation t) {
        try {
            String req = "update Reclamation set Contenu = ? , mdpgmail = ? , Categorie =? , date=?   where Reclamation_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getContenu());
            ps.setString(2, t.getmdpgmail());
            ps.setString(3, t.getCategorie());
            ps.setString(4, t.getDate());
            ps.setInt(5, t.getReclamation_Id());
            ps.executeUpdate();
       
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int Reclamation_Id) {
        try {
            String req = "delete from Reclamation where Reclamation_Id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, Reclamation_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reclamation> afficher() {
        List<Reclamation> list = new ArrayList<>();
        try {
            String req ="select * from Reclamation ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
           	      			
            while(rs.next()){
                Reclamation s = new Reclamation();
                s.setReclamation_Id(rs.getInt(1));
                s.setContenu(rs.getString("Contenu"));
                s.setmdpgmail(rs.getString("mdpgmail"));
                s.setCategorie(rs.getString("Categorie"));
                s.setDate(rs.getString("date"));
                list.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}