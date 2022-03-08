/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.mail.Message;
import entities.Reclamation;
import entities.Utilisateur;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI; 
import java.math.BigDecimal;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.ServiceUtilisateur;
import services.ServicesReclamation;
import tray.animations.AnimationType;
import utils.MyDB;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
//import javax.mail.Message;
 
/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ConnexionController implements Initializable {
   public static final String ACCOUNT_SID = "AC7139fd47c36bc8a4a1193a03666469d3"; 
    public static final String AUTH_TOKEN = "b74d511481394c5e9c103130b8892c73"; 

    Connection cnx;

    @FXML
    private TextField email;
    private TextField role;
    private AnchorPane connexion;
    @FXML
    private Hyperlink mdpoublié;
    @FXML
    private Hyperlink inscription;
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
    private Button connexionn;
    public Label labelprenom;
    private AnchorPane fenetrecon;
    @FXML
    private AnchorPane fenetreconnexion;
    private AnchorPane methode;
    ServicesReclamation r =  new ServicesReclamation () ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }

    @FXML
        
    
    
    private void connexion(ActionEvent event) throws SQLException {
        if (email.getText().isEmpty() == false && cryptage(mdp.getText()).isEmpty() == false  && Role.getText().isEmpty() == false)
        {
             cnx = MyDB.getInstance().getConnection();
             String r = Role.getText() ;
             chaine();
             
             
         try {
         String req = "select * from utilisateur where Email = '" + email.getText()+ "' AND  mdp ='"+ cryptage(mdp.getText())+ "' and Role = '"+ Role.getText()+ "'" ; 
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
            notification();
        
               
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }; break;
        
                     case "client":
                                try {
          Parent root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
              Scene scene = new Scene(root);
             
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
             notification();
                 } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }   
           ; break;
                      case "coach": 
                      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/coach.fxml"));
            Parent root = loader.load();
            connexion.getScene().setRoot(root);
             notification();
                 } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
                ; break;     
                      case "vendeur": 
                      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/vendeur.fxml"));
            Parent root = loader.load();
            connexion.getScene().setRoot(root);
             notification();
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);}
             ; break;}}} 
         catch (Exception e) {
             e.printStackTrace();
             e.getCause();  }   
         
       
        } else {
             Alert alert = new Alert (Alert.AlertType.ERROR);
                 alert.setContentText("Vérifiez vos coordonées s'il vous plaît ");
                 alert.show();
            //invalid.setText("Remplir vos coordonées s'il vous plaît ");
        }
       
    }

    @FXML
    private void mdpoublié(ActionEvent event) {
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Methode.fxml"));
            Parent root = loader.load();
            inscription.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void inscri(ActionEvent event) {
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



    
   public void notification () throws SQLException
   {
           cnx = MyDB.getInstance().getConnection(); 
        Statement a = cnx.createStatement();
  String b = "select CONCAT (Nom ,' ', Prenom)  from utilisateur where Email = '" + email.getText()+ "' " ; 
        ResultSet c = a.executeQuery(b);
        if (c.next())
        {
           String  y = c.getString(1);
            System.out.println(y);}
                 TrayNotification tra = new TrayNotification();
        AnimationType typ = AnimationType.POPUP;
        tra.setAnimationType (typ);
        tra.setTitle("Bienvenue");
                 
        tra.setMessage("Bienvenue Dans notre application "+c.getString(1));
        tra.setNotificationType(NotificationType.SUCCESS);
        tra.showAndDismiss(Duration.millis(3000));
   }

   
     public void notification1 () throws SQLException
   {
           cnx = MyDB.getInstance().getConnection(); 
        Statement a = cnx.createStatement();
          String b = "select CONCAT (Nom ,' ', Prenom)  from utilisateur where Email = '" + email.getText()+ "' " ; 
        ResultSet c = a.executeQuery(b);
        if (c.next())
        {
           String  y = c.getString(1);
            System.out.println(y);}
                 TrayNotification tra = new TrayNotification();
        AnimationType typ = AnimationType.POPUP;
        tra.setAnimationType (typ);
        tra.setTitle("Bienvenue");
                 
        tra.setMessage("Au revoir "+c.getString("Nom"));
        tra.setNotificationType(NotificationType.SUCCESS);
        tra.showAndDismiss(Duration.millis(3000));
   }

  


  public void notification2 () throws SQLException
   {
           cnx = MyDB.getInstance().getConnection(); 
        Statement a = cnx.createStatement();
          String b = "select CONCAT (Nom ,' ', Prenom)  from utilisateur where Email = '" + email.getText()+ "' " ; 
        ResultSet c = a.executeQuery(b);
        if (c.next())
        {
           String  y = c.getString(1);
            System.out.println(y);}
                 TrayNotification tra = new TrayNotification();
        AnimationType typ = AnimationType.POPUP;
        tra.setAnimationType (typ);
        tra.setTitle("Bienvenue");
                 
        tra.setMessage("Votre modification est prise en considération   "+c.getString("Nom"));
        tra.setNotificationType(NotificationType.SUCCESS);
        tra.showAndDismiss(Duration.millis(3000));
   }
 public String cryptage(String pass) 
   {
        try {
            MessageDigest msg = MessageDigest.getInstance("MD5");
       msg.update(pass.getBytes());
       byte [] rs = msg.digest();
       StringBuilder sb = new  StringBuilder();
       for (byte b :rs)
       {
           sb.append(String.format("%02x", b));
       }
       return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        
        }return "" ; 
   }

 
 
 
 /*
                 /////////////////////////////////Reclamation Partie iheeb ///////////////////////////////////////////


 
    @FXML
    private void reclamationProfil(ActionEvent event) {
        fenetreprofil.setVisible(false);
        fenetreReclamation.setVisible(true);
         fenetreconnexion.setVisible(false);
        fenetreparam.setVisible(false);
       
        emailReclamation.setText(email1.getText());
        
    }

    @FXML
    private void profilreclamation(ActionEvent event) {
        fenetreconnexion.setVisible(false);
        fenetreparam.setVisible(false);
        fenetreprofil.setVisible(true);
        fenetreReclamation.setVisible(false);
        
    }



    @FXML
    private void Boutiques(ActionEvent event) {
    }

    @FXML
    private void Boutiquesparam(ActionEvent event) {
    }

    @FXML
    private void Serviceparam(ActionEvent event) {
    }

    @FXML
    private void parametreparam(ActionEvent event) {
    }

    @FXML
    private void decoparam(ActionEvent event) {
    }

    @FXML
    private void reclamationPram(ActionEvent event) {
    }

    @FXML
    private void Reservationprofil(ActionEvent event) {
        try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Reservation.fxml"));
            Parent root = loader.load();
            Reservationprofil.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Serviceprofil(ActionEvent event) {
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Service.fxml"));
            Parent root = loader.load();
            Serviceprofil.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Panierprofile(ActionEvent event) {
    }

    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void accueil(ActionEvent event) {
    }

    @FXML
    private void parametre(ActionEvent event) {
    }

    @FXML
    private void Modifier(ActionEvent event) {
    }

    @FXML
    private void BoutiqueReclamtion(ActionEvent event) {
    }

    @FXML
    private void BoutiqueReclamtion(Event event) {
    }

    @FXML
    private void CoachReclamtion(ActionEvent event) {
    }

    @FXML
    private void CoachReclamtion(Event event) {
    }

    @FXML
    private void CompteReclamtion(ActionEvent event) {
    }

    @FXML
    private void CompteReclamtion(Event event) {
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void envoyereclamation(ActionEvent event) {
    }
   */ 
    }
    
