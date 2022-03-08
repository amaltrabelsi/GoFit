/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProfilController implements Initializable {

    @FXML
    private AnchorPane fenetreprofil;
    @FXML
    private ImageView profil;
    @FXML
    private Button parametre;
    @FXML
    private Button deco;
    @FXML
    private Button Reclamationprofil;
    @FXML
    private Label email1;
    @FXML
    private Label labelprenom;
    @FXML
    private Button Boutiques;
    @FXML
    private Button Service;
    @FXML
    private Button Panier;
    @FXML
    private Label codeid;
    @FXML
    private Button Reservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        
    }    

    @FXML
    private void profil(ActionEvent event) {
       try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherArticlesClients.fxml"));
          
            Parent root = loader.load();
            Reservation.getScene().setRoot(root);
                 } catch (IOException ex) {
    
    }
    }
        
    
    


    @FXML
    private void parametre(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Parametre.fxml"));
          
            Parent root = loader.load();
            parametre.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
    }

    @FXML
    private void deco(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
          
            Parent root = loader.load();
            
            deco.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
    }

    @FXML
    private void reclamationProfil(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Reclamation.fxml"));
          
            Parent root = loader.load();
            deco.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
    }

    @FXML
    private void Boutiques(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/BoutiqueCoteClient.fxml"));
          
            Parent root = loader.load();
            deco.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
     
        
    }

    @FXML
    private void Service(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Service.fxml"));
          
            Parent root = loader.load();
            deco.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
      
    }

    @FXML
    private void Panier(ActionEvent event) {
    }

    @FXML
    private void Reservation(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Reservation.fxml"));
          
            Parent root = loader.load();
            Reservation.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
        
    }

    @FXML
    private void profil(MouseEvent event) {
           try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherArticlesClients.fxml"));
          
            Parent root = loader.load();
            Reservation.getScene().setRoot(root);
                 } catch (IOException ex) {
    
    }
    }
     
    }
    

