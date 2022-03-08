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
public class Abonnementcoach {
    private int AbonnementCoach_Id;
    private int FK_Client_Id; 
    private int FK_Coach_Id;

    public int getAbonnementCoach_Id() {
        return AbonnementCoach_Id;
    }

    public void setAbonnementCoach_Id(int AbonnementCoach_Id) {
        this.AbonnementCoach_Id = AbonnementCoach_Id;
    }

    public int getFK_Client_Id() {
        return FK_Client_Id;
    }

    public void setFK_Client_Id(int FK_Client_Id) {
        this.FK_Client_Id = FK_Client_Id;
    }

    public int getFK_Coach_Id() {
        return FK_Coach_Id;
    }

    public void setFK_Coach_Id(int FK_Coach_Id) {
        this.FK_Coach_Id = FK_Coach_Id;
    }

    public Abonnementcoach(int AbonnementCoach_Id, int FK_Client_Id, int FK_Coach_Id) {
        this.AbonnementCoach_Id = AbonnementCoach_Id;
        this.FK_Client_Id = FK_Client_Id;
        this.FK_Coach_Id = FK_Coach_Id;
    }

    public Abonnementcoach(int FK_Client_Id, int FK_Coach_Id) {
        this.FK_Client_Id = FK_Client_Id;
        this.FK_Coach_Id = FK_Coach_Id;
    }

    public Abonnementcoach() {
    }
    
    
}
