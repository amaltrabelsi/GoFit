/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;
import entities.Business;
import java.awt.event.MouseEvent;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.ServiceActualite;
import services.ServiceBusiness;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherListBoutiquesController implements Initializable {

    @FXML
    private TableView<Business> tableactualite;
    @FXML
    private TableColumn<Business, String> nomboutique;
    @FXML
    private TableColumn<Business, String> gerant;
    @FXML
    private TableColumn<Business, String> adresse;
    @FXML
    private TableColumn<Business, Integer> telfix;
    @FXML
    private TableColumn<Business, Integer> telmobile;
    @FXML
    
    private Button btnadd;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ServiceBusiness sb = new ServiceBusiness();
        List Business = sb.afficher();
        ObservableList list = FXCollections.observableArrayList(Business);
        tableactualite.setItems(list);
        nomboutique.setCellValueFactory(new PropertyValueFactory<>("Nom_Business"));
        gerant.setCellValueFactory(new PropertyValueFactory<>("Prenom_Gerant"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        telmobile.setCellValueFactory(new PropertyValueFactory<>("Tel_Portable"));
        telfix.setCellValueFactory(new PropertyValueFactory<>("Tel_Fix"));


        // TODO
 
    
        TableColumn<Business , Void> actTitre1 = new TableColumn("Action");
          
   Callback<TableColumn<Business, Void>, TableCell<Business, Void>> cellFactory
           = new Callback<TableColumn<Business, Void>, TableCell<Business, Void>>() {
          
            @Override
            public TableCell<Business, Void> call(final TableColumn<Business, Void> param) {
                final TableCell<Business, Void> cell = new TableCell<Business, Void>() {

                    private final Button btn = new Button("Supprimer");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                          Business data = getTableView().getItems().get(getIndex());
                            
                            sb.supprimer(data.getBusiness_Id());
                            
                           
                            System.out.println("selectedData: " + data);
                        });
                       
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

       actTitre1.setCellFactory(cellFactory);
       tableactualite.getColumns().add(actTitre1);
        

    }
    

    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void GoToAddBusiness(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AjouterUneBoutique.fxml"));
            Parent root = loader.load();
             AjouterUneBoutiqueController controller = loader.getController();    
            btnadd.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherListBoutiquesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) {
          
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
           retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherListBoutiquesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    

    }
    
    
