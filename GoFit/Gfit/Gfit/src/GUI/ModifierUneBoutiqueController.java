/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;
import entities.Business;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import services.ServiceActualite;
import services.ServiceBusiness;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierUneBoutiqueController implements Initializable {

    @FXML
    private AnchorPane modifierboutique;
    @FXML
    private TextField nomboutique;
    @FXML
    private TextField prenomg;
    @FXML
    private TextField nomg;
    @FXML
    private TextField adresse;
    @FXML
    private TextField region;
    @FXML
    private DatePicker datefonda;
    @FXML
    private TextField telfix;
    @FXML
    private TextField telmobile;
    @FXML
    private TextField descri;
    @FXML
    private Button retour;
    @FXML
    private TableView<Business> tableboutiques;
    @FXML
    private TableColumn<Business, String> tnomboutique;
    @FXML
    private TableColumn<Business, String> tprenom;
    @FXML
    private TableColumn<Business, String> tnom;
    @FXML
    private TableColumn<Business, String> tadresse;
    @FXML
    private TableColumn<Business, String> tregion;
    @FXML
    private TableColumn<Business, String> tdatefonda;
    @FXML
    private TableColumn<Business, String> ttelfix;
    @FXML
    private TableColumn<Business, String> ttelmobile;
    @FXML
    private Button ModifierBoutique;
    @FXML
    private TableColumn<Business, String> tdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          assert nomboutique != null : "fx:id=\"nomboutique\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
          assert nomg != null : "fx:id=\"nomg\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert prenomg != null : "fx:id=\"prenomg\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert datefonda != null : "fx:id=\"datefonda\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert region != null : "fx:id=\"region\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert descri != null : "fx:id=\"descri\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert telmobile != null : "fx:id=\"telmobile\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
          assert telfix != null : "fx:id=\"telfix\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert telmobile != null : "fx:id=\"telmobile\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
	  assert adresse != null : "fx:id=\"adresse\" was not injected: check your FXML file 'ModifierUneBoutique.fxml'.";
		
            ServiceBusiness sp = new ServiceBusiness();
        List Boutiques = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Boutiques);
        

        tableboutiques.setItems(list);
         tnomboutique.setCellValueFactory(new PropertyValueFactory<>("Nom_Business"));
         tprenom.setCellValueFactory(new PropertyValueFactory<>("Prenom_Gerant"));
         tnom.setCellValueFactory(new PropertyValueFactory<>("Nom_Gerant"));
         tadresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
         tregion.setCellValueFactory(new PropertyValueFactory<>("Region"));
         tdatefonda.setCellValueFactory(new PropertyValueFactory<>("Date_Fondation"));
         ttelmobile.setCellValueFactory(new PropertyValueFactory<>("Tel_Portable"));
         ttelfix.setCellValueFactory(new PropertyValueFactory<>("Tel_Fix"));
         tdescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        // TODO
    }    


    @FXML
    private void retour(ActionEvent event) {
        
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
           retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public void initdata (Business u){
      
       
    nomboutique.setText(u.getNom_Business());
    prenomg.setText(u.getPrenom_Gerant());
    nomg.setText(u.getNom_Gerant());
    adresse.setText(u.getAdresse());
    region.setText(u.getRegion());
    datefonda.setValue(u.getDate_Fondation().toLocalDate());
    telfix.setText(u.getTel_Fix());
    telmobile.setText(u.getTel_Portable());
    descri.setText(u.getDescription());
    

    


       
        //prix_evenement.setText(u.getPrix().);
       
       
        
        
        
        
    }
  ObservableList<Business> Events = FXCollections.observableArrayList();
   ObservableList<Business> allEvents;
   ObservableList<Business> selectedevents;
    @FXML
    private void ModifierBoutique(ActionEvent event) {
            
           ServiceBusiness sp = new ServiceBusiness();
    
        String nom = nomboutique.getText().toString().toLowerCase();
        String prenom = prenomg.getText().toString().toLowerCase();
        String description = descri.getText().toString().toLowerCase();
        String nomge = nomg.getText().toString().toLowerCase();
        String reg = region.getText().toString().toLowerCase();
        String add = adresse.getText().toString().toLowerCase();
        String telf = telfix.getText().toString().toLowerCase();
        String telp = telmobile.getText().toString().toLowerCase();
        Date datef = null;
        if (datefonda.getValue() != null) {
           datef = Date.valueOf(datefonda.getValue());
          
        selectedevents = tableboutiques.getSelectionModel().getSelectedItems();
        if (selectedevents.size() > 0) {
        for (Business u : selectedevents){
                Business E= new Business(u.getBusiness_Id(), nom, nomge, prenom, reg, add, datef, description, telp, telf, u.getCompte_Id());
                            sp.modifier(E);
    }
                          }
          List<Business> listemps = sp.afficher();
	   for (int i = 0; i < listemps.size(); i++) {
		Events.add(listemps.get(i));
            }
           tableboutiques.refresh(); 
        
        }
         String title= "Modifieé avec Succés";
       TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType (type);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
        }
   
    
}
