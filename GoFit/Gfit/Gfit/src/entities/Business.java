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
public class Business {
    private int Business_Id;
    private String Nom_Business;
    private String Nom_Gerant;
    private String Prenom_Gerant;
    private String Region;
    private String Adresse;
    private Date Date_Fondation;
    private String Description;
    private String Tel_Portable;
    private String Tel_Fix;
    private String Path_Image;
    private int Note;
    private int Compte_Id;
    private int FK_Produit_Id;

    public Business(int Business_Id, String Nom_Business, String Region, String Description, String Tel_Fix) {
        this.Business_Id = Business_Id;
        this.Nom_Business = Nom_Business;
        this.Region = Region;
        this.Description = Description;
        this.Tel_Fix = Tel_Fix;
    }

   

    public int getFK_Produit_Id() {
        return FK_Produit_Id;
    }

    public void setFK_Produit_Id(int FK_Produit_Id) {
        this.FK_Produit_Id = FK_Produit_Id;
    }

    public Business(int Business_Id, String Region, String Description, String Tel_Fix) {
        this.Business_Id = Business_Id;
        this.Region = Region;
        this.Description = Description;
        this.Tel_Fix = Tel_Fix;
    }

    public Business(int Business_Id, String Nom_Business, String Region, String Adresse, String Description, String Tel_Fix) {
        this.Business_Id = Business_Id;
        this.Nom_Business = Nom_Business;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Description = Description;
        this.Tel_Fix = Tel_Fix;
    }
    
    
    
    
    public Business () {
    }

    public int getNote() {
        return Note;
    }

    public void setNote(int Note) {
        this.Note = Note;
    }

    public String getPath_Image() {
        return Path_Image;
    }

    public void setPath_Image(String Path_Image) {
        this.Path_Image = Path_Image;
    }
    

    public Business(String Nom_Business, String Nom_Gerant, String Prenom_Gerant, String Region, String Adresse, String Description, String Tel_Portable, String Tel_Fix, String Path_Image) {
        this.Nom_Business = Nom_Business;
        this.Nom_Gerant = Nom_Gerant;
        this.Prenom_Gerant = Prenom_Gerant;
        this.Region = Region;
        this.Adresse = Adresse;
       
        this.Description = Description;
        this.Tel_Portable = Tel_Portable;
        this.Tel_Fix = Tel_Fix;
        this.Path_Image = Path_Image;
    }

    public Business(String Nom_Business, String Nom_Gerant, String Prenom_Gerant) {
        this.Nom_Business = Nom_Business;
        this.Nom_Gerant = Nom_Gerant;
        this.Prenom_Gerant = Prenom_Gerant;
    }
    
 
    public Business(String Nom_Business, String Nom_Gerant, String Prenom_Gerant, String Region, String Adresse, Date Date_Fondation, String Description, String Tel_Portable, String Tel_Fix, int Note) {
        this.Nom_Business = Nom_Business;
        this.Nom_Gerant = Nom_Gerant;
        this.Prenom_Gerant = Prenom_Gerant;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Fondation = Date_Fondation;
        this.Description = Description;
        this.Tel_Portable = Tel_Portable;
        this.Tel_Fix = Tel_Fix;
        this.Note = Note;
    }

    public Business(int Business_Id, String Nom_Business, String Nom_Gerant, String Prenom_Gerant, String Region, String Adresse, Date Date_Fondation, String Description, String Tel_Portable, String Tel_Fix, int Compte_Id) {
        this.Business_Id = Business_Id;
        this.Nom_Business = Nom_Business;
        this.Nom_Gerant = Nom_Gerant;
        this.Prenom_Gerant = Prenom_Gerant;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Date_Fondation = Date_Fondation;
        this.Description = Description;
        this.Tel_Portable = Tel_Portable;
        this.Tel_Fix = Tel_Fix;
        this.Compte_Id = Compte_Id;
    }

    

    

    public int getBusiness_Id() {
        return Business_Id;
    }

    public String getNom_Business() {
        return Nom_Business;
    }

    public String getNom_Gerant() {
        return Nom_Gerant;
    }

    public String getPrenom_Gerant() {
        return Prenom_Gerant;
    }

    public String getRegion() {
        return Region;
    }

    public String getAdresse() {
        return Adresse;
    }

    public Date getDate_Fondation() {
        return Date_Fondation;
    }

    public String getDescription() {
        return Description;
    }

    public String getTel_Portable() {
        return Tel_Portable;
    }

    public String getTel_Fix() {
        return Tel_Fix;
    }

    public void setBusiness_Id(int Business_Id) {
        this.Business_Id = Business_Id;
    }

    public void setNom_Business(String Nom_Business) {
        this.Nom_Business = Nom_Business;
    }

    public void setNom_Gerant(String Nom_Gerant) {
        this.Nom_Gerant = Nom_Gerant;
    }

    public void setPrenom_Gerant(String Prenom_Gerant) {
        this.Prenom_Gerant = Prenom_Gerant;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setDate_Fondation(Date Date_Fondation) {
        this.Date_Fondation = Date_Fondation;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setTel_Portable(String Tel_Portable) {
        this.Tel_Portable = Tel_Portable;
    }

    public void setTel_Fix(String Tel_Fix) {
        this.Tel_Fix = Tel_Fix;
    }

    public int getCompte_Id() {
        return Compte_Id;
    }

    public void setCompte_Id(int Compte_Id) {
        this.Compte_Id = Compte_Id;
    }

    @Override
    public String toString() {
        return "Business{" + "Business_Id=" + Business_Id + ", Nom_Business=" + Nom_Business + ", Nom_Gerant=" + Nom_Gerant + ", Prenom_Gerant=" + Prenom_Gerant + ", Region=" + Region + ", Adresse=" + Adresse + ", Date_Fondation=" + Date_Fondation + ", Description=" + Description + ", Tel_Portable=" + Tel_Portable + ", Tel_Fix=" + Tel_Fix + ", Path_Image=" + Path_Image + ", Note=" + Note + ", Compte_Id=" + Compte_Id + '}';
    }

    
    
    
    
}
