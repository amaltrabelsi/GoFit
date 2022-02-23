/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Commande;
import entities.Panier;
import entities.Produit;
import entities.Reglement;
import services.ServiceCommande;
import services.ServicePanier;
import services.ServiceProduit;
import services.ServiceReglement;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class Main {
        public static void main (String[] args) {
        MyDB.getInstance();
       // ServicePanier p= new ServicePanier();
       ServiceProduit sp= new ServiceProduit();
       //sp.ajout(new Produit("658", 45.5, 4,"high","softcore","food",1,1));
       
        
       //ServiceReglement sr= new ServiceReglement();
        ServiceCommande sc= new ServiceCommande ();
    // methode de recherche par id client
       // sr.afficherListClientId(1);
      //  System.out.println("added");
     
    // sc.modifier(new Commande(1,"tawtaw",1.55,1,"1"));
   // sc.passerCommande();
/// p.ajout(new Panier(2,3));
    sp.supprimer(3);
      System.out.println("deleted");
         
  System.out.println(sp.afficher());
      System.out.println("list is shown");
        }
    
}
