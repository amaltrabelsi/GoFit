/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import services.ServiceProduit;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RateBoutiqueController implements Initializable {

    @FXML
    private Button submitnote;
    @FXML
    private ToggleGroup buttonqualite;
    @FXML
    private ToggleGroup buttonlivraison;
    @FXML
    private ToggleGroup buttonservice;
    @FXML
    private RadioButton q1;
    @FXML
    private RadioButton q2;
    @FXML
    private RadioButton q3;
    @FXML
    private RadioButton l1;
    @FXML
    private RadioButton l2;
    @FXML
    private RadioButton l3;
    @FXML
    private RadioButton s1;
    @FXML
    private RadioButton s2;
    @FXML
    private RadioButton s3;
    
        int note1;
        int note2;
        int note3;
       int rate;
       int oldocc;
       int newocc;
       int total;
       int ratef ;
       int v1;
    @FXML
    private TextField noteutilisateur;
    @FXML
    private Button retour;
    @FXML
    private Label nameLabel;
    @FXML
    private Label noter;
    @FXML
    private TextField noteutilisateur1;
    @FXML
    private Label scoreglabel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
          
    }    
  
    @FXML
    public void SubmitNote(ActionEvent event) {
       ////Group 1 ///// 
   if ((buttonqualite.getSelectedToggle() != null)){  
      if ( (buttonqualite.getSelectedToggle() == q1)) 
      { note1 = 1;
                System.out.println( note1);

      } 
      else if ( (buttonqualite.getSelectedToggle() == q2)){
     note1 = 2;
   
 System.out.println( note1);
      }
      
      else  {  note1=3; 
      System.out.println( note1);
            }       
   }        
  
    
     /////////////////////
     /*groupe livraison
     *//////////:
     if ((buttonlivraison.getSelectedToggle() != null)){  
      if ( (buttonlivraison.getSelectedToggle() == l1)) 
      { note2 = 1;
                System.out.println( note2);

      } else if ( (buttonlivraison.getSelectedToggle() == l2)){
          note2 = 2;
                   System.out.println( note2);

      }
      
      else  { 
                 note2=3;
            System.out.println( note2);}   
           
         
     
    }

     
     /////////////////// groupe 3 //////////
    
      if ((buttonservice.getSelectedToggle() != null)){  
      if ( (buttonservice.getSelectedToggle() == s1)) 
      { note3 = 1;
                System.out.println( note3);

      } else if ( (buttonservice.getSelectedToggle() == s2)){
          note3 = 2;
                   System.out.println( note3);

      }
      
      else  { 
                   note3= 3;
          System.out.println( note3); }
     
    }
    
      /////Calcul note//
      rate = (note1  + note2 + note3) / 3;
      
     ServiceProduit sp = new ServiceProduit();
     String ok = nameLabel.getText();
     Integer Produit = Integer.valueOf(ok);
     
     Produit x = new Produit();
     x=sp.retrieveProduit(Produit);
     
     oldocc =  x.getOccurence(); 
     newocc += oldocc ;
     System.out.println("NEW VALUE "  + newocc);
     //
      
    total = x.getTotalnote() + rate;
    
     System.out.println("NEW VALUE total "  + total);
     //
     
     ratef = total / newocc;
     System.out.println("NEW VALUE ratef  "  + ratef);
    
      Produit m = new Produit (Produit, ratef, total , newocc);
      noteutilisateur1.setText(String.valueOf(ratef));
       sp.modifierocc(m);

 //////// hedhi taabi champs el score /////
      noteutilisateur.setText(String.valueOf(rate));
      
       String title= "Boutique Noté avec Succés";
       TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType (type);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
     
    }

    public void display(String Produit_Id){
              nameLabel.setText(Produit_Id);

    }
    
    
      public void displayname (String Nom_Produit){
             noter.setText("Votre Feedback sur ce produit " +Nom_Produit);

    }
      
    @FXML
    private void retour(ActionEvent event) {
        /////////////// NAVISGATION ENTRE PAGES :::::::::::
             try {

         FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/BoutiqueCoteClient.fxml"));  ///interface li mechilha///
         
              Parent root = loader.load();
               ///controlleur mta3 l interface li mechilha//
              BoutiqueCoteClientController controller = loader.getController();
              retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            ///controlleur mta3 ena fin///
            Logger.getLogger(RateBoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void scoreglobal(ActionEvent event) {
    }
    }
    
