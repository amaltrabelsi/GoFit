/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author farouk
 */
public class reservation {

    private int Reservation_Id;
    private Date Date_Debut;
    private Date Date_Fin ;
    private String Duree;
     private String Infos_Supp;
    

    public reservation() {
    }

    public reservation(int Reservation_Id, Date Date_Debut, Date Date_Fin, String Duree, String Infos_Supp) {
        this.Reservation_Id = Reservation_Id;
        this.Date_Debut = Date_Debut;
        this.Date_Fin = Date_Fin;
        this.Duree = Duree;
        this.Infos_Supp = Infos_Supp;
    }

    public reservation(Date Date_Debut, Date Date_Fin, String Duree, String Infos_Supp) {
        this.Date_Debut = Date_Debut;
        this.Date_Fin = Date_Fin;
        this.Duree = Duree;
        this.Infos_Supp = Infos_Supp;
    }

    public int getReservation_Id() {
        return Reservation_Id;
    }

    public void setReservation_Id(int Reservation_Id) {
        this.Reservation_Id = Reservation_Id;
    }

    public Date getDate_Debut() {
        return Date_Debut;
    }

    public void setDate_Debut(Date Date_Debut) {
        this.Date_Debut = Date_Debut;
    }

    public Date getDate_Fin() {
        return Date_Fin;
    }

    public void setDate_Fin(Date Date_Fin) {
        this.Date_Fin = Date_Fin;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String Duree) {
        this.Duree = Duree;
    }

    public String getInfos_Supp() {
        return Infos_Supp;
    }

    public void setInfos_Supp(String Infos_Supp) {
        this.Infos_Supp = Infos_Supp;
    }

    @Override
    public String toString() {
        return "reservation{" + "Reservation_Id=" + Reservation_Id + ", Date_Debut=" + Date_Debut + ", Date_Fin=" + Date_Fin + ", Duree=" + Duree + ", Infos_Supp=" + Infos_Supp + '}';
    }

}
