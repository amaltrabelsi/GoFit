/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField Nom;
    @FXML
    private TextField Email;
    @FXML
    private TextField Prenom;
    @FXML
    private DatePicker date;
    @FXML
    private CheckBox femme;
    @FXML
    private CheckBox homme;
    @FXML
    private TextField Region;
    @FXML
    private TextField Adresse;
    @FXML
    private Button inscription;
    @FXML
    private SplitMenuButton Role;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField Cmdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
