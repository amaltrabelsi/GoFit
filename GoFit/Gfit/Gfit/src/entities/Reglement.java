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
public class Reglement {
    private int Reglement_Id;
    private int code ;

    public int getReglement_Id() {
        return Reglement_Id;
    }

    public void setReglement_Id(int Reglement_Id) {
        this.Reglement_Id = Reglement_Id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Reglement(int Reglement_Id, int code) {
        this.Reglement_Id = Reglement_Id;
        this.code = code;
    }

    public Reglement() {
    }

    public Reglement(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Reglement{" + "Reglement_Id=" + Reglement_Id + ", code=" + code + '}';
    }
    
    
}
