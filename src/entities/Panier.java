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
    private int Panier_Id ;
    private int FK_ProduitP_Id ;
    private int FK_Client_Id ;
    public Panier(){
    }

    public Panier(int Panier_Id, int FK_ProduitP_Id, int FK_Client_Id) {
        this.Panier_Id = Panier_Id;
        this.FK_ProduitP_Id = FK_ProduitP_Id;
        this.FK_Client_Id = FK_Client_Id;
    }

    public Panier(int FK_ProduitP_Id,  int FK_Client_Id) {
       
        this.FK_ProduitP_Id = FK_ProduitP_Id;
       
        this.FK_Client_Id = FK_Client_Id;
    }

    public int getPanier_Id() {
        return Panier_Id;
    }

    public void setPanier_Id(int Panier_Id) {
        this.Panier_Id = Panier_Id;
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
        return "Panier{" + "Panier_Id=" + Panier_Id + ", FK_ProduitP_Id=" + FK_ProduitP_Id + ", FK_Client_Id=" + FK_Client_Id + '}';
    }
    
    
}
