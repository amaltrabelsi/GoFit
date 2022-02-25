/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Utilisateur;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServiceUtilisateur;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class ConnexionController implements Initializable {

    Connection cnx;

    @FXML
    private TextField email;
    @FXML
    private PasswordField role;
    @FXML
    private Button connexion;
    @FXML
    private Hyperlink mdpoublié;
    @FXML
    private Hyperlink inscription;
    @FXML
    private PasswordField mdp;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private Label invalid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     cnx = MyDB.getInstance().getConnection();
    }

    @FXML
        
    
    
    private void connexion(ActionEvent event) {
       
     String e  = email.getText().toString();
     String m  = mdp.getText().toString();
     String r  = role.getText().toString();
     
     //query 
     try {
            String req ="select * from utilisateur where e= ? and m = ? and role = ? ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
        	      			
            while(rs.next()){
                Utilisateur s = new Utilisateur ();
                s.setUtilisateur_Id(rs.getInt(1));
                s.setNom(rs.getString("Nom"));
                s.setPrenom(rs.getString("Prenom"));
                s.setEmail(rs.getString("Email"));
                s.setDate_de_naissance(rs.getDate("Date_de_naissance"));
                s.setSexe(rs.getString("Sexe"));
                s.setRegion(rs.getString("Region"));
                s.setAdresse(rs.getString("Adresse"));
                s.setRole(rs.getString("Role"));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void mdpoublié(ActionEvent event) {
    }

}
