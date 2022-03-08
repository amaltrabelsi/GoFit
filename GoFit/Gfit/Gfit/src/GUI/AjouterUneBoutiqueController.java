/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Business;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import services.ServiceBusiness;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterUneBoutiqueController implements Initializable {

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
    private TextField telfixe;
    @FXML
    private TextField telmobile;
    @FXML
    private TextArea description;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                assert nomboutique != null : "fx:id=\"nomboutique\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert nomgerant != null : "fx:id=\"nomgerant\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert prenomgerant != null : "fx:id=\"prenomgerant\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert datefondation != null : "fx:id=\"datefondation\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert region != null : "fx:id=\"region\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert pays_evenement != null : "fx:id=\"pays_evenement\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert telfixe != null : "fx:id=\"telfixe\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert telmobile != null : "fx:id=\"telmobile\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		assert ajouter_event != null : "fx:id=\"ajouter_event\" was not injected: check your FXML file 'AjouterUneBoutique.fxml'.";
		
    }    

    @FXML
    public void Insert(ActionEvent event) {
       ServiceBusiness sb = new ServiceBusiness();
       Business p = new Business();
        p.setNom_Business(nomboutique.getText());
        System.out.println(p.getNom_Business());
        p.setNom_Gerant(nomgerant.getText());
                  System.out.println(p.getNom_Gerant());
        p.setPrenom_Gerant(prenomgerant.getText());
          System.out.println(p.getPrenom_Gerant());
        p.setRegion(region.getText());
          System.out.println(p.getRegion());
        p.setTel_Portable(telmobile.getText());
          System.out.println(p.getTel_Portable());
        p.setAdresse(pays_evenement.getText());
          System.out.println(p.getAdresse());
        p.setTel_Fix(telfixe.getText());
          System.out.println(p.getTel_Fix());
        p.setDescription(description.getText());
          System.out.println(p.getDescription());
        p.setDate_Fondation(Date.valueOf(datefondation.getValue()));
          System.out.println(p.getDate_Fondation());
      
        sb.ajoutbusiness(p);
     String title= "Ajouté avec Succés";
       TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType (type);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));}

    @FXML
    private void retour(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherListBoutiques.fxml"));
            Parent root = loader.load();
        AfficherListBoutiquesController controller = loader.getController();
           retour.getScene().setRoot(root);
        } catch (IOException ex) { 
            Logger.getLogger(AjouterUneBoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }}

    
    
