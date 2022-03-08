/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Produit;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ClientController implements Initializable {

    @FXML
    private Button ajouterbt;
    @FXML
    private Button Commndebt;
    @FXML
    private Button panierbt;
    @FXML
    private Button listproduitbt;
    @FXML
    private TextField clientId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void GoToCart(ActionEvent event) throws IOException {

        try {
   

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
            Parent root = loader.load();
            PanierController controller = loader.getController();
            controller.setClientId((clientId.getText()));
            //Personne.user = ;
            //Personne.user.get
             clientId.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void commande(ActionEvent event) throws IOException {
                       Parent root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void listproduits(ActionEvent event) throws IOException {
                       Parent root = FXMLLoader.load(getClass().getResource("ListProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
}
