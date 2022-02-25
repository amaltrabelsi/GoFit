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
public class avis {
    private int Avis_Id;
         private String  Valeur ;
 public avis() {
    }
    public avis(int Avis_Id, String Valeur) {
        this.Avis_Id = Avis_Id;
        this.Valeur = Valeur;
    }

    public avis(String Valeur) {
        this.Valeur = Valeur;
    }

    public int getAvis_Id() {
        return Avis_Id;
    }

    public void setAvis_Id(int Avis_Id) {
        this.Avis_Id = Avis_Id;
    }

    public String getValeur() {
        return Valeur;
    }

    public void setValeur(String Valeur) {
        this.Valeur = Valeur;
    }

   
    @Override
    public String toString() {
        return "avis{" + "Avis_Id=" + Avis_Id + ", Valeur=" + Valeur + '}';
    }

   
    
}
