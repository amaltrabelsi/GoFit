/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import services.ServiceActualite;
import entities.Actualite;
import java.io.IOException;
 
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RechercherActualiteController implements Initializable {

    @FXML
    private AnchorPane recherchepannel;
    private TextField nom_evenement;
    @FXML
    private Button rechercher;
    @FXML
    private TableView<Actualite> table_events;
    @FXML
    private TextField actualite;
    @FXML
     private TableColumn<Actualite, String> title;
    @FXML
    private TableColumn<Actualite, String> Categorie; 
    @FXML
    private TableColumn<Actualite, String> Description;
    @FXML
    private TableColumn<Actualite, String> Contenu;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          assert nom_evenement != null : "fx:id=\"nom_evenement\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert rechercher != null : "fx:id=\"rechercher\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert table_events != null : "fx:id=\"table_events\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert actualite != null : "fx:id=\"actualite\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert Categorie != null : "fx:id=\"Categorie\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert Description != null : "fx:id=\"Description\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert Contenu != null : "fx:id=\"Contenu\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'rechercherAtualit.fxml'.";
		
        ServiceActualite sp = new ServiceActualite();
        List Eventss = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Eventss);
        table_events.setItems(list);
         title.setCellValueFactory(new PropertyValueFactory<>("Titre"));
         Categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
         Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
         Contenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
    }    

    
  ServiceActualite se=new ServiceActualite();
    ObservableList<Actualite> Events = FXCollections.observableArrayList();
   ObservableList<Actualite> allEvents;
   ObservableList<Actualite> selectedevents;
    
    @FXML
	public void SearchEvent(ActionEvent event) {
           Actualite u = new Actualite();
        
            ServiceActualite sp=new ServiceActualite();
            List Event = sp.afficher();
      
            u.setTitre(actualite.getText().toLowerCase());
            
		List<Actualite> listemps = sp.rechercherparnom(u.getTitre());
                for(int i=0;i<listemps.size();i++){
                    u=listemps.get(i);
                }
                 ObservableList list = FXCollections.observableArrayList(u);
            table_events.setItems(list);
          //    System.out.println(list);
         title.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        // System.out.println(title);
         Categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        // System.out.println(Categorie);
         Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
           //       System.out.println(Description);

         Contenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
          String title= "Recherche réalisée avec Succés";
       TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType (type);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
}

    @FXML
     private void retour(ActionEvent event) {
          
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListArticles.fxml"));
            Parent root = loader.load();
           
           retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(RechercherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}