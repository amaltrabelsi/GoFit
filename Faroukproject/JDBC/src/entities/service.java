/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author farouk
 */
public class service {
private int Service_Id;
private String Ref_S;
private String Type_S;
private String Nom_Service;	
private String Description ;	
private String Disponibilite ;	
private String Horaire ;
private String Categorie ;

    public service() {
    }

    public service(int Service_Id, String Ref_S, String Type_S, String Nom_Service, String Description, String Disponibilite, String Horaire, String Categorie) {
        this.Service_Id = Service_Id;
        this.Ref_S = Ref_S;
        this.Type_S = Type_S;
        this.Nom_Service = Nom_Service;
        this.Description = Description;
        this.Disponibilite = Disponibilite;
        this.Horaire = Horaire;
        this.Categorie = Categorie;
    }

    public service(String Ref_S, String Type_S, String Nom_Service, String Description, String Disponibilite, String Horaire, String Categorie) {
        this.Ref_S = Ref_S;
        this.Type_S = Type_S;
        this.Nom_Service = Nom_Service;
        this.Description = Description;
        this.Disponibilite = Disponibilite;
        this.Horaire = Horaire;
        this.Categorie = Categorie;
    }

    public int getService_Id() {
        return Service_Id;
    }

    public void setService_Id(int Service_Id) {
        this.Service_Id = Service_Id;
    }

    public String getRef_S() {
        return Ref_S;
    }

    public void setRef_S(String Ref_S) {
        this.Ref_S = Ref_S;
    }

    public String getType_S() {
        return Type_S;
    }

    public void setType_S(String Type_S) {
        this.Type_S = Type_S;
    }

    public String getNom_Service() {
        return Nom_Service;
    }

    public void setNom_Service(String Nom_Service) {
        this.Nom_Service = Nom_Service;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(String Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    public String getHoraire() {
        return Horaire;
    }

    public void setHoraire(String Horaire) {
        this.Horaire = Horaire;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    @Override
    public String toString() {
        return "service{" + "Service_Id=" + Service_Id  + ", Ref_S=" + Ref_S + ", Type_S=" + Type_S + ", Nom_Service=" + Nom_Service + ", Description=" + Description + ", Disponibilite=" + Disponibilite + ", Horaire=" + Horaire + ", Categorie=" + Categorie + "\n"+'}';
    }
    
}
