/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.IService;
import services.ServiceActualite;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherArticlesClientsController implements Initializable {
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
    private TextField nameTF;
    @FXML
    private TextField proprioTF;
    @FXML
    private TextField adresseTF;
    private DatePicker dateouvTF;
    private Button ajouterModifierBTN;
    
    PtdeventeController gstC = new PtdeventeController();
  IService<Actualite>   interfacearticle = new ServiceActualite();

    private Actualite clientinstance;
    @FXML
    private Button notenavigate;
    @FXML
    private TextField adresseTF1;
  private Stage stage;
    private Scene scene;
    private Parent root;
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

        for (Actualite pt : interfacearticle.afficher()) {
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

                anchorPane.setId(String.valueOf(pt.getActualite_Id()));
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

 private void getPage(Actualite pt, String path) throws IOException {

    }

    private Actualite getDataFromScene(Parent scene) {

        Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");
        Label date_ouvLBL = (Label) scene.lookup("#date_ouvLBL");
        Label idLBL = (Label) scene.lookup("#idLBL");

        return new Actualite(
                Integer.parseInt(idLBL.getText()),
                nameLBL.getText(), 
                proprietaireLBL.getText(), 
                adressLBL.getText(), 
                date_ouvLBL.getText());
   
    
    }

    
  
    private void clearDataTF() {
        pointdeventeLBL.setText("Consulter Article");
        hiddenIdLBL.setText("0");
        nameTF.setText("");
        proprioTF.setText("");
        adresseTF.setText("");
        dateouvTF.setValue(LocalDate.now());
        ajouterModifierBTN.setText("Consulter");
    }

    private void LoadInTF(Actualite pt) {
       pointdeventeLBL.setText("Consulter Actualite");
        hiddenIdLBL.setText(String.valueOf(pt.getActualite_Id()));
        nameTF.setText(pt.getCategorie());
        proprioTF.setText(pt.getTitre());
        adresseTF.setText(pt.getTitre());
        adresseTF1.setText(pt.getContenu());
    

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
        Actualite targetPoint = getDataFromScene(source.getParent().getParent());
       
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

}