/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class BoutiqueVendeurController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Pane paneId;
    @FXML
    private ScrollPane scrollPaneID;
    @FXML
    private GridPane ptGP;
    @FXML
    private VBox ajoutModifPanel;
    @FXML
    private Label pointdeventeLBL;
    @FXML
    private Label hiddenIdLBL;
    @FXML
    private Button ajouterbtn;
    @FXML
    private Button modifierbtn;
    @FXML
    private Button gererbtn;
    @FXML
    private Button notenavigate;
    @FXML
    private Button boutiquesidebar;
    @FXML
    private Button profilsidebar;
    @FXML
    private Button servicesidebar;
    @FXML
    private Button actualitesidebar;
    @FXML
    private Button reclamationsidebar;

    /**
     * Initializes the controller class.
     */
    @Override
      public void initialize(URL url, ResourceBundle rb) {
           ajoutModifPanel.setVisible(false);
        LoadData();
        
        // TODO
    }    
    private void LoadData() {
        loadGP();
                System.out.println("erreur 000");


    }
//LOAD DATA IN GRIDPANE
    private void loadGP() {
                System.out.println("erreur 00");

        int maxColumns = 2;
        /*if(ajoutModifPanel.isVisible()){
            maxColumns = 2;
            
        }else{
            maxColumns = 3;
            
        }*/

        int column = 0;
        int row = 0;

        ptGP.getChildren().clear();
        System.out.println("erreur 0");
        ServiceProduit interfaceproduit = new ServiceProduit();

        for (Produit pt : interfaceproduit.afficher()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PtDeVente.fxml"));
                                System.out.println("erreur data pt de vente");

                AnchorPane anchorPane = fxmlLoader.load();
                                System.out.println("erreur data load");
 
                PtdeventeController ptc = fxmlLoader.getController();
                                                System.out.println("erreur data controller");

                ptc.setData(pt);
                                System.out.println("erreur data set data");

                anchorPane.setId(String.valueOf(pt.getProduit_Id()));
                System.out.println("erreur 00 id");

                if (column == maxColumns) {
                    column = 0;
                    row++;
                }

                ptGP.add(anchorPane, column++, row);
            } catch (IOException ex) {

                ex.printStackTrace();
            }

        }

    }
    @FXML
    private void plusButtonClicked(ActionEvent event) throws IOException {
      
    }

 private void getPage(Produit pt, String path) throws IOException {

    }

    private Produit getDataFromScene(Parent scene) {

        Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");
        Label date_ouvLBL = (Label) scene.lookup("#date_ouvLBL");
        Label idLBL = (Label) scene.lookup("#idLBL");

        return new Produit(
                Integer.parseInt(idLBL.getText()),
                nameLBL.getText(), 
                proprietaireLBL.getText(), 
                adressLBL.getText(), 
                date_ouvLBL.getText());
   
    
    }

    
  
    private void clearDataTF() {
        
  
    }

    private void LoadInTF(Produit pt) {
  
    

    }

   

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(s);
        alert.setContentText(null);

        alert.showAndWait();

    }

    @FXML
    private void onGP_clicked(MouseEvent event) throws IOException {
        
        Node source = (Node)event.getTarget() ;
        Produit targetPoint = getDataFromScene(source.getParent().getParent());
       
        if(source.getParent() instanceof Label){
        if(((Label)source.getParent()).getText().equals("MODIFIER")){
            
            LoadInTF(targetPoint);
            ajoutModifPanel.setVisible(true);
            loadGP();
        }else{
            getPage(targetPoint,"AjouterArticle.fxml");
        }
        }else{
            getPage(targetPoint,"AjouterArticle.fxml");
        }
        
       
    }

    @FXML
    private void notenavigate(ActionEvent event) {
    }


    @FXML
    private void xAjouterModifierClicked(ActionEvent event) {
    }

    @FXML
    private void BoutiqueSidebar(ActionEvent event) {
              try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/BoutiqueCoteClient.fxml"));
            Parent root = loader.load();
            BoutiqueCoteClientController controller = loader.getController();    
            boutiquesidebar.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherArticlesClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ProfilSidebar(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Profil.fxml"));
            Parent root = loader.load();
         ProfilController controller = loader.getController();    
            profilsidebar.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherArticlesClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ServiceSidebar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Service.fxml"));
            Parent root = loader.load();
            ServiceController controller = loader.getController();    
            servicesidebar.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherArticlesClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ActualiteSidebar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherArticlesClients.fxml"));
            Parent root = loader.load();
           AfficherArticlesClientsController controller = loader.getController();    
            actualitesidebar.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherArticlesClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ReclamationSidebar(ActionEvent event) {
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Reclamation.fxml"));
            Parent root = loader.load();
          ReclamationController controller = loader.getController();    
          reclamationsidebar.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherArticlesClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
@FXML
    private void ajouterproduit(ActionEvent event) throws IOException {
                             Parent root = FXMLLoader.load(getClass().getResource("AjoutProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
                 Parent root = FXMLLoader.load(getClass().getResource("ModifierProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void gerer(ActionEvent event) throws IOException {
                               Parent root = FXMLLoader.load(getClass().getResource("ListProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

  
    
}
