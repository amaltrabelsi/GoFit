/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import entities.Business;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Boutique2Controller implements Initializable {

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
    
   ServiceProduit interfaceclient = new ServiceProduit();
    PtdeventeController gstC = new PtdeventeController();
  IService<Business>   interfacebusiness = new ServiceBusiness();

    private Produit clientinstance;
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
    private Label notez;
    @FXML
    private Label nameLabel;
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
          //      int x = Integer.parseInt(nameLabel.getText()) ;
          //      System.out.println(x);
            //    String n = notez.getText();
                    //            System.out.println(n);
                 String b = nameLabel.getText();
             //    display(b);
                 System.out.println(b);


    }
//LOAD DATA IN GRIDPANE
    private void loadGP() {
                System.out.println("erreur 00");

        int maxColumns = 2;
        int column = 0;
        int row = 0;

        ptGP.getChildren().clear();
//        System.out.println("erreur 0" +Integer.parseInt(nameLabel.getText()));

        for (Produit pt : interfaceclient.afficherProduitbyBusinessId(11)) {
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

                anchorPane.setId(String.valueOf(pt.getProduit_Id()));
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
        Produit targetPoint = getDataFromScene(source.getParent().getParent());

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

 private void getPage(Produit pt, String path) throws IOException {

    }

    private Produit getDataFromScene(Parent scene) {

        Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");
        Label date_ouvLBL = (Label) scene.lookup("#date_ouvLBL");
        Label idLBL = (Label) scene.lookup("#idLBL");

        return new Produit(Integer.parseInt(idLBL.getText()), nameLBL.getText(), proprietaireLBL.getText(), adressLBL.getText(), date_ouvLBL.getText());
   
    
    }

    @FXML
    private void ajouterModifierBTN_clicked(ActionEvent event) {

      
         
        if(ajouterModifierBTN.getText().equals("Ajouter")){
         Produit point = new Produit(Integer.parseInt(hiddenIdLBL.getText()), nameTF.getText(), proprioTF.getText(), adresseTF.getText(), adresseTF1.getText());
       
            interfaceclient.ajout(point);
            ajoutModifPanel.setVisible(false);
            loadGP();
        }else{
            Produit point = new Produit(Integer.parseInt(hiddenIdLBL.getText()), nameTF.getText(), proprioTF.getText(), adresseTF.getText(), adresseTF1.getText());
            interfaceclient.modifier(point);
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
        pointdeventeLBL.setText("Ajouter Produit");
        hiddenIdLBL.setText("0");
        nameTF.setText("");
        proprioTF.setText("");
        adresseTF.setText("");
        dateouvTF.setValue(LocalDate.now());
        ajouterModifierBTN.setText("Ajouter");
    }

    private void LoadInTF(Produit pt) {
       pointdeventeLBL.setText("Consulter Le Produit");
        hiddenIdLBL.setText(String.valueOf(pt.getProduit_Id()));
        nameTF.setText(pt.getNom_Produit());
        proprioTF.setText(pt.getCategorie());
        adresseTF.setText(pt.getRef_P());
        adresseTF1.setText(pt.getDescription());
        ajouterModifierBTN.setText("Ajouter Au Panier");

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
        
          String Produit_Id = hiddenIdLBL.getText();
                    String Nom_Produit = nameTF.getText();

          System.out.println(Produit_Id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RateBoutique.fxml")); 
       root = loader.load();
       
       RateBoutiqueController  rateboutiquecontroller = loader.getController();
       rateboutiquecontroller.display(String.valueOf(Produit_Id));
         rateboutiquecontroller.displayname(String.valueOf(Nom_Produit));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
public void displaybus(String Business_Id){
              nameLabel.setText(Business_Id);

    }
    
    
      public void displaynamee (String Nom_Business){
             notez.setText("Bienvenue à la boutique    "  +Nom_Business);

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


  


