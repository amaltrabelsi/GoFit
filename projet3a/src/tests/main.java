/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import java.sql.Date;
import entites.Avis ;
import entites.Reclamation ;
import services.ServicesAvis ;
import services.ServicesReclamation ;
/**
 *
 * @author HP 840 G3
 */
public class main {
    
    public static void main(String[] args) {
       ServicesReclamation r =  new ServicesReclamation () ;
       r.ajout( new Reclamation("zsertyui"));
     
    }
}
