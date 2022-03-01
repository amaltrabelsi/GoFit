/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Date;

/**
 *
 * @author TRABELSI Amaal
 */
public class Utilisateur {
	

    private int Utilisateur_Id ; 
    private String Nom ; 
    private String Prenom;
    private String Email ;
    private String Date_de_naissance ;
    private String Sexe;
    private String Region;
    private String Adresse;
    private String Role ;
    private String numero ;
private String Mdp ;
    public Utilisateur() {
    }

    public Utilisateur(int Utilisateur_Id, String Nom, String Prenom, String Email, String Date_de_naissance, String Sexe, String Region, String Adresse, String Role, String numero, String Mdp) {
        this.Utilisateur_Id = Utilisateur_Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Date_de_naissance = Date_de_naissance;
        this.Sexe = Sexe;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Role = Role;
        this.numero = numero;
        this.Mdp = Mdp;
    }

    public Utilisateur(String Nom, String Prenom, String Email, String Date_de_naissance, String Sexe, String Region, String Adresse, String Role, String numero, String Mdp) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Date_de_naissance = Date_de_naissance;
        this.Sexe = Sexe;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Role = Role;
        this.numero = numero;
        this.Mdp = Mdp;
    }

    
    public Utilisateur(String Nom, String Prenom, String Email, String Date_de_naissance, String Sexe, String Region, String Adresse, String Role, String Mdp) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Date_de_naissance = Date_de_naissance;
        this.Sexe = Sexe;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Role = Role;
        this.Mdp = Mdp ;
    }

    public Utilisateur(int Utilisateur_Id, String Nom, String Prenom, String Email,String Date_de_naissance, String Sexe, String Region, String Adresse, String Role) {
        this.Utilisateur_Id = Utilisateur_Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Date_de_naissance = Date_de_naissance;
        this.Sexe = Sexe;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Role = Role;
    }

    public Utilisateur(String Nom, String Prenom, String Email, String Date_de_naissance, String Sexe, String Region, String Adresse, String Role) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Date_de_naissance = Date_de_naissance;
        this.Sexe = Sexe;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Role = Role;
    }

    public int getUtilisateur_Id() {
        return Utilisateur_Id;
    }

    public void setUtilisateur_Id(int Utilisateur_Id) {
        this.Utilisateur_Id = Utilisateur_Id;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDate_de_naissance() {
        return Date_de_naissance;
    }

    public void setDate_de_naissance(String Date_de_naissance) {
        this.Date_de_naissance = Date_de_naissance;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
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

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "Utilisateur_Id=" + Utilisateur_Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", Date_de_naissance=" + Date_de_naissance + ", Sexe=" + Sexe + ", Region=" + Region + ", Adresse=" + Adresse + ", Role=" + Role + ", numero=" + numero + ", Mdp=" + Mdp + '}';
    }

  
    
}
