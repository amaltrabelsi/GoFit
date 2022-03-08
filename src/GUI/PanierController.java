/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Commande;
import entities.Panier;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.ServiceCommande;
import services.ServicePanier;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PanierController implements Initializable {

    @FXML
    private Label votrepanier;
    @FXML
    private TableView<Panier> panierproduit;
    @FXML
    private Button pageProduitsbt;
    @FXML
    private Button viderpanierbt;
    @FXML
    private Button passerCommandebt;
  
    @FXML
    private TableColumn<Panier,String > nom_pp;
    @FXML
    private TableColumn<Panier, String> categorie_pp;
    @FXML
    private TableColumn<Panier,  Double> prixpp;
    @FXML
    private TableColumn<Panier, String> ref_pp;
    @FXML
    private TextField clientid;
          ServicePanier sp = new ServicePanier();
    @FXML
    private TextField searchProductByID;
    @FXML
    private TextField total;
    ServiceCommande sc = new ServiceCommande();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    String totalstring = String.valueOf(sp.calculerTotalParIdClient(3)) ; 
     
           
   total.setText(totalstring);
        List produits = sp.afficherPanierParClient(3);
        ObservableList list = FXCollections.observableArrayList(produits);
        panierproduit.setItems(list);
        nom_pp.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        categorie_pp.setCellValueFactory(new PropertyValueFactory<>("Ref_P"));
        prixpp.setCellValueFactory(new PropertyValueFactory<>("Prix_Uni"));
        ref_pp.setCellValueFactory(new PropertyValueFactory<>("Code_Panier"));
        TableColumn<Panier, Void> actTitre1 = new TableColumn("Action");
          TableColumn<Panier, Void> actTitre2 = new TableColumn("Action");
          
   Callback<TableColumn<Panier, Void>, TableCell<Panier, Void>> cellFactory
           = new Callback<TableColumn<Panier, Void>, TableCell<Panier, Void>>() {
             @Override
            public TableCell<Panier, Void> call(final TableColumn<Panier, Void> param) {
                final TableCell<Panier, Void> cell = new TableCell<Panier, Void>() {

                    private final Button btn = new Button("Supprimer");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Panier data = getTableView().getItems().get(getIndex());
                            
                            sp.supprimer(data.getPanierAjout_Id());
                            
         
                            System.out.println("selectedData: " + data);
                              refreshTable();
                                   String totalstring = String.valueOf(sp.calculerTotalParIdClient(3)) ; 
     
           
                                 total.setText(totalstring);
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

        panierproduit.getColumns().add(actTitre1);
        // TODO
    

        // TODO
    }    
    public void setClientId(String username) {
        clientid.setText(username);
        return ;
    }
    @FXML
    private void pageProduits(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("ListProduit.fxml"));
              Scene scene = new Scene(root);
             
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }

    @FXML
    private void viderpanier(ActionEvent event) {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de vidage du panier");
        alert.setHeaderText(null);
        alert.setContentText("Vouliez vous vider le panier ? ");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) { 
            sp.ViderPanierParClientId(3);
            refreshTable();
            



        }
        
    }

    @FXML
    private void passerCommande(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Passer Commande");
        alert.setHeaderText(null);
        Double totalcommande=sp.calculerTotalParIdClient(3);
        String totalstring = String.valueOf(totalcommande) ; 
         TextInputDialog td = new TextInputDialog("enter any text");
        alert.setContentText("Votre total est : "+totalstring);
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) { 
            sp.ViderPanierParClientId(3);
            refreshTable(); 
            
           Commande c= new Commande();
                   
      //  p.setTotal(totalcommande);
       // String pu=Prix_U.getText();
      //  p.setNom_Produit(Nom_Produit.getText());
      // p.setPath_Image(imgUrl.getText());
      //  p.setRef_P(Code_Produit.getText());
       // String quant =quantite.getText();
      //  int intquantit=Integer.parseInt(quant);
       // Double doubleprix=Double.parseDouble(pu);
         
        // p.setQuantite(intquantit);
          
          
          
         //  p.setDescription(Description_Produit.getText());
         // sp.ajout(p);
           
           
            



        }
        
        
    }


    private void refreshTable() {

        List<Panier> mesProduits =sp.afficherPanierParClient(3);
        ObservableList<Panier> ObservableListproduits = FXCollections.observableArrayList(mesProduits);
        panierproduit.setItems(ObservableListproduits);
        FilteredList<Panier> filteredProducts = new FilteredList<>(ObservableListproduits, b -> true);
        searchProductByID.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredProducts.setPredicate(p -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchProductKeyword = newValue.toLowerCase();
                if (String.valueOf(p.getCode_Panier()).toLowerCase().contains(searchProductKeyword)) {
                    return true;
                } else if (p.getNom_Produit().toLowerCase().contains(searchProductKeyword)) {
                    return true;
                } else if (p.getRef_P().toLowerCase().contains(searchProductKeyword)) {
                    return true;
                }  else if (String.valueOf(p.getPrix_Uni()).toLowerCase().contains(searchProductKeyword)) {
                    return true;
                } 

                return false;
            });
        });

        SortedList<Panier> sortedProducts = new SortedList<>(filteredProducts);
        sortedProducts.comparatorProperty().bind(panierproduit.comparatorProperty());
        panierproduit.setItems(sortedProducts);

    }
    
}
