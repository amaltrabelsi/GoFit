/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Panier;
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
public class ServicePanier implements IService<Panier> {
    Connection cnx ;
    private long total;
public ServicePanier(){
    cnx = MyDB.getInstance().getConnection();
}    


    @Override
    public void ajout(Panier P) {
        //madame nour we do not need this method at all.we need to figure out how to create a code for cart when we create a client <3
            try {
            String req="INSERT INTO panier(Code_Panier,FK_ProduitP_Id,FK_Client_Id) VALUES (?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
           pst.setInt(1,P.getFK_Client_Id()); 
           pst.setInt(2, P.getCode_Panier());
           pst.setInt(3, P.getFK_ProduitP_Id());

          pst.executeUpdate();
            System.out.println("panier ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
     
        }
    }
    
    
    //impossible to change my guy

    @Override
    public void modifier(Panier t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    

    
    
    
    
    @Override
    public List<Panier> afficher() {
          List<Panier> list = new ArrayList<>();
 try {

     
            String req="SELECT  PanierAjout_Id, Code_Panier, FK_Client_Id,Fk_ProduitP_Id, Nom_Produit, Prix_Uni, Ref_P FROM panier join produit";
            Statement st = cnx.createStatement();
           ResultSet rs= st.executeQuery(req); 
           while(rs.next()){
              Panier  p= new Panier();
              p.setPanierAjout_Id(rs.getInt("PanierAjout_Id"));
              p.setCode_Panier(rs.getInt("Code_Panier"));
              p.setFK_Client_Id(rs.getInt("FK_Client_Id"));
              p.setFK_ProduitP_Id(rs.getInt("Fk_ProduitP_Id"));
              p.setNom_Produit(rs.getString("Nom_Produit"));
              p.setPrix_Uni(rs.getInt("Prix_Uni"));
              p.setRef_P(rs.getString("Ref_P"));
              
             
           
          
           
            

               list.add(p);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
    }
    
    
    
    
    //afficher la liste des produits appartenant à un client 
    
     public List<Panier> afficherPanierParClient(int Client_Id) {
          List<Panier> list = new ArrayList<>();
 try {
     



            String req="SELECT PanierAjout_Id, Code_Panier, FK_Client_Id,Fk_ProduitP_Id, Nom_Produit, Prix_Uni, Ref_P FROM panier JOIN produit ON panier.Fk_ProduitP_Id=produit.Produit_Id WHERE `FK_Client_Id` =" +Client_Id + "";
            Statement st = cnx.createStatement();
            
             

           ResultSet rs= st.executeQuery(req); 
           while(rs.next()){
              Panier  p= new Panier();
               
    p.setPanierAjout_Id(rs.getInt("PanierAjout_Id"));
              p.setCode_Panier(rs.getInt("Code_Panier"));
              p.setFK_Client_Id(rs.getInt("FK_Client_Id"));
              p.setFK_ProduitP_Id(rs.getInt("Fk_ProduitP_Id"));
              p.setNom_Produit(rs.getString("Nom_Produit"));
              p.setPrix_Uni(rs.getDouble("Prix_Uni"));
              p.setRef_P(rs.getString("Ref_P"));
            

               list.add(p);
           }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return  list;  
     
  }
     
     
     //vider 
        public void ViderPanierParCodePanier(int Code) {
                       try {
            String req = "delete from panier where Code_Panier = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,Code);
            ps.executeUpdate();
            System.out.println("les produits du panier sont supprimés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
            public void ViderPanierParClientId (int Client_Id) {
                       try {
            String req = "delete from panier where FK_Client_Id ='"+Client_Id+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.executeUpdate();
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
            
       public Double calculerTotalParIdClient(int FK_Client_Id) {
                    
            String req = "SELECT SUM(produit.Prix_Uni) AS prix_total FROM panier join produit ON panier.Fk_ProduitP_Id=produit.Produit_Id  WHERE FK_Client_Id= '"+ FK_Client_Id+"'";
            PreparedStatement ps;
            double total=0;
        try { 
            ps = cnx.prepareStatement(req);
            ResultSet rs= ps.executeQuery(req);
            rs.next();
            total=rs.getDouble(1);
           
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
       }       

    @Override
    public void supprimer(int id) {
                              try {
            String req = "delete from panier where PanierAjout_Id ='"+id+"'";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.executeUpdate();
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
