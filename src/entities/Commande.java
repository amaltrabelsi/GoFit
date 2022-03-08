/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Commande {
    private int Commande_Id ;

    private Date Date_C;
    private double Total;
    private int Nb_Produit;
    private String Mode_Paiement;
    private int FK_Reg_Id;
    private int FK_Client_Id;

    public Commande() {
    }


//code in panier est l id du client car that works better obviouslyy :/
    public Commande( double Total, int Nb_Produit, String Mode_Paiement, int FK_Reg_Id, int FK_Client_Id) {
        this.Total = Total;
        this.Nb_Produit = Nb_Produit;
        this.Mode_Paiement = Mode_Paiement;
        this.FK_Reg_Id = FK_Reg_Id;
        this.FK_Client_Id = FK_Client_Id;
    }

    public Commande(int Commande_Id, double Total, int Nb_Produit, String Mode_Paiement) {
        this.Commande_Id = Commande_Id;
        this.Total = Total;
        this.Nb_Produit = Nb_Produit;
        this.Mode_Paiement = Mode_Paiement;
    }

    public Commande(int Commande_Id, Date Date_C, double Total, String Mode_Paiement) {
        this.Commande_Id = Commande_Id;
        this.Date_C = Date_C;
        this.Total = Total;
        this.Mode_Paiement = Mode_Paiement;
    }

    public Commande(Date Date_C, double Total, String Mode_Paiement) {
        this.Date_C = Date_C;
        this.Total = Total;
        this.Mode_Paiement = Mode_Paiement;
    }

    public Commande(int Commande_Id, Date Date_C, double Total, int Nb_Produit, String Mode_Paiement) {
        this.Commande_Id = Commande_Id;
        this.Date_C = Date_C;
        this.Total = Total;
        this.Nb_Produit = Nb_Produit;
        this.Mode_Paiement = Mode_Paiement;
    }
    
 // one without any foreign keys ya nour
    public Commande(Date Date_C, double Total, int Nb_Produit, String Mode_Paiement) {
        this.Date_C = Date_C;
        this.Total = Total;
        this.Nb_Produit = Nb_Produit;
        this.Mode_Paiement = Mode_Paiement;
    }
    

    public int getCommande_Id() {
        return Commande_Id;
    }

    public void setCommande_Id(int Commande_Id) {
        this.Commande_Id = Commande_Id;
    }

    public Date getDate_C() {
        return Date_C;
    }

    public void setDate_C(Date Date_C) {
        this.Date_C = Date_C;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getNb_Produit() {
        return Nb_Produit;
    }

    public void setNb_Produit(int Nb_Produit) {
        this.Nb_Produit = Nb_Produit;
    }

    public String getMode_Paiement() {
        return Mode_Paiement;
    }

    public void setMode_Paiement(String Mode_Paiement) {
        this.Mode_Paiement = Mode_Paiement;
    }

    public int getFK_Reg_Id() {
        return FK_Reg_Id;
    }

    public void setFK_Reg_Id(int FK_Reg_Id) {
        this.FK_Reg_Id = FK_Reg_Id;
    }

    public int getFK_Client_Id() {
        return FK_Client_Id;
    }

    public void setFK_Client_Id(int FK_Client_Id) {
        this.FK_Client_Id =FK_Client_Id;
    }

    @Override
    public String toString() {
        return "Commande{" + "Commande_Id=" + Commande_Id + ", Date_C=" + Date_C + ", Total=" + Total + ", Nb_Produit=" + Nb_Produit + ", Mode_Paiement=" + Mode_Paiement + ", FK_Reg_Id=" + FK_Reg_Id + ",FK_Client_Id=" +FK_Client_Id + '}';
    }



    
    
    
}
