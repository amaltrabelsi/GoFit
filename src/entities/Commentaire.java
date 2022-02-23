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
public class Commentaire {
private int Commentaire_Id;
private String Titre;
private String Contenu;
private Date Date_Comm;

public Commentaire () {}

    public Commentaire(String Titre, String Contenu, Date Date_Comm) {
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.Date_Comm = Date_Comm;    
    }

    public Commentaire(int Commentaire_Id, String Titre, String Contenu, Date Date_Comm) {
        this.Commentaire_Id = Commentaire_Id;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.Date_Comm = Date_Comm;
    }

    

    public int getCommentaire_Id() {
        return Commentaire_Id;
    }

    public void setCommentaire_Id(int Commentaire_Id) {
        this.Commentaire_Id = Commentaire_Id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public Date getDate_Comm() {
        return Date_Comm;
    }

    public void setDate_Comm(Date Date_Comm) {
        this.Date_Comm = Date_Comm;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "Commentaire_Id=" + Commentaire_Id + ", Titre=" + Titre + ", Contenu=" + Contenu + ", Date_Comm=" + Date_Comm + '}';
    }

  
}
