/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Actualite;
import entities.Admin;
import entities.Business;
import entities.Client;
import entities.Coach;
import entities.Commentaire;
import java.sql.Date;
import services.ServiceBusiness;
import services.ServiceClient;
import services.ServiceCommentaire;
import utils.MyDB;
import java.sql.Date;
import services.ServiceActualite;
import services.ServiceAdmin;
import services.ServiceCoach;

/**
 *
 * @author hp
 */
public class Main {
    public static void main  (String [] args){
       MyDB.getInstance();
      
    
       ServiceActualite sc = new ServiceActualite();
         ServiceBusiness sb = new ServiceBusiness();
        System.out.println("test base");
      sc.ajout(new Actualite("one","one","one"));
     System.out.println("test ajout");
     sc.modifier(new Actualite(3 , "modifier", "modifier" , "modifier"));
        System.out.println(sc.afficher());
       System.out.println("added");
       //new Date (-1900+2021,1+9,22)
       sb.ajout(new Business("pidev","","","","",new Date (-1900+2021,1+9,22),"","",""));
       
      
    }

    
}
