/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;
import entities.Business;
import entities.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class PtdeventeController implements Initializable {

    @FXML
    private ImageView imgIV;
    @FXML
    private Label nameLBL;
    @FXML
    private Label date_ouvLBL;
    @FXML
    private Label idLBL;
    @FXML
    private Label proprietaireLBL;

    private Produit ptdevente;
    private Business ptdevente2;
    private Actualite ptdevente3;
    @FXML
    private Label adressLBL;
    @FXML
    private Label modifierBTN;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Image image;
    TextField nameTextField;

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setData(Produit pt) {
        this.ptdevente = pt;
        this.idLBL.setText(String.valueOf(pt.getProduit_Id()));
        this.nameLBL.setText(pt.getCategorie());
        this.proprietaireLBL.setText(pt.getNom_Produit());
        this.adressLBL.setText(pt.getRef_P());
         
        this.date_ouvLBL.setText(pt.getDescription());

    }

    public void setData(Business pt) {
        this.ptdevente2 = pt;
        this.idLBL.setText(String.valueOf(pt.getBusiness_Id()));
        this.nameLBL.setText(pt.getNom_Business());
        this.proprietaireLBL.setText(pt.getRegion());
        this.adressLBL.setText(pt.getTel_Fix());
        this.date_ouvLBL.setText(pt.getDescription());

    }

    public void setData(Actualite pt) {
        this.ptdevente3 = pt;
        this.idLBL.setText(String.valueOf(pt.getActualite_Id()));
        this.nameLBL.setText(pt.getCategorie());
        this.proprietaireLBL.setText(pt.getTitre());
        this.adressLBL.setText(pt.getDescription());
        this.date_ouvLBL.setText(pt.getContenu());

    }

    public Produit getData() {
        return ptdevente;
    }

    public Business getDataBus() {
        return ptdevente2;
    }

    public Actualite getDataArt() {
        return ptdevente3;
    }
}
