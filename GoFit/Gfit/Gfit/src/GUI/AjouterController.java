/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField nomboutique;
    @FXML
    private TextField nomgerant;
    @FXML
    private TextField prenomgerant;
    @FXML
    private DatePicker datefondation;
    @FXML
    private TextField region;
    @FXML
    private TextField pays_evenement;
    @FXML
    private Button ajouter_event;
    @FXML
    private Button gerer_event;
    @FXML
    private TextField telfixe;
    @FXML
    private TextField telmobile;
    @FXML
    private TextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Insert(ActionEvent event) {
    }

    @FXML
    private void gotoActivites(ActionEvent event) {
    }
    
}
