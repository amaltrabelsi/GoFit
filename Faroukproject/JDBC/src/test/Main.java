/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import entities.service ;
import entities.reservation;
import java.sql.Date;
import services.ServiceReservation;
import services.ServiceServices;
import utils.MyDB;
import GUI.ReservationController;



/**
 *
 * @author farouk
 */
public class Main {
    
    public static void main(String[] args) {
        MyDB.getInstance();
        ServiceReservation sr = new ServiceReservation();
      
        //System.out.println(sr.afficher());
       
        
       //sr.ajout(new reservation(new Date(-1900+2020,+1+2,20),new Date(-1900+2020,+1+2,20), "Duree", "Infos_Supp"));
     //  sr.modifier(new reservation(3, new Date(-1900+2020,+1+2,20),new Date(-1900+2020,+1+2,20), "farouk", "yh"));
        //sr.supprimer();
        //  System.out.println(sr.afficher());
       ServiceServices S= new ServiceServices();
        // S.ajout(new service ("yy","oo","pp","mmm","nnn","mm","ppp"));
         // S.modifier(new service (2, "yy","oo","pp","mmm","nnn","mm","farouk "));
       //  S.supprimer(2);
         //  System.out.println(S.afficher());
          
     }
    
}
