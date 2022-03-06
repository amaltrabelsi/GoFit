    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.mail.*;
import services.ServicesReclamation ;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import entites.Reclamation ;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.Session ;
import javax.mail.Authenticator ;
import javax.mail.Message;
import javax.mail.PasswordAuthentication ;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;


/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class RecController implements Initializable {

    @FXML
    private TextArea Contenu;
    @FXML
    private Button Valider;
     ServicesReclamation r =  new ServicesReclamation () ;
    @FXML
    private TextField Email;
    @FXML
    private MenuItem Boutique;
    @FXML
    private MenuItem Coach;
    @FXML
    private MenuItem Compte;
    @FXML
    private SplitMenuButton Categorie;
     
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
    private void Valider(ActionEvent event) {
         Reclamation Rec = new  Reclamation ();
         Rec.setContenu(Contenu.getText());
         Rec.setCategorie(Categorie.getText());
         Rec.setEmail(Email.getText());
         Rec.setDate(date());
         r.ajout(Rec);
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                 alert.setContentText("Votre Reclamtion est prise en considération");
                 alert.show();
                 SendEmailTLS () ;

    }

    @FXML
    private void Boutique(ActionEvent event) {
     Categorie.setText("Boutique");
    }

    @FXML
    private void Boutique(Event event) {
         Categorie.setText("Boutique");
    }

    @FXML
    private void Coach(ActionEvent event) {
        Categorie.setText("Coach");
    }

    @FXML
    private void Coach(Event event) {
         Categorie.setText("Coach");
    }

    @FXML
    private void Compte(ActionEvent event) {
         Categorie.setText("Compte");
    }

    @FXML
    private void Compte(Event event) {
         Categorie.setText("Compte");
    }
    public String date ()
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         System.out.println(dft.format(now));
         return dft.format(now) ;
    }  
 


public void SendEmailTLS () {

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
            message.setSubject("Reclamation à propos : "+Categorie.getText());
            message.setText(""+Contenu.getText());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

