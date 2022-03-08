/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import entities.Client;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author hp
 */
import org.controlsfx.control.Rating;
import services.SendMailService;
import services.ServiceActualite;
import services.ServiceClient;
public class CardLayoutController implements Initializable {

    TextField from;
    TextField to;
    TextField host;

    TextField subject;
    String content;
    @FXML
    private Button sendemail;
    @FXML
    private TextField Receiver;
       final Rating rating = new Rating();
    @FXML
    private TableView<Client > table;
    @FXML
    
    private TableColumn< Client , String> emailneeded;
    
    @FXML
        
    
    private TextField object;
    @FXML
    private TextArea content2;
    @FXML
    private Button retour;
  

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ServiceClient sa = new ServiceClient();
          SendMailService sm = new SendMailService();
          
        List Client = sa.afficheranniversaire();
        
        
        ObservableList list = FXCollections.observableArrayList(Client);
        table.setItems(list);
        
        
        
        emailneeded.setCellValueFactory(new PropertyValueFactory<>("emailClient"));
        
        
                TableColumn<Client, Void > whatever1 = new TableColumn("Action");

        Callback<TableColumn<Client, Void>, TableCell<Client, Void>> cellFactory
           = new Callback<TableColumn< Client, Void>, TableCell <Client, Void>>() 
           {
          
            @Override
            public TableCell<Client, Void> call(final TableColumn<Client, Void> param)
            {
                final TableCell<Client, Void> cell = new TableCell<Client, Void>() {

                    private final Button btn = new Button("email");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Client data = getTableView().getItems().get(getIndex());
                            data.getEmailClient();
                            try {
                                sm.SendMail(data.getEmailClient());
                            } catch (MessagingException ex) {
                                Logger.getLogger(CardLayoutController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
         
                            System.out.println("selectedData: " + data);
                        });
                       
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

       whatever1.setCellFactory(cellFactory);
       table.getColumns().add(whatever1);
        
    
    
       
        // TODO

    }    

    @FXML
    private void SendMail(ActionEvent event) throws MessagingException {
        ServiceClient sc = new ServiceClient();
        //String sql = "Select nom_client from client where DATEDIFF(NOW(),date_naiss)=0)   + ";
       // System.out.println(sql);
        System.out.println("Entrain d'envoyer l'email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "gofitesprit@gmail.com";
        //Your gmail password
        String password = "gofitesprit123";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
       String recepient = Receiver.getText();
 
        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient );

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           
            message.setSubject("Joyeux Anniversaire");
            String content="Joyeux Anniversaire cher client! Nous aimerons vous célébrer avec ce Coupon de Reduction de 20% , valable sur tout le site, pour Aujourd'hui";
    
            message.setContent(content, "text/html");
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
           retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(CardLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
