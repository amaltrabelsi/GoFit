/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import utils.MyDB;
import entities.Utilisateur;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.event.Event;
import javafx.scene.control.MenuItem;
import services.ServiceUtilisateur;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;





/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class InscriptionController implements Initializable {


    @FXML
    private TextField Nom;
    @FXML
    private TextField Email;
    @FXML
    private TextField Prenom;
    @FXML
    private DatePicker date;
    @FXML
    private SplitMenuButton Region;
    @FXML
    private TextField Adresse;
    @FXML
    private Button inscription;
    @FXML
    private SplitMenuButton Role;
   
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
    
   
    @FXML
    private TextField num;
    @FXML
    private AnchorPane inscr1;
    @FXML
    private Label labnumero;
   
    @FXML
    private TextField Code;
    @FXML
    private Button back;
    @FXML
    private PasswordField mdp;
    @FXML
    private SplitMenuButton question;
    @FXML
    private MenuItem q1;
    @FXML
    private MenuItem q2;
    @FXML
    private MenuItem q3;
    @FXML
    private MenuItem q4;
    @FXML
    private MenuItem q5;
    @FXML
    private TextField Reponse;
    @FXML
    private MenuItem Ariana;
    @FXML
    private MenuItem Beja;
    @FXML
    private MenuItem Benarous;
    @FXML
    private MenuItem Bizerte;
    @FXML
    private MenuItem Gabés;
    @FXML
    private MenuItem Gafsa;
    @FXML
    private MenuItem Jendouba;
    @FXML
    private MenuItem Kairaouan;
    @FXML
    private MenuItem kasserine;
    @FXML
    private MenuItem Kébili;
    @FXML
    private MenuItem Kef;
    @FXML
    private MenuItem Gabés16;
    @FXML
    private MenuItem Manouba;
    @FXML
    private MenuItem Médenine;
    @FXML
    private MenuItem Monastir;
    @FXML
    private MenuItem Nabeul;
    @FXML
    private MenuItem Sfax;
    @FXML
    private MenuItem SidiBouzid;
    @FXML
    private MenuItem Siliana;
    @FXML
    private MenuItem Sousse;
    @FXML
    private MenuItem Tataouine;
    @FXML
    private MenuItem Tozeur;
    @FXML
    private MenuItem Tunis;
    @FXML
    private MenuItem Zaghouan;
      /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
                && Adresse.getText().isEmpty() == false &&  mdp.getText().isEmpty() == false
                && Reponse.getText().isEmpty() == false && question.getText().isEmpty() == false
                && Cmdp.getText().isEmpty() == false && text.getText().isEmpty() == false
                && num.getText().isEmpty() == false) {
      
           if  (Nom.getText() == Prenom.getText() ){
                 invalid.setText("Nom et prenom doivent être différents "); }   
       else if (verifemail(Email.getText())== false)
        {
            invalid.setText("Cette Email est invalid ");
        } else if (mdp.getText().length()<8 ) {
            invalid.setText("Le mot de passe ne doit pas étre inferieur à 8 caractere");}
        
        
           else if((mdp.getText() == (Cmdp.getText())) ) {
           
     invalid.setText("Les mots de passe ne sont pas identiques");}
         
         else if ((text.getText() == C)){
          invalid1.setText("Les Deux chaines ne sont pas identiques!");
         } else if ((num.getText().length()!=8) && ( num.getText().substring(1, 2) !="90") &&(num.getText().substring(1, 2)!="91") &&(num.getText().substring(1, 2)!="92") &&(num.getText().substring(1, 2)!="93") &&(num.getText().substring(1, 2)!="94") &&(num.getText().substring(1, 2)!="95")&&(num.getText().substring(1, 2)!="96") &&(num.getText().substring(1, 2)!="97") &&(num.getText().substring(1, 2)!="98") &&(num.getText().substring(1, 2)!="99")
                   &&(num.getText().substring(1, 2)!="40")&&(num.getText().substring(1, 2)!="41")&&(num.getText().substring(1, 2)!="42")&&(num.getText().substring(1, 2)!="44")
                   &&(num.getText().substring(1, 2)!="50")&&(num.getText().substring(1, 2)!="51") && (num.getText().substring(1, 2)!="52") &&(num.getText().substring(1, 2)!="53") &&(num.getText().substring(1, 2)!="54") &&(num.getText().substring(1, 2)!="55")  &&(num.getText().substring(1, 2)!="58")  
                   &&(num.getText().substring(1, 2)!="29") &&(num.getText().substring(1, 2)!="28") &&(num.getText().substring(1, 2)!="27")&&(num.getText().substring(1, 2)!="26") &&(num.getText().substring(1, 2)!="25") &&(num.getText().substring(1, 2)!="24") &&(num.getText().substring(1, 2)!="23") &&(num.getText().substring(1, 2)!="22")&&(num.getText().substring(1, 2)!="21")&&(num.getText().substring(1, 2)!="20") )
           {
              invalid.setText("Numéro est invalide");
           }
         else {
         
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
        u.setReponse(Reponse.getText());
        u.setQuestion(question.getText());
        
        uti.ajout(u);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Connexion.fxml"));
            Parent root = loader.load();
            inscription.getScene().setRoot(root);
           } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }}}
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

   /* @FXML
    private void showvisibility(ActionEvent event) {
        if (boxmdp.isSelected()){
                mdp.setText(hiddenpass.getText());
                mdp.setVisible(true);
                hiddenpass.setVisible(false);
                return;
            }
                hiddenpass.setText(mdp.getText());
                hiddenpass.setVisible(true);
                mdp.setVisible(false);
            }
    
private String getpass(){
    if (mdp.isVisible()){
        return mdp.getText();
        
    }else {
        return hiddenpass.getText();
    }
}*/

    @FXML
    private void q1(ActionEvent event) {
         question.setText("Nom de votre grande mére ? ");
    }

    @FXML
    private void q1(Event event) {
         question.setText("Nom de votre grande mére ? ");
    }

    @FXML
    private void q2(ActionEvent event) {
         question.setText("Votre Langue matérnelle ? ");
    }

    @FXML
    private void q2(Event event) {
        question.setText("Votre Langue matérnelle ? ");
    }

    @FXML
    private void q3(ActionEvent event) {
        question.setText("Nombre de votre famille ?");
    }

    @FXML
    private void q3(Event event) {
                question.setText("Nombre de votre famille ?");

    }

    @FXML
    private void q4(ActionEvent event) {
         question.setText("Combien de soeur avez vous ?");
    }

    @FXML
    private void q4(Event event) {
         question.setText("Combien de soeur avez vous ?");
    }

    @FXML
    private void q5(ActionEvent event) {
         question.setText("Votre serie préférée ");
    }

    @FXML
    private void q5(Event event) {
         question.setText("Votre serie préférée ");
    }
    private boolean verifemail (String email)
    {
       String e ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
       Pattern em = Pattern.compile(e, Pattern.CASE_INSENSITIVE);
       Matcher matcher = em.matcher(email);
        return matcher.find();
    }

    @FXML
    private void Ariana(ActionEvent event) {
        Region.setText("Ariana");
    }

    @FXML
    private void Ariana(Event event) {
        Region.setText("Ariana");
    }

    @FXML
    private void Beja(ActionEvent event) {
        Region.setText("Beja");
    }

    @FXML
    private void Beja(Event event) {
         Region.setText("Beja");
    }

    @FXML
    private void Benarous(ActionEvent event) {
         Region.setText("Ben Arous");
    }

    @FXML
    private void Benarous(Event event) {
         Region.setText("Ben Arous");
    }

    @FXML
    private void Bizerte(ActionEvent event) {
         Region.setText("Bizerte");
    }

    @FXML
    private void Bizerte(Event event) {
         Region.setText("Bizerte");
    }

    @FXML
    private void Gabés(ActionEvent event) {
         Region.setText("Gabés");
    }

    @FXML
    private void Gabés(Event event) {
        Region.setText("Gabés");
    }

    @FXML
    private void Gafsa(ActionEvent event) {
        Region.setText("Gafsa");
    }

    @FXML
    private void Gafsa(Event event) {
           Region.setText("Gafsa");
    }

    @FXML
    private void Jendouba(ActionEvent event) {
           Region.setText("Jendouba");
    }

    @FXML
    private void Jendouba(Event event) {
        Region.setText("Jendouba");
    }

    @FXML
    private void Kairaouan(ActionEvent event) {
        Region.setText("Kairaouan");
    }

    @FXML
    private void Kairaouan(Event event) {
        Region.setText("Kairaouan");
    }

    @FXML
    private void kasserine(ActionEvent event) {
        Region.setText("kasserine");
    }

    @FXML
    private void kasserine(Event event) {
        Region.setText("kasserine");
    }

    @FXML
    private void Kébili(ActionEvent event) {
        Region.setText("Kébili");
    }

    @FXML
    private void Kébili(Event event) {
        Region.setText("Kébili");
    }

    @FXML
    private void Kef(ActionEvent event) {
        Region.setText("Kef");
    }

    @FXML
    private void Kef(Event event) {
        Region.setText("Kef");
    }

    @FXML
    private void Manouba(ActionEvent event) {
        Region.setText("Manouba");
    }

    @FXML
    private void Manouba(Event event) {
         Region.setText("Manouba");
    }

    @FXML
    private void Médenine(ActionEvent event) {
         Region.setText("Médenine");
    }

    @FXML
    private void Médenine(Event event) {
        Region.setText("Médenine");
    }

    @FXML
    private void Monastir(ActionEvent event) {
        Region.setText("Monastir");
    }

    @FXML
    private void Monastir(Event event) {
         Region.setText("Monastir");
    }

    @FXML
    private void Nabeul(ActionEvent event) {
         Region.setText("Nabeul");
    }

    @FXML
    private void Nabeul(Event event) {
         Region.setText("Nabeul");
    }

    @FXML
    private void Sfax(ActionEvent event) {
         Region.setText("Sfax");
    }

    @FXML
    private void Sfax(Event event) {
        Region.setText("Sfax");
    }

    @FXML
    private void SidiBouzid(ActionEvent event) {
        Region.setText("Sidi Bouzid");
    }

    @FXML
    private void SidiBouzid(Event event) {
        Region.setText("Sidi Bouzid");
    }

    @FXML
    private void Siliana(ActionEvent event) {
        Region.setText("Siliana");
    }

    @FXML
    private void Siliana(Event event) {
          Region.setText("Siliana");
    }

    @FXML
    private void Sousse(ActionEvent event) {
          Region.setText("Sousse");
    }

    @FXML
    private void Sousse(Event event) {
        Region.setText("Sousse");
    }

    @FXML
    private void Tataouine(ActionEvent event) {
        Region.setText("Tataouine");
    }

    @FXML
    private void Tataouine(Event event) {
          Region.setText("Tataouine");
    }

    @FXML
    private void Tozeur(ActionEvent event) {
          Region.setText("Tozeur");
    }

    @FXML
    private void Tozeur(Event event) {
        Region.setText("Tozeur");
    }

    @FXML
    private void Tunis(ActionEvent event) {
        Region.setText("Tunis");
    }

    @FXML
    private void Tunis(Event event) {
        Region.setText("Tunis");
    }

    @FXML
    private void Zaghouan(ActionEvent event) {
        Region.setText("Zaghouan");
    }

    @FXML
    private void Zaghouan(Event event) {
        Region.setText("Zaghouan");
    }

    @FXML
    private void Region(ActionEvent event) {
    }
   
   
}
    