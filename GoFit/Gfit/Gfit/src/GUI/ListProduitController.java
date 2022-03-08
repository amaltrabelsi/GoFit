/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListProduitController implements Initializable {

    @FXML
    private Button PageAjoutProduit;
    @FXML
    private TableView<Produit> table_produit;
    @FXML
    private TableColumn<Produit, String> nom_Produit;
    @FXML
    private TableColumn<Produit,Integer> quantite_Produit;
    @FXML
    private TableColumn<Produit,String> Code_Produit;
    @FXML
    private TableColumn<Produit, Double> Prix_Produit;
    @FXML
    private TableColumn<Produit, String> categorie_Produit;
    @FXML
    private TableColumn<Produit, String> description_Produit;
    @FXML
    private TextField nomchercher;
    @FXML
    private Button chercher;
    @FXML
    private Button menubt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ServiceProduit sp = new ServiceProduit();
        List produits = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(produits);
        table_produit.setItems(list);
        nom_Produit.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        Code_Produit.setCellValueFactory(new PropertyValueFactory<>("Ref_P"));
        Prix_Produit.setCellValueFactory(new PropertyValueFactory<>("Prix_Uni"));
        categorie_Produit.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        description_Produit.setCellValueFactory(new PropertyValueFactory<>("Description"));
        quantite_Produit.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
      
  TableColumn<Produit, Void> actTitre1 = new TableColumn("Action");
          TableColumn<Produit, Void> actTitre2 = new TableColumn("Action");
          
   Callback<TableColumn<Produit, Void>, TableCell<Produit, Void>> cellFactory
           = new Callback<TableColumn<Produit, Void>, TableCell<Produit, Void>>() {
             @Override
            public TableCell<Produit, Void> call(final TableColumn<Produit, Void> param) {
                final TableCell<Produit, Void> cell = new TableCell<Produit, Void>() {

                    private final Button btn = new Button("Supprimer");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Produit data = getTableView().getItems().get(getIndex());
                            
                            sp.supprimer(data.getProduit_Id());
                            
         
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

        table_produit.getColumns().add(actTitre1);
        // TODO
        
    }    


    private void AccListProduit(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("AjoutProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    

    }

    @FXML
    private void PageAjoutProduit(ActionEvent event) throws IOException {
                 Parent root = FXMLLoader.load(getClass().getResource("AjoutProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
         
    }

    private void PageModifierProduit(ActionEvent event) throws IOException {
                 Parent root = FXMLLoader.load(getClass().getResource("ModifierProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    

    @FXML
    private void cherhcerProduit(ActionEvent event) {
         Produit u = new Produit();
        
            ServiceProduit sp = new ServiceProduit();
            List Produit = sp.afficher();
      
            u.setNom_Produit(nomchercher.getText().toLowerCase());
		List<Produit> listemps = sp.rechercherparnom(u.getNom_Produit());
                for(int i=0;i<listemps.size();i++){
                    u=listemps.get(i);
                }
                 ObservableList list = FXCollections.observableArrayList(u);
                
   table_produit.setItems(list);
        nom_Produit.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        Code_Produit.setCellValueFactory(new PropertyValueFactory<>("Ref_P"));
        Prix_Produit.setCellValueFactory(new PropertyValueFactory<>("Prix_Uni"));
        categorie_Produit.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        description_Produit.setCellValueFactory(new PropertyValueFactory<>("Description"));
         quantite_Produit.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
      
                       
        }

    @FXML
    private void menupage(ActionEvent event) throws IOException {
                       Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    
    
}
