/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Panier {
    private int PanierAjout_Id ;
    private int FK_ProduitP_Id ;
    private String Nom_Produit;
    private double Prix_Uni; 
    private String Ref_P; 
     
    
    
     private int Code_Panier ;
    private int FK_Client_Id ;
    
    public Panier(){
    }


    public Panier(int FK_ProduitP_Id,  int FK_Client_Id) {
       
        this.FK_ProduitP_Id = FK_ProduitP_Id;
       
        this.FK_Client_Id = FK_Client_Id;
    }

   
    public int getPanierAjout_Id() {
        return PanierAjout_Id;
    }

    public void setPanierAjout_Id(int PanierAjout_Id) {
        this.PanierAjout_Id = PanierAjout_Id;
    }

    public String getNom_Produit() {
        return Nom_Produit;
    }

    public void setNom_Produit(String Nom_Produit) {
        this.Nom_Produit = Nom_Produit;
    }

    public double getPrix_Uni() {
        return Prix_Uni;
    }

    public void setPrix_Uni(double Prix_Uni) {
        this.Prix_Uni = Prix_Uni;
    }

    public String getRef_P() {
        return Ref_P;
    }

    public void setRef_P(String Ref_P) {
        this.Ref_P = Ref_P;
    }

    public int getCode_Panier() {
        return Code_Panier;
    }

    public void setCode_Panier(int Code_Panier) {
        this.Code_Panier = Code_Panier;
    }

    public Panier(int Code_Panier,int FK_ProduitP_Id,  int FK_Client_Id) {
    
        this.FK_ProduitP_Id = FK_ProduitP_Id;
        this.Code_Panier = Code_Panier;
        this.FK_Client_Id = FK_Client_Id;
    }



    public int getFK_ProduitP_Id() {
        return FK_ProduitP_Id;
    }

    public void setFK_ProduitP_Id(int FK_ProduitP_Id) {
        this.FK_ProduitP_Id = FK_ProduitP_Id;
    }


    public int getFK_Client_Id() {
        return FK_Client_Id;
    }

    public void setFK_Client_Id(int FK_Client_Id) {
        this.FK_Client_Id = FK_Client_Id;
    }

    @Override
    public String toString() {
        return "Panier{" + "PanierAjout_Id=" + PanierAjout_Id + ", FK_ProduitP_Id=" + FK_ProduitP_Id + ", Nom_Produit=" + Nom_Produit + ", Prix_Uni=" + Prix_Uni + ", Ref_P=" + Ref_P + ", Code_Panier=" + Code_Panier + ", FK_Client_Id=" + FK_Client_Id + '}';
    }


    
    
}
