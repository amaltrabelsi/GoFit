/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;
import java.io.IOException;
import services.ServiceActualite;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import services.ServiceActualite;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierArticleController implements Initializable {

    @FXML
    private TextField titre_event;
    @FXML
    private TextField descri_event;
    @FXML
    private TextField contenu_event;
    @FXML
    private Button Modifier_event;
    @FXML
    private TableView<Actualite> table_events;
    @FXML
    private TableColumn<Actualite, String> titre;
    @FXML
    private TableColumn<Actualite, String> description;
    @FXML
    private TableColumn<Actualite, String> contenu;
    
ServiceActualite se = new ServiceActualite();
     Actualite u=new Actualite();
     
      ObservableList<Actualite> Actualites = FXCollections.observableArrayList();
   ObservableList< Actualite> allActualite;
   ObservableList< Actualite> selectedActualites;
   
    @FXML
    private AnchorPane ModifierArticle;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
		
		
        
                  ServiceActualite sp = new ServiceActualite();
                  
        List Eventss = sp.afficher();
        
        ObservableList list = FXCollections.observableArrayList(Eventss);
        
        table_events.setItems(list);
           //*nafs l id" *// 
    titre.setCellValueFactory(new PropertyValueFactory<>("Titre")); //nafs les attributs kifma msamyethom fel base"
         description.setCellValueFactory(new PropertyValueFactory<>("Description"));
         contenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
         
        
        }
   
    public void initdata (Actualite u){
      
       
     titre.setText(u.getTitre());
        description.setText(u.getDescription());
        contenu.setText(u.getContenu());
       
        //prix_evenement.setText(u.getPrix().);
       
       
        
        
        
        
    }
      




    @FXML
    private void handleButtonSubmitAction(ActionEvent event) {
        
         ServiceActualite sp = new ServiceActualite();
                              //kima fel champs taa l form"//
        String Titre =       titre_event.getText().toString().toLowerCase();
        String Description = descri_event.getText().toString().toLowerCase();
        String Contenu =    contenu_event.getText().toString().toLowerCase();
       
       
          
        selectedActualites = table_events.getSelectionModel().getSelectedItems();
        
        if (selectedActualites.size() > 0) {
			for (Actualite u : selectedActualites){
                     Actualite E= new Actualite(u.getActualite_Id(),Titre, Description, Contenu);
                              sp.modifier(E);
                        
                        }
          List<  Actualite> listemps = sp.afficher();
	   for (int i = 0; i < listemps.size(); i++) {
		Actualites.add(listemps.get(i));
            }
           table_events.refresh(); 
        
        }
         String title= "Modifieé avec Succés";
      
    }

    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListArticles.fxml"));
            Parent root = loader.load();
           
           retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    }

    

