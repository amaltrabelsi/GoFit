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
            String req="INSERT INTO produit (Ref_P, Prix_Uni, Quantite, Description, Nom_Produit, Categorie, Path_Image, Fk_AvisP_Id, Fk_CommentaireP_Id) VALUES (?,?,?,?,?,?,?,1,1)";
           PreparedStatement pst = cnx.prepareStatement(req);
         
           pst.setString(1, P.getRef_P());
            pst.setDouble(2, P.getPrix_Uni());
             pst.setInt(3, P.getQuantite());
                   pst.setString(4, P.getDescription());
                   pst.setString(5, P.getNom_Produit()); 
                   pst.setString(6, P.getCategorie()); 
                   pst.setString(7, P.getPath_Image()); 

             


          pst.executeUpdate();
            System.out.println("Produit ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Produit P) {
                try {
            String req = "update produit set Ref_P = ?, Prix_Uni = ?, Quantite = ?, Description = ?, Nom_Produit =?, Categorie=?, Fk_AvisP_Id =?, Fk_CommentaireP_Id =? where Produit_Id = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
                    
                   pst.setString(1, P.getRef_P());
                                       System.out.println("robleme ici");

                   pst.setDouble(2, P.getPrix_Uni());
                                       System.out.println("robleme ici");

                   pst.setInt(3, P.getQuantite());
                   pst.setString(4, P.getDescription());
                   pst.setString(5, P.getNom_Produit()); 
                   pst.setString(6, P.getCategorie()); 
               pst.setInt(7, P.getFk_AvisP_Id());
                pst.setInt(8, P.getFk_CommentaireP_Id());

                   pst.setInt(9, P.getProduit_Id());
                   
                                System.out.println(pst);

            pst.executeUpdate();
                                System.out.println("i");

          
            
        } catch (SQLException ex) {
            System.out.println("erreur service");
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
     public void modifierocc (Produit P ) {
               try {
            String req = "update produit set  Note = ? , totalnote = ? , occurence = ? where Produit_Id = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
            System.out.println(req);
           
            pst.setInt(1, P.getNote());
            pst.setInt(2, P.getTotalnote());
            pst.setInt(3, P.getOccurence());
            pst.setInt(4, P.getProduit_Id());
            System.out.println(pst);

            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void supprimerProduit (int Produit_Id) {
         try {
            String req = "delete from produit where Produit_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Produit_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
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
                 p.setPath_Image(rs.getString("Path_Image"));
                p.setFk_AvisP_Id(rs.getInt("Fk_AvisP_Id"));
                p.setFk_CommentaireP_Id(rs.getInt("Fk_CommentaireP_Id"));
            
                list.add(p);
            }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;  
        
    }
    
      public List<Produit>  rechercherparnom(String nom_produit){
        ArrayList<Produit> list1 =new ArrayList<>();
        try{                                                                
            String req ="select * from produit where Nom_Produit = '"+nom_produit+"'";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
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
                 p.setPath_Image(rs.getString("Path_Image"));
                p.setFk_AvisP_Id(rs.getInt("Fk_AvisP_Id"));
                p.setFk_CommentaireP_Id(rs.getInt("Fk_CommentaireP_Id"));
            
                list1.add(p);
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list1;
    }
      
      
      public List<Produit> afficherProduitbyBusinessId(int businessid) {
        List<Produit> list = new ArrayList <> ();
           try {
        //Ref_P, Prix_Uni, Quantite, Description, Nom_Produit, Categorie, Fk_AvisP_Id, Fk_CommentaireP_Id
        String req ="SELECT * FROM  `produit` join `business`  WHERE business.Business_Id="+businessid+" ";
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
                 p.setPath_Image(rs.getString("Path_Image"));
                p.setFk_AvisP_Id(rs.getInt("Fk_AvisP_Id"));
                p.setFk_CommentaireP_Id(rs.getInt("Fk_CommentaireP_Id"));
              
                list.add(p);
            }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;  
        
    }
      public Produit retrieveProduit(int produit_id) {
        Produit pointdevente = null;

        String req="SELECT * FROM produit WHERE Produit_Id = "+produit_id+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if(rs.next()){
                pointdevente = new Produit(rs.getInt("produit_id")
                        ,rs.getInt("Note")
                        ,rs.getInt("totalnote"),
                         rs.getInt("occurence"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return pointdevente;
    } 
    
}
