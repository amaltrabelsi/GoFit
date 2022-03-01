/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.InscriptionController.ACCOUNT_SID;
import static GUI.InscriptionController.AUTH_TOKEN;
import com.teknikindustries.bulksms.SMS;
import com.twilio.Twilio;
import static com.twilio.example.Example.ACCOUNT_SID;
import static com.twilio.example.Example.AUTH_TOKEN;
import static com.twilio.example.ValidationExample.AUTH_TOKEN;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.File;
import java.util.*;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import utils.MyDB;
import entities.Utilisateur;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.net.MalformedURLException;

import javafx.event.Event;
import javafx.scene.control.MenuItem;
import services.ServiceUtilisateur;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;





/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class InscriptionController implements Initializable {
    
public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

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
    private TextField mdp;
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
    @FXML
    private Label generatedString;
    @FXML
    private TextField text;
    @FXML
    private Label invalid1;
    String C ;
    @FXML
    private AnchorPane inscr;
    
    PasswordField passwordField = new PasswordField ();
   
    @FXML
    private TextField num;
    @FXML
    private AnchorPane inscr1;
    @FXML
    private Label labnumero;
    @FXML
    private CheckBox box1;
    @FXML
    private CheckBox box2;
    private TextField passwordTextField;
    @FXML
    private TextField Code;
    @FXML
    private Button back;
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        // TODO
     
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
    Random random = new Random();

    String generateString = random.ints(leftLimit, rightLimit + 1)
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
     C = generateString ;
     
    generatedString.setText("" + generateString + "");
    }
    
             
    @FXML
    private void inscription(ActionEvent event) throws MalformedURLException {
            
    if (Email.getText().isEmpty() == false
                && Nom.getText().isEmpty() == false  
                && Role.getText().isEmpty() == false && Prenom.getText().isEmpty() == false
                && Region.getText().isEmpty() == false && Sexe.getText().isEmpty() == false  
                && Adresse.getText().isEmpty() == false && mdp.getText().isEmpty() == false 
                && Cmdp.getText().isEmpty() == false && text.getText().isEmpty() == false && num.getText().isEmpty() == false) {
            
        if((mdp.getText() == (Cmdp.getText())) ) {
           
     invalid.setText("Les mots de passe ne sont pas identiques");}
         
   else if ((text.getText() == C)){
          invalid1.setText("Les Deux chaines ne sont pas identiques!");
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
        u.setNumero(num.getText());
        uti.ajout(u);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
            Parent root = loader.load();
            inscription.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       /* inscr.setVisible(false); 
        inscr1.setVisible(true);
      labnumero.setText(num.getText());
      //generer un numbre 
      /*Random r = new Random();
      int nb = 1000+r.nextInt(9999-1000);
      
    URL url = new URL ("http://196.236.250.112:8080/"+num.getText()+String.valueOf(nb));
    InputStream i = null ;
    
    try {
        i = url.openStream();
    }catch(Exception ex) {
        
    }*/ } }
    else {
       Alert alert = new Alert (Alert.AlertType.ERROR);
                 alert.setContentText("Remplir Tous les cases s'il vous plaît ");
                 alert.show();
          
    }}

   
    
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

    @FXML
    private void back(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
            Parent root = loader.load();
            inscription.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   
    
    
}
