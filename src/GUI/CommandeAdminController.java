/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Commande;
import entities.Commande;
import java.net.URL;
import java.sql.Date;

import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceCommande;
import services.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CommandeAdminController implements Initializable {

    @FXML
    private TableView<Commande> commandetable;
    @FXML
    private TableColumn<Commande, Integer> comcol;
    @FXML
   private TableColumn<Commande, Date> datecol;
    @FXML
    private TableColumn<Commande, String> modecol;
    @FXML
    private TableColumn<Commande, Double> totalcol;
    @FXML
    private Button menuid;
 //   private DatePicker datefield;
    @FXML
    private TextField modefield;
    @FXML
    private TextField totalfield;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
        ServiceCommande sp = new ServiceCommande();
       Commande p = new Commande();
        List Eventss = sp.afficher();
        
        ObservableList list = FXCollections.observableArrayList(Eventss);
    
   ObservableList<Commande> allEvents;
   ObservableList<Commande> selectedevents;
    @FXML
    private TableColumn<Commande, Integer> nbprodcol;
    @FXML
    private TextField nbfield;
    @FXML
    private Button supprimer;
   
    @FXML
   public void modifier (ActionEvent event) {
            
        ServiceCommande sp = new ServiceCommande();
       // String commande = comfield.getText().toString().toLowerCase();
                Integer nb = Integer.valueOf(nbfield.getText().toLowerCase());

        String mode = modefield.getText().toString().toLowerCase();
        Double total = Double.valueOf(totalfield.getText().toLowerCase());
         
        selectedevents = commandetable.getSelectionModel().getSelectedItems();
        if (selectedevents.size() > 0) {
            
           

			for (Commande u : selectedevents){
                            
                     Commande E=new Commande(u.getCommande_Id(), total ,nb , mode );
                              sp.modifier(E);
                        
                        }

           
        
        
        }
        commandetable.refresh(); 
   }
   public void initdata (Commande u){
  String n =String.valueOf(u.getCommande_Id());
        comcol.setText(n);  
          
     //  datecol.setValue(u.getDate_C().toLocalDate());
        
        modecol.setText(u.getMode_Paiement());
       String tot =String.valueOf(u.getTotal());
        totalcol.setText(tot);  
     
     
    
        
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ServiceCommande sp = new ServiceCommande();
        List Eventss = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Eventss);
        commandetable.setItems(list);
        
         comcol.setCellValueFactory(new PropertyValueFactory<>("Commande_Id"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("Date_C"));
                nbprodcol.setCellValueFactory(new PropertyValueFactory<>("Nb_Produit"));

         modecol.setCellValueFactory(new PropertyValueFactory<>("Mode_Paiement"));
         totalcol.setCellValueFactory(new PropertyValueFactory<>("Total"));
          }    

    @FXML
    private void gotomenu(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
           ServiceCommande sp = new ServiceCommande();
       // String commande = comfield.getText().toString().toLowerCase();
       
         
        selectedevents = commandetable.getSelectionModel().getSelectedItems();
        if (selectedevents.size() > 0) {
            
           

			for (Commande u : selectedevents){
                            
                     sp.supprimer(u.getCommande_Id());
                        
                        }

          
        
        }
        commandetable.refresh(); 
   }
    }
