/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Utilisateur;
import services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import java.time.*;



/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class InscriptionController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Email;
    @FXML
    private TextField Prenom;
    @FXML
    private DatePicker date;
    @FXML
    private TextField Region;
    @FXML
    private TextField Adresse;
    @FXML
    private Button inscription;
    @FXML
    private SplitMenuButton Role;
    
    ServiceUtilisateur U = new ServiceUtilisateur() ; 
    DatePicker d = new DatePicker () ;
    @FXML
    private SplitMenuButton Sexe;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void back(ActionEvent event) {
                 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Page2.fxml"));
            Parent root = loader.load();
            back.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void inscription(ActionEvent event) {
        Utilisateur U = new Utilisateur ();
        U.setNom(Nom.getText());
        U.setPrenom(Prenom.getText());
       U.setDate_de_naissance(date.getDayCellFactory());
        U.setSexe(Sexe.getText());
        U.setRegion(Region.getText());
        U.setRole(Role.getText());
        U.setAdresse(Adresse.getText());
        
               
        
    }
}
    
