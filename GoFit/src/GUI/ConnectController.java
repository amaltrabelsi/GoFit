/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entities.Utilisateur;
import services.ServiceUtilisateur;
import entities.Utilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import services.ServiceUtilisateur;
import tray.animations.AnimationType;
import utils.MyDB;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import services.IService;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ConnectController implements Initializable {

    Connection cnx;

    private TextField email;
    private TextField role;
    @FXML
    private AnchorPane connexion;
    @FXML
    private Button inscription;
    @FXML
    private PasswordField mdp;
    @FXML
    private Label invalid;
    @FXML
    private SplitMenuButton Role;
    @FXML
    private MenuItem admin;
    @FXML
    private MenuItem client;
    @FXML
    private MenuItem coach;
    @FXML
    private MenuItem vendeur;
    @FXML
    private TextField user;
    @FXML
    private Button connexionn;

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }

    @FXML
        
    
    
    private void connexion(ActionEvent event) throws SQLException {
        if (email.getText().isEmpty() == false && mdp.getText().isEmpty() == false  && Role.getText().isEmpty() == false)
        {
             cnx = MyDB.getInstance().getConnection();
             String r = Role.getText() ;
             System.out.println(r);
             chaine();
             
             
         try {
         String req = "select * from utilisateur where Email = '" + email.getText()+ "' AND  mdp ='"+ mdp.getText()+ "' and Role = '"+ Role.getText()+ "'" ; 
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req); 
             if (!rs.isBeforeFirst()){
                // System.out.println("Vérifiez vous paramétres s'il vous plaît !");
                 Alert alert = new Alert (Alert.AlertType.ERROR);
                 alert.setContentText("Vérifiez vous paramétres s'il vous plaît !");
                 alert.show();
             } else { 
                 switch (r) {
                     case "admin": 
                         
                          try {
                              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/LISTE USER.fxml"));
            Parent root = loader.load();
            connexion.getScene().setRoot(root);
            
        
               
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
                          TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType (type);
        tray.setTitle("Bienvenue");
        tray.setMessage("Bienvenue Dans notre application Cher Admin"+mdp.getText());
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
                          ; break;
        
                     case "client": 
                 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Welcome.fxml"));
            Parent root = loader.load();
            connexion.getScene().setRoot(root);
           

        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                 TrayNotification tra = new TrayNotification();
        AnimationType typ = AnimationType.POPUP;
        tra.setAnimationType (typ);
        tra.setTitle("Bienvenue");
        tra.setMessage("Bienvenue Dans notre application Cher Client");
        tra.setNotificationType(NotificationType.SUCCESS);
        tra.showAndDismiss(Duration.millis(3000));
                 ; break;
                      case "coach": 
                      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/coach.fxml"));
            Parent root = loader.load();
            connexion.getScene().setRoot(root);
                 } catch (IOException ex) {
            Logger.getLogger(CoachController.class.getName()).log(Level.SEVERE, null, ex);
        }
                      TrayNotification tr = new TrayNotification();
        AnimationType ty = AnimationType.POPUP;
        tr.setAnimationType (ty);
        tr.setTitle("Bienvenue");
        tr.setMessage("Bienvenue Dans notre application Cher Coach");
        tr.setNotificationType(NotificationType.SUCCESS);
        tr.showAndDismiss(Duration.millis(3000));
                ; break;     
                      case "vendeur": 
                      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/vendeur.fxml"));
            Parent root = loader.load();
            connexion.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(VendeurController.class.getName()).log(Level.SEVERE, null, ex);}
                      
                      TrayNotification t= new TrayNotification();
        AnimationType y = AnimationType.POPUP;
        t.setAnimationType (y);
        t.setTitle("Bienvenue");
        t.setMessage("Bienvenue Dans notre application Cher Vendeur");
        t.setNotificationType(NotificationType.SUCCESS);
        t.showAndDismiss(Duration.millis(3000));
                      ; break;
                 }
         
   
      
         }} catch (Exception e) {
             e.printStackTrace();
             e.getCause();
             
         }   
         
       
        } else {
             Alert alert = new Alert (Alert.AlertType.ERROR);
                 alert.setContentText("Remplir vos coordonées s'il vous plaît ");
                 alert.show();
            //invalid.setText("Remplir vos coordonées s'il vous plaît ");
        }
       
    }


    private void inscription(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/inscription.fxml"));
            Parent root = loader.load();
            inscription.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
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
    public void chaine (){
    for(int x=0; x<=26; x++)
         {
 
         	Random random=new Random();
            int val=65 + random.nextInt(123);
 
             // Afficher le caractère généré
             System.out.printf("%c",val);
         } }

    @FXML
    private void inscri(ActionEvent event) {
        
    }

    
   
}
