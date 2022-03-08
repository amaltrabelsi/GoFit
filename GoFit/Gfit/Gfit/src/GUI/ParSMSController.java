/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ConnexionController.ACCOUNT_SID;
import static GUI.ConnexionController.AUTH_TOKEN;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ParSMSController implements Initializable {

    @FXML
    private TextField numeropassms;
    private VBox code;
    private VBox nvmdp;
    @FXML
    private Button modifier;
     int borneInf =1000 ;
       int borneSup = 9999;
   Random random = new Random();
   int nb;
    @FXML
    private VBox parametreparsms;
    @FXML
    private VBox codeparsms;
    @FXML
    private VBox nvmdpparsms;
    @FXML
    private TextField nvmdpmodifparsms;
    @FXML
    private TextField Cnvmdpmodifparsms;
    private TextField codepassmsedit;
 public static final String ACCOUNT_SID = "AC7139fd47c36bc8a4a1193a03666469d3"; 
    public static final String AUTH_TOKEN = "b74d511481394c5e9c103130b8892c73"; 
    @FXML
    private TextField Emailparsms;
    @FXML
    private Button Envoyer;
    @FXML
    private TextField codepassmseditt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  
         nb = borneInf+random.nextInt(borneSup-borneInf);
        parametreparsms.setVisible(true);
        codeparsms.setVisible(false);
        nvmdpparsms.setVisible(false);
        // TODO
    }    

    @FXML
    private void numeropassms(ActionEvent event) {
        sendsms();
        parametreparsms.setVisible(false);
        codeparsms.setVisible(true);
        nvmdpparsms.setVisible(false);
      
    }

 
    

    
public void sendsms() {
     
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+216"+numeropassms.getText()),  
                "MGc4eeb369b5be86e4bf6d6db8ff73b1fd", 
                "votre code de reccupération est : "+nb).create(); 
 
        System.out.println(message.getSid()); 
    }

    @FXML
    private void modifierparsms(ActionEvent event) throws SQLException {
        if (nvmdpmodifparsms.getText().length()<8 ) {
            JOptionPane.showMessageDialog(null, "Le mot de passe ne doit pas étre inferieur à 8 caractere");
            
        }else if (nvmdpmodifparsms.getText().equals(Cnvmdpmodifparsms.getText())==false){
            
            JOptionPane.showMessageDialog(null, "Les deux mots de passe ne sont pas identiques !");
            
        } else { 
           
             Connection cnx = MyDB.getInstance().getConnection(); 
        Statement st = cnx.createStatement();
        
             st.executeUpdate("update utilisateur set mdp ='"+  cryptage(nvmdpmodifparsms.getText())+"' where numero = '"+numeropassms.getText()+"' AND Email = '"+Emailparsms.getText()+"'" );
            JOptionPane.showMessageDialog(null, "Votre nouveau mot de passe est validé vous allez "
                   + "automatiquement accéder à la page de  connexion!");}
           
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
            Parent root = loader.load();
           modifier.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
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

    @FXML
    private void codepassmsedit(ActionEvent event) {
         if ((codepassmseditt.getText().equals(String.valueOf(nb))))
        {parametreparsms.setVisible(false);
        codeparsms.setVisible(false);
        nvmdpparsms.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "Code invalid !");
        }
    }
    

    @FXML
    private void codenvmdp(ActionEvent event) {
    }

    @FXML
    private void Envoyer(ActionEvent event) {
        sendsms();
      parametreparsms.setVisible(false);
        codeparsms.setVisible(true);
        nvmdpparsms.setVisible(false);
    }
}