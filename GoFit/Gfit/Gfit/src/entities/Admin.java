/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hp
 */
public class Admin {
 private int   Admin_Id;
 private String   Nom;
 private String     Prenom;
 private String      Tel_Portable;
 private String        Adresse	;
private int   Fk_Actualite_Id;	
private int  Compte_Id;

public Admin () {}

 public Admin(String Nom, String Prenom, String Tel_Portable, String Adresse, int Fk_Actualite_Id, int Compte_Id) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Tel_Portable = Tel_Portable;
        this.Adresse = Adresse;
        this.Fk_Actualite_Id = Fk_Actualite_Id;
        this.Compte_Id = Compte_Id;
    }

    public Admin(String Nom, String Prenom, String Tel_Portable, String Adresse) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Tel_Portable = Tel_Portable;
        this.Adresse = Adresse;
    }

    public int getAdmin_Id() {
        return Admin_Id;
    }

    public void setAdmin_Id(int Admin_Id) {
        this.Admin_Id = Admin_Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getTel_Portable() {
        return Tel_Portable;
    }

    public void setTel_Portable(String Tel_Portable) {
        this.Tel_Portable = Tel_Portable;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getFk_Actualite_Id() {
        return Fk_Actualite_Id;
    }

    public void setFk_Actualite_Id(int Fk_Actualite_Id) {
        this.Fk_Actualite_Id = Fk_Actualite_Id;
    }

    public int getCompte_Id() {
        return Compte_Id;
    }

    public void setCompte_Id(int Compte_Id) {
        this.Compte_Id = Compte_Id;
    }

    @Override
    public String toString() {
        return "Admin{" + "Admin_Id=" + Admin_Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Tel_Portable=" + Tel_Portable + ", Adresse=" + Adresse + ", Fk_Actualite_Id=" + Fk_Actualite_Id + ", Compte_Id=" + Compte_Id + '}';
    }


    
}
