/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class AvisController implements Initializable {

    @FXML
    private Button Like;
    @FXML
    private Button Dislike;
    @FXML
    private Label message;
    int count = 0 ;
    int count1 = 0 ;
    @FXML
    private Label message1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Dislike(ActionEvent event) {
        count ++ ; 
        message.setText( "" + count + " Je n'aime pas"  );
    }

    @FXML
    private void like(ActionEvent event) {
         count1 ++ ; 
        message1.setText("" + count1 + "     J'aime" );
    }


 
    
}
