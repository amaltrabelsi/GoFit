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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.ServiceUtilisateur;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ParametreController implements Initializable {
    public String email  ;

    @FXML
    private AnchorPane fenetreparam;
    @FXML
    private Label emailParamétres;
    @FXML
    private TextField prenommodif;
    @FXML
    private TextField mdpmodif;
    @FXML
    private TextField emailmodif;
    @FXML
    private TextField nommodif;
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
    @FXML
    private DatePicker datemodif;
    private Button decoparam;
    @FXML
    private Button back;
    @FXML
    private Button Modifer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    private void Modifier(ActionEvent event) throws SQLException {
          Connection cnx = MyDB.getInstance().getConnection();
         Statement st = cnx.createStatement();
         ServiceUtilisateur r = new ServiceUtilisateur () ;
         Utilisateur rec = new Utilisateur ();
          String m = "select Utilisateur_Id , Utilisateur_Id from utilisateur where Email = '" + email+ "' " ; 
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
    private void back(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Profil.fxml"));
          
            Parent root = loader.load();
            back.getScene().setRoot(root);
                 } catch (IOException ex) {
    }
        

    }

    @FXML
    private void Modifer(ActionEvent event) {
    }

 
    
}
