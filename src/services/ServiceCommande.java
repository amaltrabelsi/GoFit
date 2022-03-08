/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Commande;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
import java.util.Random;
/**
 *
 * @author ASUS
 */
public class ServiceCommande implements IService <Commande> {
Connection cnx ;
public ServiceCommande(){
    cnx = MyDB.getInstance().getConnection();
}    // String Date_C, double Total, int Nb_Produit, String Mode_Paiement, int FK_Reg_Id, int FK_Client_Id)



  public String randomstring() {

   
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();

    int length = 7;

    for(int i = 0; i < length; i++) {

      int index = random.nextInt(alphabet.length());

      char randomChar = alphabet.charAt(index);

      sb.append(randomChar);
    }
    String randomString = sb.toString();
    
return randomString;
  }

    @Override
    public void ajout(Commande R) {
              try {
            String req="INSERT INTO commande (Date_C , Total,Nb_Produit, Mode_Paiement, FK_Reg_Id, FK_Client_Id) VALUES (now(),?,?,?,?,?)";
           PreparedStatement pst = cnx.prepareStatement(req);
         
         
            pst.setDouble(1, R.getTotal());
             pst.setInt(2, R.getNb_Produit());
                   pst.setString(3, R.getMode_Paiement());
                   pst.setInt(4, R.getFK_Reg_Id()); 
                   pst.setInt(5, R.getFK_Client_Id());
             


          pst.executeUpdate();
            System.out.println("commande ajoutée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
      
    }

    @Override
    public void modifier(Commande t) {
        try {
          String req = "update commande set   Total = ? , Nb_Produit = ? , Mode_Paiement = ?  where Commande_Id = ?";
          PreparedStatement ps = cnx.prepareStatement(req);
          ps.setDouble(1, t.getTotal());
          ps.setInt(2 , t.getNb_Produit());
          ps.setString(3, t.getMode_Paiement());
          ps.setInt(4, t.getCommande_Id());
            
           
           
            
            
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
                c.setDate_C(rs.getDate("Date_C"));
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

    
       public void passerCommande(Commande R){
        try {
            String req="INSERT INTO commande (Date_C , Total,Nb_Produit, Mode_Paiement, FK_Reg_Id, FK_Client_Id) VALUES (NOW(),?,?,?,?,?)";
             PreparedStatement pst = cnx.prepareStatement(req);
          
            
             pst.setDouble(1, R.getTotal());
             pst.setInt(2, R.getNb_Produit()); 
             pst.setString(3, R.getMode_Paiement());
             pst.setInt(4, R.getFK_Reg_Id()); 
             pst.setInt(5, R.getFK_Client_Id());
             

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("commande joutée avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    
        }
       }
       
}
