/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import services.ServiceUtilisateur;
import entities.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author TRABELSI Amaal
 */
public class LISTEUSERController implements Initializable {

    @FXML
    private TableColumn<Utilisateur, String> id;
    @FXML
    private TableColumn<Utilisateur, String> nom;
    @FXML
    private TableColumn<Utilisateur, String> prenom;
    @FXML
    private TableColumn<Utilisateur, String> email;
    @FXML
    private TableColumn<Utilisateur, String> tel;
    @FXML
    private TableColumn<Utilisateur, String> date;
    @FXML
    private TableColumn<Utilisateur, String> role;
    @FXML
    private TableColumn<Utilisateur, String> region;
    @FXML
    private TableColumn<Utilisateur, String> adresse;
    @FXML
    private TableColumn<Utilisateur, String> sexe;

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<Utilisateur, String> mdp;
    @FXML
    private Button supprimer;
    @FXML
    private TextField idd;
    ServiceUtilisateur su = new ServiceUtilisateur () ;
    @FXML
    private TextField idmodif;
    @FXML
    private TextField prenommodif;
    @FXML
    private TextField adressemodif;
    @FXML
    private TextField rolemodif;
    @FXML
    private TextField regionmodif;
    @FXML
    private TextField sexemodif;
    @FXML
    private TextField nummodif;
    @FXML
    private TextField nommodif;
    @FXML
    private Button modifier;
    @FXML
    private TextField datemodif;
    @FXML
    private TextField mdpmodif;
    @FXML
    private TextField emailmodif;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
       
    }  
    public void afficher () {
         ServiceUtilisateur su = new ServiceUtilisateur () ;
         List l = su.afficher();
        ObservableList list = FXCollections.observableArrayList(l);
        tableview.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("Utilisateur_Id"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        date.setCellValueFactory(new PropertyValueFactory<>("Date_de_naissance"));
       region.setCellValueFactory(new PropertyValueFactory<>("Region"));
       role.setCellValueFactory(new PropertyValueFactory<>("Role"));
       mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
       
        
    }
    @FXML
 private void supprimer(ActionEvent event) {
            ServiceUtilisateur p = new ServiceUtilisateur () ;
System.out.println(idd.getText());
    p.supprimer(Integer.valueOf(idd.getText()));
    afficher ();
          
    }

    @FXML
    private void modifier(ActionEvent event) {
         ServiceUtilisateur r = new ServiceUtilisateur () ;
         Utilisateur rec = new Utilisateur ();
         rec.setUtilisateur_Id(Integer.valueOf(idmodif.getText()));
         rec.setAdresse(adressemodif.getText());
         rec.setRegion(regionmodif.getText());
         rec.setRole(rolemodif.getText());
         rec.setEmail(emailmodif.getText());
         rec.setSexe(sexemodif.getText());
         rec.setNumero(nummodif.getText());
         rec.setDate_de_naissance(datemodif.getText());
         rec.setMdp(cryptage(mdpmodif.getText()));
         rec.setNom(nommodif.getText());
         rec.setPrenom(prenommodif.getText());
         
         
         r.modifier(rec);
         afficher();
    }
@FXML
    private void handleMouseActionn(MouseEvent event) {
       Utilisateur Utilisateur = (Utilisateur) tableview.getSelectionModel().getSelectedItem();
     idmodif.setText(""+ Utilisateur.getUtilisateur_Id());
     prenommodif.setText(""+ Utilisateur.getPrenom());
    adressemodif.setText(""+ Utilisateur.getAdresse());
    rolemodif.setText(""+ Utilisateur.getRole());
   regionmodif.setText(""+ Utilisateur.getRegion());
     sexemodif.setText(""+ Utilisateur.getSexe());
   nummodif.setText(""+ Utilisateur.getNumero());
   nommodif.setText(""+ Utilisateur.getNom());
    datemodif.setText(""+ Utilisateur.getDate_de_naissance());
    mdpmodif.setText(""+ Utilisateur.getMdp());
   emailmodif.setText(""+ Utilisateur.getEmail());
        
    
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
        // TODO
    

