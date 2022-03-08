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
import javafx.scene.control.TableView;
import services.ServicesReclamation;
import entities.service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServicesReclamation;
import entities.Reclamation;
import javafx.scene.input.MouseEvent;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class ReclamationadminController implements Initializable {

    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<Reclamation, String> email;
    @FXML
    private TableColumn<Reclamation, String> categorie;
    @FXML
    private TableColumn<Reclamation, String> contenu;
    @FXML
    private TableColumn<Reclamation, String> date;
    @FXML
    private TableColumn<Reclamation, Integer> id;
    private TextField id_supp;
    @FXML
    private Button supprimer;
  ServicesReclamation r =  new ServicesReclamation () ;
    @FXML
    private TextField Categorie;
    @FXML
    private TextArea Contenu;
    @FXML
    private Button modifier;
    @FXML
    private TextField idmodif;
    @FXML
    private TextField emailmodif;
    private SplitMenuButton Ca;
    private TextField chercher;
    @FXML
    private TextField mot;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    afficher();
    }    
   
    public void afficher (){
        
        ServicesReclamation r =  new ServicesReclamation () ;
       List reclamation = r.afficher();
        ObservableList list = FXCollections.observableArrayList(reclamation);
        tableview.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("Reclamation_Id"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        contenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        FilteredList<Reclamation> filteredData = new FilteredList<>(list, b -> true);
		
		mot.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Reclamation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				 if (Reclamation.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				
				}
				     else  
				    	 return false; 
			});
		});
                SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
    }
        @FXML

 private void supprimer(ActionEvent event) {
    
     r.supprimer(Integer.valueOf(idmodif.getText()));
     
    afficher();
          
    }

    @FXML
    private void modifier(ActionEvent event) {
        Reclamation Recla = new Reclamation();
        Recla.setReclamation_Id(Integer.valueOf(idmodif.getText()));
        Recla.setContenu(Contenu.getText());
         Recla.setCategorie(Categorie.getText());
         Recla.setmdpgmail(emailmodif.getText());
         Recla.setDate(date());
         r.modifier(Recla);
          afficher();
    }
         public String date ()
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         System.out.println(dft.format(now));
         return dft.format(now) ;
    }

    private void Boutique(ActionEvent event) {
        Ca.setText("boutique");
        
    }

    private void Boutique(Event event) {
         Ca.setText("boutique");
    }

    private void Coach(ActionEvent event) {
         Ca.setText("coach");
    }

    private void Coach(Event event) {
         Ca.setText("coach");
    }

    private void Vendeur(ActionEvent event) {
         Ca.setText("vendeur");
    }

    private void Vendeur(Event event) {
         Ca.setText("vendeur");
    }
@FXML
    private void handleMouseActionn(MouseEvent event) {
       Reclamation Reclamation = tableview.getSelectionModel().getSelectedItem();
       
       idmodif.setText(""+ Reclamation.getReclamation_Id());
       emailmodif.setText(""+ Reclamation.getmdpgmail()    );
        Categorie.setText("" + Reclamation.getCategorie());
        Contenu.setText("" + Reclamation.getContenu());
     
        
    
    }
   
          
    }

    
