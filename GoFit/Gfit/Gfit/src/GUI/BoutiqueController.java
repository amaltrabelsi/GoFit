/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class BoutiqueController implements Initializable {

    @FXML
    private Button productnavigate;
    @FXML
    private VBox CardLayout;
    @FXML
    private Button notenavigate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void productnavigate(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
            Parent root = loader.load();
            //not sure if we're suppose to do this or nah
            productnavigate.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(BoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void notenavigate(ActionEvent event) {
        
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RateBoutique.fxml"));
            Parent root = loader.load();
           
           notenavigate.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(BoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
