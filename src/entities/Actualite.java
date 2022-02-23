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
public class Actualite {
    private int	Actualite_Id;
    private String   Titre;
    private String    Description;
    private String    Contenu;
    private int    Fk_CommentaireA_Id;
    
    public Actualite () {}

    public Actualite(String Titre, String Description, String Contenu, int Fk_CommentaireA_Id) {
        this.Titre = Titre;
        this.Description = Description;
        this.Contenu = Contenu;
        this.Fk_CommentaireA_Id = Fk_CommentaireA_Id;
    }

    public Actualite(String Titre, String Description, String Contenu) {
        this.Titre = Titre;
        this.Description = Description;
        this.Contenu = Contenu;
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

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public int getFk_CommentaireA_Id() {
        return Fk_CommentaireA_Id;
    }

    public void setFk_CommentaireA_Id(int Fk_CommentaireA_Id) {
        this.Fk_CommentaireA_Id = Fk_CommentaireA_Id;
    }

    @Override
    public String toString() {
        return "Actualite{" + "Actualite_Id=" + Actualite_Id + ", Titre=" + Titre + ", Description=" + Description + ", Contenu=" + Contenu + ", Fk_CommentaireA_Id=" + Fk_CommentaireA_Id + '}';
    }
    
    
}
