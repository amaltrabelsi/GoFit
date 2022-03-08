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

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProfilAdminController implements Initializable {

    @FXML
    private Button productnavigate;
    @FXML
    private Button notenavigate;
    @FXML
    private Button consulteractualitesbtn;
    @FXML
    private Button gererboutiquesbtn;
    @FXML
    private Button modifieractualitesbtn;
    @FXML
    private Button ajouteractualitesbtn;
    @FXML
    private Button gererboutiquesbtn1;
    @FXML
    private Button gererboutiquesbtn11;
    @FXML
    private Button anniversairebtn;
    @FXML
    private Button anniversairebtn1;
    @FXML
    private Button res1;
    @FXML
    private Button rec1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void productnavigate(ActionEvent event) {
    }

    @FXML
    private void notenavigate(ActionEvent event) {
    }

    @FXML
    private void consulteractualitesbtn(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListArticles.fxml"));
            Parent root = loader.load();
           
          consulteractualitesbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   

    @FXML
    private void modifieractualitesbtn(ActionEvent event) {
 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierArticle.fxml"));
            Parent root = loader.load();
           
           gererboutiquesbtn1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

    @FXML
    private void ajouteractualitesbtn(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterUnArticle.fxml"));
            Parent root = loader.load();
           
           ajouteractualitesbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void gererboutiquesbtn(ActionEvent event) {
        
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListBoutiques.fxml"));
            Parent root = loader.load();
          gererboutiquesbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void modifierboutique(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/ModifierUneBoutique.fxml"));
            Parent root = loader.load();
             ModifierUneBoutiqueController controller = loader.getController();    
            gererboutiquesbtn11.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouterboutique(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AjouterUneBoutique.fxml"));
            Parent root = loader.load();
             AjouterUneBoutiqueController controller = loader.getController();    
            gererboutiquesbtn11.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotobirthdayemail(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CardLayout.fxml"));
            Parent root = loader.load();
          anniversairebtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotocommande(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/CommandeAdmin.fxml"));
            Parent root = loader.load();
            CommandeAdminController controller = loader.getController();    
            anniversairebtn1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void res(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Reservation.fxml"));
            Parent root = loader.load();
            ReservationController controller = loader.getController();    
           res1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rec(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/ReclamationAdmin.fxml"));
            Parent root = loader.load();
            ReclamationadminController controller = loader.getController();    
         rec1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
