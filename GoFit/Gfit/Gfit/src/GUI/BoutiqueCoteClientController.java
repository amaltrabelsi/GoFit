/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Business;
import entities.Business;
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
import services.ServiceBusiness;
import services.ServiceBusiness;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class BoutiqueCoteClientController implements Initializable {

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
    @FXML
    private Button ajouterModifierBTN;
    
    IService<Business> interfaceclient = new ServiceBusiness();
    PtdeventeController gstC = new PtdeventeController();
  IService<Business>   interfacebusiness = new ServiceBusiness();

    private Business clientinstance;
    @FXML
    private Button notenavigate;
    @FXML
    private TextField adresseTF1;
    @FXML
    private Button rate;
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

        for (Business pt : interfaceclient.afficher()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PtDeVente.fxml"));
                                System.out.println("erreur data");

                AnchorPane anchorPane = fxmlLoader.load();
                                System.out.println("erreur data");

                PtdeventeController ptc = fxmlLoader.getController();
                                                System.out.println("erreur data");

                ptc.setData(pt);
                                System.out.println("erreur data");

                anchorPane.setId(String.valueOf(pt.getBusiness_Id()));
                System.out.println("erreur 00");

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
         Node source = (Node) event.getTarget();
        Business targetPoint = getDataFromScene(source.getParent().getParent());

        if (source.getParent() instanceof Label) {
            if (((Label) source.getParent()).getText().equals("MODIFIER")) {

                LoadInTF(targetPoint);
                ajoutModifPanel.setVisible(true);
                loadGP();

            } else {
                getPage(targetPoint, "Boutique.fxml");
            }
        } else {
            getPage(targetPoint, "Boutique.fxml");
        }
    }

 private void getPage(Business pt, String path) throws IOException {

    }

    private Business getDataFromScene(Parent scene) {

        Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");
        Label date_ouvLBL = (Label) scene.lookup("#date_ouvLBL");
        Label idLBL = (Label) scene.lookup("#idLBL");

        return new Business(Integer.parseInt(idLBL.getText()), nameLBL.getText(), proprietaireLBL.getText(), adressLBL.getText(), date_ouvLBL.getText());
   
    
    }

    @FXML
    private void ajouterModifierBTN_clicked(ActionEvent event) throws IOException {

      
         
        if(ajouterModifierBTN.getText().equals("Ajouter")){
          String Business_Id = hiddenIdLBL.getText();
                    String Nom_Business = nameTF.getText();

          System.out.println(Business_Id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("boutique2.fxml")); 
       root = loader.load();
       
       Boutique2Controller  rateboutiquecontroller = loader.getController();
       rateboutiquecontroller.displaybus(String.valueOf(Business_Id));
         rateboutiquecontroller.displaynamee(String.valueOf(Nom_Business));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            ajoutModifPanel.setVisible(false);
            loadGP();
        }else{
              String Business_Id = hiddenIdLBL.getText();
                    String Nom_Business = nameTF.getText();

          System.out.println(Business_Id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("boutique2.fxml")); 
       root = loader.load();
       
       Boutique2Controller  rateboutiquecontroller = loader.getController();
       rateboutiquecontroller.displaybus(String.valueOf(Business_Id));
         rateboutiquecontroller.displaynamee(String.valueOf(Nom_Business));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            ajoutModifPanel.setVisible(false);
            loadGP();
        }
       
}
    
    @FXML
    private void xAjouterModifierClicked(ActionEvent event) {
        clearDataTF();
        ajoutModifPanel.setVisible(false);
        loadGP();
    }

    private void clearDataTF() {
        pointdeventeLBL.setText("Ajouter Business");
        hiddenIdLBL.setText("0");
        nameTF.setText("");
        proprioTF.setText("");
        adresseTF.setText("");
        dateouvTF.setValue(LocalDate.now());
        ajouterModifierBTN.setText("Ajouter");
    }

    private void LoadInTF(Business pt) {
       pointdeventeLBL.setText("Consulter Boutique");
        hiddenIdLBL.setText(String.valueOf(pt.getBusiness_Id()));
        nameTF.setText(pt.getNom_Business());
        proprioTF.setText(pt.getRegion());
        adresseTF.setText(pt.getTel_Fix());
        adresseTF1.setText(pt.getDescription());
        ajouterModifierBTN.setText(" => Produits");

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
        Business targetPoint = getDataFromScene(source.getParent().getParent());
       
        if(source.getParent() instanceof Label){
        if(((Label)source.getParent()).getText().equals("MODIFIER")){
            
            LoadInTF(targetPoint);
            ajoutModifPanel.setVisible(true);
            loadGP();
            
        }else{
            getPage(targetPoint,"AjouterUneBoutique.fxml");
        }
        }else{
            getPage(targetPoint,"AjouterUneBoutique.fxml");
        }
        
       
    }

    @FXML
    private void notenavigate(ActionEvent event) {
    }


    @FXML
    private void rate(ActionEvent event) throws IOException {
        
          String Business_Id = hiddenIdLBL.getText();
                    String Nom_Business = nameTF.getText();

          System.out.println(Business_Id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RateBoutique.fxml")); 
       root = loader.load();
       
       RateBoutiqueController  rateboutiquecontroller = loader.getController();
       rateboutiquecontroller.display(String.valueOf(Business_Id));
         rateboutiquecontroller.displayname(String.valueOf(Nom_Business));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
