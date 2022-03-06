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
public class Reclamation {

   private int Reclamation_Id ; 
   private String Contenu ;
private String Email ;
private String Categorie ;
private String date ;
    public Reclamation() {
    } 

    public Reclamation(String Contenu, String Email, String Categorie, String date) {
        this.Contenu = Contenu;
        this.Email = Email;
        this.Categorie = Categorie;
        this.date = date;
    }

    public Reclamation(int Reclamation_Id, String Contenu, String Email, String Categorie, String date) {
        this.Reclamation_Id = Reclamation_Id;
        this.Contenu = Contenu;
        this.Email = Email;
        this.Categorie = Categorie;
        this.date = date;
    }
    

    public Reclamation(int Reclamation_Id, String Contenu, String Email, String Categorie) {
        this.Reclamation_Id = Reclamation_Id;
        this.Contenu = Contenu;
        this.Email = Email;
        this.Categorie = Categorie;
    }

    public Reclamation(String Contenu, String Email, String Categorie) {
        this.Contenu = Contenu;
        this.Email = Email;
        this.Categorie = Categorie;
    }

    public int getReclamation_Id() {
        return Reclamation_Id;
    }

    public void setReclamation_Id(int Reclamation_Id) {
        this.Reclamation_Id = Reclamation_Id;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "Reclamation_Id=" + Reclamation_Id + ", Contenu=" + Contenu + ", Email=" + Email + ", Categorie=" + Categorie + ", date=" + date + '}';
    }

   

   

  
}
   
 