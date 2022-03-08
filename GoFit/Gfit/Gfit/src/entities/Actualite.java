/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.scene.control.Button;

/**
 *
 * @author hp
 */
public class Actualite {
 
    private int	Actualite_Id;
    private String   Titre;
    private String    Description;
    private String    Contenu;
    private String   Categorie;
    private String Path_Image;
    public Actualite () {}

    public Actualite(String Titre, String Description, String Contenu) {
        this.Titre = Titre;
        this.Description = Description;
        this.Contenu = Contenu;
       // this.Fk_CommentaireA_Id = Fk_CommentaireA_Id;
    }

    public Actualite(String Titre, String Description, String Contenu, String Categorie, String Path_Image) {
        this.Titre = Titre;
        this.Description = Description;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
        this.Path_Image = Path_Image;
    }

    public Actualite(int Actualite_Id, String Titre, String Description, String Contenu, String Categorie) {
        this.Actualite_Id = Actualite_Id;
        this.Titre = Titre;
        this.Description = Description;
        this.Contenu = Contenu;
        this.Categorie = Categorie;
    }

   


    public Actualite(int Actualite_Id, String Titre, String Description, String Contenu) {
        this.Actualite_Id = Actualite_Id;
        this.Titre = Titre;
        this.Description = Description;
        this.Contenu = Contenu;
    }
    

    public int getActualite_Id() {
        return Actualite_Id;
    }

    public void setActualite_Id(int Actualite_Id) {
        this.Actualite_Id = Actualite_Id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getContenu() {
        return Contenu;
    }

    public String getPath_Image() {
        return Path_Image;
    }

    public void setPath_Image(String Path_Image) {
        this.Path_Image = Path_Image;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    
    public String getCategorie() {
        return Categorie;
    }

    /* public int getFk_CommentaireA_Id() {
    return Fk_CommentaireA_Id;
    }
    public void setFk_CommentaireA_Id(int Fk_CommentaireA_Id) {
    this.Fk_CommentaireA_Id = Fk_CommentaireA_Id;
    }
     */
    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    @Override
    public String toString() {
        return "Actualite{" + "Actualite_Id=" + Actualite_Id + ", Titre=" + Titre + ", Description=" + Description + ", Contenu=" + Contenu + ", Categorie=" + Categorie + ", Path_Image=" + Path_Image + '}';
    }


    
}
