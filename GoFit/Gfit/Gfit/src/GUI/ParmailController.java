/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ParmailController implements Initializable {

    @FXML
    private VBox parametre;
    @FXML
    private TextField Email;
    @FXML
    private VBox code;
    @FXML
    private TextField codenvmdp;
    @FXML
    private VBox nvmdp;
    @FXML
    private Button modifier;
    @FXML
    private TextField nvmdpmodif1;
    @FXML
    private TextField Cnvmdpmodif;
    int borneInf =1000 ;
       int borneSup = 9999;
   Random random = new Random();
   int nb;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nb = borneInf+random.nextInt(borneSup-borneInf);
        parametre.setVisible(true);
        code.setVisible(false);
        nvmdp.setVisible(false);
        
        
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) throws SQLException {
        
      mailvalidation();
      parametre.setVisible(false);
        code.setVisible(true);
        nvmdp.setVisible(false);
        
      
    }
    
    
    @FXML
    private void codenvmdp(ActionEvent event) {
          
         if ((codenvmdp.getText().equals(String.valueOf(nb))))
        {parametre.setVisible(false);
        code.setVisible(false);
        nvmdp.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "Code invalid !");
        }
        
         
       
    
}
public void mailvalidation () {

        final String username = "gofitbythefive2022@gmail.com";
        final String password = "gofitbythefive 2022@";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gofitbythefive2022@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(Email.getText())
            );
            message.setSubject("Code de recupération ");
            message.setText( "Votre code est : "+codevalidation());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
  


    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
         if (nvmdpmodif1.getText().length()<8 ) {
            JOptionPane.showMessageDialog(null, "Le mot de passe ne doit pas étre inferieur à 8 caractere");
            
        }else if (nvmdpmodif1.getText().equals(Cnvmdpmodif.getText())==false){
            
            JOptionPane.showMessageDialog(null, "Les deux mots de passe ne sont pas identiques !");
            
        } else {   
             Connection cnx = MyDB.getInstance().getConnection(); 
        Statement st = cnx.createStatement();
             st.executeUpdate("update utilisateur set mdp ='"+  cryptage(nvmdpmodif1.getText())+"' where Email = '"+Email.getText()+"'" );
           JOptionPane.showMessageDialog(null, "Votre nouveau mot de passe est validé vous allez "
                   + "automatiquement accéder à la page de  connexion!");
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
            Parent root = loader.load();
           modifier.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
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
 
        public int codevalidation(){
       
   System.out.println(""+nb);
   return nb;   
}
}