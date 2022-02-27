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

    public Reclamation() {
    } 

    public Reclamation(int Reclamation_Id, String Contenu) {
        this.Reclamation_Id = Reclamation_Id;
        this.Contenu = Contenu;
    }

    public Reclamation(String Contenu) {
        this.Contenu = Contenu;
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

    @Override
    public String toString() {
        return "reclamation{" + "Reclamation_Id=" + Reclamation_Id + ", Contenu=" + Contenu + '}';
    }

  
}
   
 