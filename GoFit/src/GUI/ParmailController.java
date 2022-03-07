/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
    private Button envoyer;
    @FXML
    private VBox code;
    @FXML
    private TextField codenvmdp;
    @FXML
    private VBox nvmdp;
    @FXML
    private TextField codenvmdp11;
    @FXML
    private TextField codenvmdp1;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        parametre.setVisible(true);
        code.setVisible(false);
        nvmdp.setVisible(false);
        
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
      mailvalidation();
      parametre.setVisible(false);
        code.setVisible(true);
        nvmdp.setVisible(false);
    }
    
    @FXML
    private void codenvmdp(ActionEvent event) {
        System.out.println(codevalidation());
        if (codenvmdp.getText()==(String.valueOf(codevalidation())))
        {
           parametre.setVisible(false);
        code.setVisible(false);
        nvmdp.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "Code invalid !");
        }
    }
        public int codevalidation(){
       int borneInf =1000 ;
       int borneSup = 9999;
   Random random = new Random();
   int nb;
   nb = borneInf+random.nextInt(borneSup-borneInf);
   System.out.println(""+nb);
   return nb;
}
public void mailvalidation () {

        final String username = "amaltr21@gmail.com";
        final String password = "526364475263644752636447";

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
            message.setFrom(new InternetAddress("amaltr21@gmail.com"));
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
    private void modifier(ActionEvent event) {
    }
    
}
