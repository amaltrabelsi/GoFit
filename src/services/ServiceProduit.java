/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Produit;
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
public class ServiceProduit implements IService <Produit> {
    Connection cnx ; 
    public ServiceProduit (){
          cnx = MyDB.getInstance().getConnection();
    }
    

    @Override
    public void ajout(Produit P) {
                      try {
            String req="INSERT INTO produit (Ref_P, Prix_Uni, Quantite, Description, Nom_Produit, Categorie, Fk_AvisP_Id, Fk_CommentaireP_Id) VALUES (?,?,?,?,?,?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
         
           pst.setString(1, P.getRef_P());
            pst.setDouble(2, P.getPrix_Uni());
             pst.setInt(3, P.getQuantite());
                   pst.setString(4, P.getDescription());
                   pst.setString(5, P.getNom_Produit()); 
                   pst.setString(6, P.getCategorie()); 
                   
                   pst.setInt(7, P.getFk_AvisP_Id());
                   pst.setInt(8, P.getFk_CommentaireP_Id());
             


          pst.executeUpdate();
            System.out.println("Produit ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Produit P) {
                try {
            String req = "update commande set Ref_P = ? , Prix_Uni = ? , Quantite = ? , Description = ? ,Nom_Produit =? ,Categorie=? where Commande_Id = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, P.getRef_P());
            pst.setDouble(2, P.getPrix_Uni());
             pst.setInt(3, P.getQuantite());
                   pst.setString(4, P.getDescription());
                   pst.setString(5, P.getNom_Produit()); 
                   pst.setString(6, P.getCategorie()); 
                   pst.setInt(7, P.getProduit_Id());
            
            pst.executeUpdate();
          
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void supprimerProduit (int Produit_Id) {
         try {
            String req = "delete from produit where Produit_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Produit_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    @Override
    public void supprimer(int Produit_Id) {
                    try {
            String req = "delete from produit where Produit_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Produit_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public List<Produit> afficher() {
        List<Produit> list = new ArrayList <> ();
           try {
        //Ref_P, Prix_Uni, Quantite, Description, Nom_Produit, Categorie, Fk_AvisP_Id, Fk_CommentaireP_Id
        String req ="select * from produit";
        Statement st= cnx.createStatement();
        ResultSet rs=st.executeQuery(req);

        while(rs.next()){
                Produit p = new Produit();
                p.setProduit_Id (rs.getInt("Produit_Id"));
                p.setRef_P(rs.getString("Ref_P"));
                p.setPrix_Uni(rs.getDouble("Prix_Uni"));
                p.setQuantite (rs.getInt("Quantite"));
                p.setDescription(rs.getString("Description"));
                p.setNom_Produit(rs.getString("Nom_Produit"));
                p.setCategorie(rs.getString("Categorie"));
                p.setDescription(rs.getString("Description"));
                p.setFk_AvisP_Id(rs.getInt("Fk_AvisP_Id"));
                p.setFk_CommentaireP_Id(rs.getInt("Fk_CommentaireP_Id"));
            
                list.add(p);
            }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;  
        
    }
    
  
    
}
