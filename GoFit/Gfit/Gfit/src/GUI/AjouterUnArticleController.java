/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Actualite;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import services.ServiceActualite;

import javafx.scene.Parent;
import javafx.scene.control.Alert;



/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterUnArticleController implements Initializable {
 
    @FXML
    private TextField descriId;
    @FXML
    private TextField titreId;
    @FXML
    private Button articlebutton;
    
    
    ServiceActualite sa = new ServiceActualite();
    @FXML
    private TextArea Contenu_Id;
    @FXML
    private SplitMenuButton Categorie;
    @FXML
    private MenuItem Sport;
    @FXML
    private MenuItem Fitness;
    @FXML
    private Button clearbutton;
    @FXML
    private ImageView imgretour;
    @FXML
    private Button retour;
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // TODO
    }    

    @FXML
    private void AjouterArticle(ActionEvent event) {
     
        Actualite A = new Actualite ();
        A.setTitre(titreId.getText());
        A.setDescription(descriId.getText());
        A.setContenu(Contenu_Id.getText());
        A.setCategorie(Categorie.getText());
        sa.ajout(A);
        

       
    }

    @FXML
    private void Sport(ActionEvent event) {
        Categorie.setText("Sport");
    }

    @FXML
    private void Sport(Event event) {
         Categorie.setText("Sport");
        
    }

    @FXML
    private void Fitness(ActionEvent event) {
         Categorie.setText("Fitness");
        
    }

    @FXML
    private void Fitness(Event event) {
        Categorie.setText("Fitness");
        

    }

    @FXML
    private void resetfields(ActionEvent event) {
        titreId.setText("");
        descriId.setText("");
        Contenu_Id.setText("");
        Categorie.setText("");
        
          
        
    }

    @FXML
    private void retour(ActionEvent event) {
          
             try {
                  
                 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherListArticles.fxml"));
            Parent root = loader.load();
               AfficherListArticlesController controller = loader.getController();
            retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            Logger.getLogger(AjouterUnArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
  
    }
  
