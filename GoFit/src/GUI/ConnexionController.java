/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Base64.Decoder;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import services.ServiceUtilisateur;
import tray.animations.AnimationType;
import utils.MyDB;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ConnexionController implements Initializable {

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
    @FXML
    private AnchorPane fenetreprofil;
    @FXML
    private Button profil;
    @FXML
    private Button Accu;
    @FXML
    private Button parametre;
    @FXML
    private Button deco;
    @FXML
    private Button Reclamation;
    @FXML
    private Button event;
    @FXML
    private Label email1;
    @FXML
    private Label labelprenom;
    private AnchorPane fenetrecon;
    @FXML
    private AnchorPane fenetreconnexion;
    @FXML
    private AnchorPane fenetreparam;
    @FXML
    private Button Accu1;
    @FXML
    private Button deco1;
    @FXML
    private Button Reclamation1;
    @FXML
    private Button event1;
    @FXML
    private Label email11;
    @FXML
    private TextField prenommodif;
    @FXML
    private TextField mdpmodif;
    @FXML
    private TextField emailmodif;
    @FXML
    private TextField nommodif;
    @FXML
    private DatePicker datemodif;
    @FXML
    private Button Modifier;
    @FXML
    private TextField regionmodif;
    @FXML
    private TextField adressemodif;
    @FXML
    private TextField rolemodif;
    @FXML
    private TextField nummodif;
    @FXML
    private TextField questionmodif;
    @FXML
    private TextField reponsemodif;
    @FXML
    private TextField sexemodif;
    private AnchorPane methode;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   fenetreconnexion.setVisible(true);
   fenetreparam.setVisible(false);
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
             notification();          
            fenetreprofil.setVisible(true);
            fenetreconnexion.setVisible(false);
            email1.setText(email.getText());
            String m = "select CONCAT (Nom ,' ', Prenom)  from utilisateur where Email = '" + email.getText()+ "' " ; 
            Statement p = cnx.createStatement();
            ResultSet q = p.executeQuery(m);
            q.next();
            labelprenom.setText(q.getString(1));
            System.out.println(q.getString(1));
          
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

    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void accueil(ActionEvent event) {
    }

    @FXML
    private void parametre(ActionEvent event) {
        
        fenetreprofil.setVisible(false);
        fenetreparam.setVisible(true);
            }

    @FXML
    private void deco(ActionEvent event) throws SQLException {
       fenetreconnexion.setVisible(true);
       fenetreprofil.setVisible(false);
        notification1 ();
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
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

    @FXML
    private void Modifier(ActionEvent event)  throws SQLException {
          ServiceUtilisateur r = new ServiceUtilisateur () ;
         Utilisateur rec = new Utilisateur ();
          String m = "select Utilisateur_Id , Utilisateur_Id from utilisateur where Email = '" + email.getText()+ "' " ; 
            Statement p = cnx.createStatement();
            ResultSet q = p.executeQuery(m);
            if (q.next()){
               int str = q.getInt("Utilisateur_Id");
              
         rec.setUtilisateur_Id(str);
         rec.setAdresse(adressemodif.getText());
         rec.setRegion(regionmodif.getText());
         rec.setRole(rolemodif.getText());
         rec.setEmail(emailmodif.getText());
         rec.setSexe(sexemodif.getText());
         rec.setNumero(nummodif.getText());
         rec.setDate_de_naissance(String.valueOf(datemodif.getValue()));
         rec.setMdp(cryptage(mdpmodif.getText()));
         rec.setNom(nommodif.getText());
         rec.setPrenom(prenommodif.getText());
            rec.setReponse(reponsemodif.getText());
            rec.setQuestion(questionmodif.getText());}
         
         
         r.modifier(rec);
         
    
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

 

}