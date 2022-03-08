/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import utils.MyDB;
import entities.Utilisateur;
import java.io.IOException;
import javafx.event.Event;
import javafx.scene.control.MenuItem;
import services.ServiceUtilisateur;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;



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
    @FXML
    private Label invalid;
      Connection cnx;
    ServiceUtilisateur uti = new ServiceUtilisateur ();
    @FXML
    private MenuItem admin;
    @FXML
    private MenuItem client;
    @FXML
    private MenuItem coach;
    @FXML
    private MenuItem vendeur;
    @FXML
    private SplitMenuButton Sexe;
    @FXML
    private MenuItem femme;
    @FXML
    private MenuItem homme;
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    

    @FXML
    private void inscription(ActionEvent event) {
         if (mdp.getText() == (Cmdp.getText())){
           
          invalid.setText("Les mots de passe ne sont pas identiques");
            
        }else {
             invalid.setText("");
         cnx = MyDB.getInstance().getConnection();
        Utilisateur u = new Utilisateur();
        u.setEmail(Email.getText());
        u.setNom(Nom.getText());
        u.setPrenom(Prenom.getText());
        u.setRole(Role.getText());
        // System.out.println(Role.getText());
        u.setRegion(Region.getText());
        u.setSexe(Sexe.getText() );
        u.setAdresse(Adresse.getText());
        u.setDate_de_naissance(String.valueOf(date.getValue()));
        u.setMdp(mdp.getText());
        uti.ajout(u);
          Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                 alert.setContentText("Votre inscription est bien enregistrée !");
                 alert.show();
                   try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
            Parent root = loader.load();
            inscription.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
   

        
    
        
    }

 

    @FXML
    private void admin(ActionEvent event) {
        Role.setText("admin");
        
    }

    @FXML
    private void admin(Event event) {
         Role.setText("admin");
    }

    @FXML
    private void client(ActionEvent event) {
         Role.setText("client");
    }

    @FXML
    private void client(Event event) {
        Role.setText("client");
    }

    @FXML
    private void coach(ActionEvent event) {
        Role.setText("coach");
    }

    @FXML
    private void coach(Event event) {
         Role.setText("coach");
    }

    @FXML
    private void vendeur(ActionEvent event) {
         Role.setText("vendeur");
    }

    @FXML
    private void vendeur(Event event) {
         Role.setText("vendeur");
    }

    @FXML
    private void Role(ActionEvent event) {
    }

    @FXML
    private void Sexe(ActionEvent event) {
    }

    @FXML
    private void femme(ActionEvent event) {
        Sexe.setText("femme");
        
    }

    @FXML
    private void femme(Event event) {
         Sexe.setText("femme");
    }

    @FXML
    private void homme(ActionEvent event) {
         Sexe.setText("homme");
    }

    @FXML
    private void homme(Event event) {
        Sexe.setText("homme");
    }

   
    
    
}
