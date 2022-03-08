/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import services.ServiceActualite;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ListActualiteController implements Initializable {

    @FXML
    private ListView<String> listarticle;
    @FXML
    private Label labelactualite;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ServiceActualite sa = new ServiceActualite();
        List Actualites = sa.afficher();
        ObservableList list = FXCollections.observableArrayList(Actualites);
        listarticle.setItems(list);
    }    
    
}
