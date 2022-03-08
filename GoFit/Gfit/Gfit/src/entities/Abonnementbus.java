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
public class Abonnementbus {
    private int AbonnementBus_Id;
    private int FK_ClientC_Id;
    private int FK_Business_Id;

    public Abonnementbus() {
    }

    public Abonnementbus(int FK_ClientC_Id, int FK_Business_Id) {
        this.FK_ClientC_Id = FK_ClientC_Id;
        this.FK_Business_Id = FK_Business_Id;
    }

    public Abonnementbus(int AbonnementBus_Id, int FK_ClientC_Id, int FK_Business_Id) {
        this.AbonnementBus_Id = AbonnementBus_Id;
        this.FK_ClientC_Id = FK_ClientC_Id;
        this.FK_Business_Id = FK_Business_Id;
    }

    public int getAbonnementBus_Id() {
        return AbonnementBus_Id;
    }

    public void setAbonnementBus_Id(int AbonnementBus_Id) {
        this.AbonnementBus_Id = AbonnementBus_Id;
    }

    public int getFK_ClientC_Id() {
        return FK_ClientC_Id;
    }

    public void setFK_ClientC_Id(int FK_ClientC_Id) {
        this.FK_ClientC_Id = FK_ClientC_Id;
    }

    public int getFK_Business_Id() {
        return FK_Business_Id;
    }

    public void setFK_Business_Id(int FK_Business_Id) {
        this.FK_Business_Id = FK_Business_Id;
    }

    @Override
    public String toString() {
        return "Abonnementbus{" + "AbonnementBus_Id=" + AbonnementBus_Id + ", FK_ClientC_Id=" + FK_ClientC_Id + ", FK_Business_Id=" + FK_Business_Id + '}';
    }
   
   
   
    
    
    
    
}
