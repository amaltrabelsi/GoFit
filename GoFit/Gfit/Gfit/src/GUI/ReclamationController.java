/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.ServicesReclamation;
/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ReclamationController implements Initializable {
    public TextField email1 ;
ServicesReclamation r = new ServicesReclamation();
    @FXML
    private AnchorPane fenetreReclamation;
    @FXML
    private SplitMenuButton Categoriereclamation;
    @FXML
    private MenuItem Boutique;
    @FXML
    private MenuItem Coach;
    @FXML
    private MenuItem Compte;
    @FXML
    private TextArea ContenuReclamation;
    @FXML
    private PasswordField mdpgmail;
    @FXML
    private Button envoyereclamation;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void envoyereclamation(ActionEvent event) {

        SendEmailReclamation () ;
         Reclamation Rec = new  Reclamation ();
         Rec.setContenu(ContenuReclamation.getText());
         Rec.setCategorie(Categoriereclamation.getText());
         Rec.setmdpgmail(mdpgmail.getText());
         Rec.setDate(date());
         r.ajout(Rec);
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                 alert.setContentText("Votre Reclamtion est prise en considération");
                 alert.show();
        

    }

    @FXML
    private void BoutiqueReclamtion(ActionEvent event) {
     Categoriereclamation.setText("Boutique");
    }

    @FXML
    private void BoutiqueReclamtion(Event event) {
        Categoriereclamation.setText("Boutique");
    }

    @FXML
    private void CoachReclamtion(ActionEvent event) {
        Categoriereclamation.setText("Coach");
    }

    @FXML
    private void CoachReclamtion(Event event) {
        Categoriereclamation.setText("Coach");
    }

    @FXML
    private void CompteReclamtion(ActionEvent event) {
         Categoriereclamation.setText("Compte");
    }

    @FXML
    private void CompteReclamtion(Event event) {
         Categoriereclamation.setText("Compte");
    }
    
    public String date ()
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         System.out.println(dft.format(now));
         return dft.format(now) ;
    }  
 


public void SendEmailReclamation () {

        final String username = email1.getText();
        final String password = mdpgmail.getText();
System.out.println(password);
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
            message.setFrom(new InternetAddress("amaltr249@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("gofitbythefive2022@gmail.com")
            );
            message.setSubject("Reclamation à propos : "+Categoriereclamation.getText());
            message.setText(""+ContenuReclamation.getText());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

 
    

    @FXML
    private void back(ActionEvent event) {
                 try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherArticlesClients.fxml"));
            Parent root = loader.load();
          
            back.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
