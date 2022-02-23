/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Panier;
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
public class ServicePanier implements IService<Panier> {
    Connection cnx ;
public ServicePanier(){
    cnx = MyDB.getInstance().getConnection();
}    


    @Override
    public void ajout(Panier P) {
            try {
            String req="INSERT INTO panier(Panier_Id,FK_ProduitP_Id,FK_Client_Id) VALUES (?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
          pst.setInt(1,P.getPanier_Id());

          pst.setInt(2, P.getFK_ProduitP_Id());
          pst.setInt(3, P.getFK_Client_Id());
          pst.executeUpdate();
            System.out.println("panier ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Panier t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int Panier_Id) {
                       try {
            String req = "delete from commande where Panier_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,Panier_Id);
            ps.executeUpdate();
            System.out.println("Panier supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Panier> afficher() {
          List<Panier> list = new ArrayList<>();
 try {
           
            String req="SELECT * FROM panier";
            Statement st = cnx.createStatement();
           ResultSet rs= st.executeQuery(req);
           while(rs.next()){
              Panier  p= new Panier();
               p.setPanier_Id(rs.getInt("Panier_Id"));
                p.setFK_ProduitP_Id(rs.getInt("FK_ProduitP_Id"));
                                p.setFK_Client_Id(rs.getInt("FK_Client_Id"));
            

               list.add(p);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
    }
    
    
}
