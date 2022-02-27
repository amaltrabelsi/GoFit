/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import services.ServicesReclamation ;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import entites.Reclamation ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField Contenu;
    @FXML
    private Button Valider;
     ServicesReclamation r =  new ServicesReclamation () ;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Valider(ActionEvent event) {
         Reclamation Rec = new  Reclamation ();
         Rec.setContenu(Contenu.getText());
         r.ajout(Rec);
         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                 alert.setContentText("Votre Reclamtion est prise en considération");
                 alert.show();

    }
    
}
