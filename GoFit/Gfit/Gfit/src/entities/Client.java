/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class Client {
    
    
   
 private int   Client_Id;
 private String  Nom_Client	;
 private String Prenom_Client;	
 private String Region;	
 private String Adresse;	
 private Date Date_Naiss	;
 private String Tel_Portable;
 private String emailClient;
 private int Fk_Historique_Id	;
 private int Fk_Reservation_Id	;
 private int Fk_Commentaire_Id	;
 private int Fk_Avis_Id;
 private int Fk_AvisCovid_Id;

 private int Compte_Id;
 
 public Client() {}
    public Client(String Nom_Client, String Prenom_Client, String Region, String Adresse, Date Date_Naiss, String Tel_Portable, int Fk_Historique_Id, int Fk_Commentaire_Id, int Fk_Avis_Id, int Fk_AvisCovid_Id, int Compte_Id) {
        this.Nom_Client = Nom_Client;
        this.Prenom_Client = Prenom_Client;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Naiss = Date_Naiss;
        this.Tel_Portable = Tel_Portable;
        this.Fk_Historique_Id = Fk_Historique_Id;
        this.Fk_Commentaire_Id = Fk_Commentaire_Id;
        this.Fk_Avis_Id = Fk_Avis_Id;
        this.Fk_AvisCovid_Id = Fk_AvisCovid_Id;
   
        this.Compte_Id = Compte_Id;
    }

    public Client(String Nom_Client, String Prenom_Client, String Region, String Adresse, Date Date_Naiss, String Tel_Portable, String emailClient) {
        this.Nom_Client = Nom_Client;
        this.Prenom_Client = Prenom_Client;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Naiss = Date_Naiss;
        this.Tel_Portable = Tel_Portable;
        this.emailClient = emailClient;
    }

    public Client(int Client_Id, String Nom_Client, String Prenom_Client, String Region, String Adresse, Date Date_Naiss, String Tel_Portable, String emailClient, int Fk_Historique_Id) {
        this.Client_Id = Client_Id;
        this.Nom_Client = Nom_Client;
        this.Prenom_Client = Prenom_Client;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Naiss = Date_Naiss;
        this.Tel_Portable = Tel_Portable;
        this.emailClient = emailClient;
        this.Fk_Historique_Id = Fk_Historique_Id;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public Client(String Nom_Client, String Prenom_Client, String Region, String Adresse, Date Date_Naiss, String Tel_Portable) {
        this.Nom_Client = Nom_Client;
        this.Prenom_Client = Prenom_Client;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Naiss = Date_Naiss;
        this.Tel_Portable = Tel_Portable;
    }

    public Client(int Client_Id, String Nom_Client, String Prenom_Client, String Region, String Adresse, Date Date_Naiss, String Tel_Portable) {
        this.Client_Id = Client_Id;
        this.Nom_Client = Nom_Client;
        this.Prenom_Client = Prenom_Client;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Naiss = Date_Naiss;
        this.Tel_Portable = Tel_Portable;
    }

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int Client_Id) {
        this.Client_Id = Client_Id;
    }

    public String getNom_Client() {
        return Nom_Client;
    }

    public void setNom_Client(String Nom_Client) {
        this.Nom_Client = Nom_Client;
    }

    public String getPrenom_Client() {
        return Prenom_Client;
    }

    public void setPrenom_Client(String Prenom_Client) {
        this.Prenom_Client = Prenom_Client;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public Date getDate_Naiss() {
        return Date_Naiss;
    }

    public void setDate_Naiss(Date Date_Naiss) {
        this.Date_Naiss = Date_Naiss;
    }

    public String getTel_Portable() {
        return Tel_Portable;
    }

    public void setTel_Portable(String Tel_Portable) {
        this.Tel_Portable = Tel_Portable;
    }

    public int getFk_Historique_Id() {
        return Fk_Historique_Id;
    }

    public void setFk_Historique_Id(int Fk_Historique_Id) {
        this.Fk_Historique_Id = Fk_Historique_Id;
    }

    public int getFk_Commentaire_Id() {
        return Fk_Commentaire_Id;
    }

    public void setFk_Commentaire_Id(int Fk_Commentaire_Id) {
        this.Fk_Commentaire_Id = Fk_Commentaire_Id;
    }

    public int getFk_Reservation_Id() {
        return Fk_Reservation_Id;
    }

    public void setFk_Reservation_Id(int Fk_Reservation_Id) {
        this.Fk_Reservation_Id = Fk_Reservation_Id;
    }

    public int getFk_Avis_Id() {
        return Fk_Avis_Id;
    }

    public void setFk_Avis_Id(int Fk_Avis_Id) {
        this.Fk_Avis_Id = Fk_Avis_Id;
    }

    public int getFk_AvisCovid_Id() {
        return Fk_AvisCovid_Id;
    }

    public void setFk_AvisCovid_Id(int Fk_AvisCovid_Id) {
        this.Fk_AvisCovid_Id = Fk_AvisCovid_Id;
    }


    public int getCompte_Id() {
        return Compte_Id;
    }

    public void setCompte_Id(int Compte_Id) {
        this.Compte_Id = Compte_Id;
    }

    @Override
    public String toString() {
        return "Client{" + "Client_Id=" + Client_Id + ", Nom_Client=" + Nom_Client + ", Prenom_Client=" + Prenom_Client + ", Region=" + Region + ", Adresse=" + Adresse + ", Date_Naiss=" + Date_Naiss + ", Tel_Portable=" + Tel_Portable + ", Fk_Historique_Id=" + Fk_Historique_Id + ", Fk_Commentaire_Id=" + Fk_Commentaire_Id + ", Fk_Avis_Id=" + Fk_Avis_Id + ", Fk_AvisCovid_Id=" + Fk_AvisCovid_Id + ", Compte_Id=" + Compte_Id + '}';
    }
 
 
}
