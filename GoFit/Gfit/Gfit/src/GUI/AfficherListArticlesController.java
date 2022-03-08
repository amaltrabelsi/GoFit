/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import services.ServiceActualite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherListArticlesController implements Initializable {
//Actualite Actualite = null;
    @FXML
    private TableView<Actualite> tableactualite;
    @FXML
  
    private TableColumn<Actualite , String> actTitre;
    @FXML
    private TableColumn<Actualite , String> ActDescri;
    @FXML
    private TableColumn<Actualite , String> actAction;
    @FXML
    private Button btnadd;
    @FXML
    private ImageView imgretour;
    @FXML
    private Button retour;
    @FXML
    private Button btnlookup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ServiceActualite sa = new ServiceActualite();
        List Actualites = sa.afficher();
        ObservableList list = FXCollections.observableArrayList(Actualites);
        tableactualite.setItems(list);
        actTitre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        ActDescri.setCellValueFactory(new PropertyValueFactory<>("Description"));
        actAction.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        // TODO
 
    
        TableColumn<Actualite, Void> actTitre1 = new TableColumn("Action");
          TableColumn<Actualite, Void> actTitre2 = new TableColumn("Action");
          
   Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory
           = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
          
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {

                    private final Button btn = new Button("Supprimer");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Actualite data = getTableView().getItems().get(getIndex());
                            
                            sa.supprimer(data.getActualite_Id());
                            
         
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
    private void GoToAddArticle(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AjouterUnArticle.fxml"));
            Parent root = loader.load();
             AjouterUnArticleController controller = loader.getController();
           
            //Personne.user = ;
            //Personne.user.get
            btnadd.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @FXML
    private void GoToFindArticle(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/rechercherAtualit.fxml"));
            Parent root = loader.load();
            RechercherActualiteController controller = loader.getController();
           
            //Personne.user = ;
            //Personne.user.get
            btnadd.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherListArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
    
