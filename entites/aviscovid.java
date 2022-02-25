/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author HP 840 G3
 */
public class aviscovid {
    private int AvisCode_Id;
         private String  Valeur ;

    public aviscovid() {
    }

    public aviscovid(int AvisCode_Id, String Valeur) {
        this.AvisCode_Id = AvisCode_Id;
        this.Valeur = Valeur;
    }

    public aviscovid(String Valeur) {
        this.Valeur = Valeur;
    }

    public int getAvisCode_Id() {
        return AvisCode_Id;
    }

    public void setAvisCode_Id(int AvisCode_Id) {
        this.AvisCode_Id = AvisCode_Id;
    }

    public String getValeur() {
        return Valeur;
    }

    public void setValeur(String Valeur) {
        this.Valeur = Valeur;
    }

   
    @Override
    public String toString() {
        return "aviscovid{" + "AvisCode_Id=" + AvisCode_Id + ", Valeur=" + Valeur + '}';
    }
    
}