/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Commande;
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
 * @author ASUS
 */
public class ServiceCommande implements IService <Commande> {
Connection cnx ;
public ServiceCommande(){
    cnx = MyDB.getInstance().getConnection();
}    // String Date_C, double Total, int Nb_Produit, String Mode_Paiement, int FK_Reg_Id, int FK_Panier_Id)

    @Override
    public void ajout(Commande R) {
              try {
            String req="INSERT INTO commande (Date_C , Total,Nb_Produit, Mode_Paiement, FK_Reg_Id, FK_Panier_Id) VALUES (?,?,?,?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
         
           pst.setString(1, R.getDate_C());
            pst.setDouble(2, R.getTotal());
             pst.setInt(3, R.getNb_Produit());
                   pst.setString(4, R.getMode_Paiement());
                   pst.setInt(5, R.getFK_Reg_Id()); 
                   pst.setInt(6, R.getFK_Panier_Id());
             


          pst.executeUpdate();
            System.out.println("commande ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
      
    }

    @Override
    public void modifier(Commande t) {
        try {
            String req = "update commande set Date_C = ? , Total = ? , Nb_Produit = ? , Mode_Paiement = ?  where Commande_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getDate_C());
            ps.setDouble(2, t.getTotal());
            ps.setInt(3 , t.getNb_Produit());
            ps.setString(4, t.getMode_Paiement());
           ps.setInt(5, t.getCommande_Id());
            
           
           
            
            
            ps.executeUpdate();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }




    @Override
    public void supprimer(int Commande_Id) {
                try {
            String req = "delete from commande where Commande_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Commande_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Commande> afficher() {
        List<Commande> list = new ArrayList<>();
    try {
        
        String req ="select * from commande";
        Statement st= cnx.createStatement();
        ResultSet rs=st.executeQuery(req);

        while(rs.next()){
                Commande c = new Commande();
                c.setCommande_Id (rs.getInt("Commande_Id"));
                c.setDate_C(rs.getString("Date_C"));
                c.setTotal(rs.getDouble("Total"));
                c.setNb_Produit(rs.getInt("Nb_Produit"));
                c.setMode_Paiement(rs.getString("Mode_Paiement"));
                list.add(c);
            }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
       
   }
    
       public void passerCommande(){
        try {
            String requete="INSERT INTO commande (Date_C , Total,Nb_Produit, Mode_Paiement, FK_Reg_Id, FK_Panier_Id) VALUES (NOW(),10.15,1,'cash',1,1)";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("commande joutée avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    
        }
       }
       
}
