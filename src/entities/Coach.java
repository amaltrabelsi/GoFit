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
public class Coach {
    
   private int     Coach_Id;
   private String  Nom_Coach;
   private String    Prenom_Coach;	
    private String    Tel_Portable;
  private String      Adresse;
   private String     Specialite;
    private String    Description;
     private String   Qualification;
     private String   Region;
    private int     Fk_ReserC_Id;
    private int     Compte_Id;	
    
    
    public Coach() {}

    public Coach(int Coach_Id, String Nom_Coach, String Prenom_Coach, String Tel_Portable, String Adresse, String Specialite, String Qualification, String Region, int Fk_ReserC_Id, int Compte_Id) {
        this.Coach_Id = Coach_Id;
        this.Nom_Coach = Nom_Coach;
        this.Prenom_Coach = Prenom_Coach;
        this.Tel_Portable = Tel_Portable;
        this.Adresse = Adresse;
        this.Specialite = Specialite;
        this.Qualification = Qualification;
        this.Region = Region;
        this.Fk_ReserC_Id = Fk_ReserC_Id;
        this.Compte_Id = Compte_Id;
    }

    public Coach(String Nom_Coach, String Prenom_Coach, String Tel_Portable, String Adresse, String Specialite, String Description, String Qualification, String Region) {
        this.Nom_Coach = Nom_Coach;
        this.Prenom_Coach = Prenom_Coach;
        this.Tel_Portable = Tel_Portable;
        this.Adresse = Adresse;
        this.Specialite = Specialite;
        this.Description = Description;
        this.Qualification = Qualification;
        this.Region = Region;
    }

    public Coach(String Nom_Coach, String Prenom_Coach, String Tel_Portable, String Adresse, String Specialite, String Description, String Qualification, String Region, int Fk_ReserC_Id, int Compte_Id) {
        this.Nom_Coach = Nom_Coach;
        this.Prenom_Coach = Prenom_Coach;
        this.Tel_Portable = Tel_Portable;
        this.Adresse = Adresse;
        this.Specialite = Specialite;
        this.Description = Description;
        this.Qualification = Qualification;
        this.Region = Region;
        this.Fk_ReserC_Id = Fk_ReserC_Id;
        this.Compte_Id = Compte_Id;
    }

    public int getCoach_Id() {
        return Coach_Id;
    }

    public void setCoach_Id(int Coach_Id) {
        this.Coach_Id = Coach_Id;
    }

    public String getNom_Coach() {
        return Nom_Coach;
    }

    public void setNom_Coach(String Nom_Coach) {
        this.Nom_Coach = Nom_Coach;
    }

    public String getPrenom_Coach() {
        return Prenom_Coach;
    }

    public void setPrenom_Coach(String Prenom_Coach) {
        this.Prenom_Coach = Prenom_Coach;
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

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String Qualification) {
        this.Qualification = Qualification;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public int getFk_ReserC_Id() {
        return Fk_ReserC_Id;
    }

    public void setFk_ReserC_Id(int Fk_ReserC_Id) {
        this.Fk_ReserC_Id = Fk_ReserC_Id;
    }

    public int getCompte_Id() {
        return Compte_Id;
    }

    public void setCompte_Id(int Compte_Id) {
        this.Compte_Id = Compte_Id;
    }

    @Override
    public String toString() {
        return "Coach{" + "Coach_Id=" + Coach_Id + ", Nom_Coach=" + Nom_Coach + ", Prenom_Coach=" + Prenom_Coach + ", Tel_Portable=" + Tel_Portable + ", Adresse=" + Adresse + ", Specialite=" + Specialite + ", Description=" + Description + ", Qualification=" + Qualification + ", Region=" + Region + ", Fk_ReserC_Id=" + Fk_ReserC_Id + ", Compte_Id=" + Compte_Id + '}';
    }
    
}
