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
import entites.Reclamation;
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
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.connexion;

/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class ReclamationadminController implements Initializable {

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> categorie;
    @FXML
    private TableColumn<?, ?> contenu;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TextField id_supp;
    @FXML
    private Button supprimer;
  ServicesReclamation r =  new ServicesReclamation () ;
    @FXML
    private Button actualise;
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
    @FXML
    private MenuItem Boutique;
    @FXML
    private MenuItem Coach;
    @FXML
    private MenuItem Vendeur;
    @FXML
    private SplitMenuButton Ca;
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
        
    }
        @FXML

 private void supprimer(ActionEvent event) {
    
     r.supprimer(Integer.valueOf(id_supp.getText()));
    afficher();
          
    }

    @FXML
    private void modifier(ActionEvent event) {
        Reclamation Recla = new Reclamation();
        Recla.setReclamation_Id(Integer.valueOf(idmodif.getText()));
        Recla.setContenu(Contenu.getText());
         Recla.setCategorie(Categorie.getText());
         Recla.setEmail(emailmodif.getText());
         Recla.setDate(date());
         r.modifier(Recla);
         tableview.refresh();
    }
         public String date ()
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         System.out.println(dft.format(now));
         return dft.format(now) ;
    }

    @FXML
    private void Boutique(ActionEvent event) {
        Ca.setText("boutique");
        
    }

    @FXML
    private void Boutique(Event event) {
         Ca.setText("boutique");
    }

    @FXML
    private void Coach(ActionEvent event) {
         Ca.setText("coach");
    }

    @FXML
    private void Coach(Event event) {
         Ca.setText("coach");
    }

    @FXML
    private void Vendeur(ActionEvent event) {
         Ca.setText("vendeur");
    }

    @FXML
    private void Vendeur(Event event) {
         Ca.setText("vendeur");
    }

    

    @FXML
    private void ca(ActionEvent event) throws SQLException {
         Connection cnx;
  String co = Ca.getText();
        cnx = connexion.getInstance().getConnection();
     System.out.println();
            String req ="select * from Reclamation WHERE Categorie ='"+co+"' ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                ObservableList  list= FXCollections.observableArrayList();
       list.add(new Reclamation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
       tableview.setItems(list); 
       id.setCellValueFactory(new PropertyValueFactory<>("Reclamation_Id"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        contenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        
        
    }
}
}
  