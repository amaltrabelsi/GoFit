/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import entities.Produit;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierProduitController implements Initializable {

    @FXML
    private TextField Code_Produit;
    @FXML
    private TextField quantite;
    @FXML
    private TextArea descrip;
    @FXML
    private TextField Nom_Produit;
    @FXML
    private Button AjouterProduit;
    @FXML
    private TextField Url;
    @FXML
    private TextField categorie;
    @FXML
    private TableView<Produit> tableP;
    @FXML
    private TableColumn<Produit, String> nomp;
    @FXML
    private TableColumn<Produit, String> codep;
    @FXML
    private TableColumn<Produit, Integer> qtep;
    @FXML
    private TableColumn<Produit, String> catp;
    @FXML
    private TableColumn<Produit, String> descp;

    /**
     * Initializes the controller class.
     */
       ServiceProduit sp = new ServiceProduit();
       Produit p = new Produit();
        List Eventss = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Eventss);
    
   ObservableList<Produit> allEvents;
   ObservableList<Produit> selectedevents;
   
   public void handleButtonSubmitAction(ActionEvent event) {
            
        ServiceProduit sp = new ServiceProduit();
        String nom = Nom_Produit.getText().toString().toLowerCase();
        String cate = categorie.getText().toString().toLowerCase();
        String description = descrip.getText().toString().toLowerCase();
        String code = Code_Produit.getText().toString().toLowerCase();
        int q = Integer.valueOf(quantite.getText().toLowerCase());
           
        selectedevents = tableP.getSelectionModel().getSelectedItems();
        if (selectedevents.size() > 0) {
            
           

			for (Produit u : selectedevents){
                            
                     Produit E=new Produit(u.getProduit_Id(),code, u.getPrix_Uni() ,q, description, nom, cate , u.getFk_AvisP_Id() , u.getFk_CommentaireP_Id());
                              sp.modifier(E);
                        
                        }

           tableP.refresh(); 
        
        
        }
   }
   public void initdata (Produit u){
        String n =String.valueOf(u.getRef_P());
        codep.setText(n);
        String p =String.valueOf(u.getQuantite());
        qtep.setText(p);
        descp.setText(u.getDescription());
        nomp.setText(u.getNom_Produit());
        catp.setText(u.getCategorie());
     
    
        
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ServiceProduit sp = new ServiceProduit();
        List Eventss = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Eventss);
        tableP.setItems(list);
        
         nomp.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
         codep.setCellValueFactory(new PropertyValueFactory<>("Ref_P"));
         qtep.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
         catp.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
         descp.setCellValueFactory(new PropertyValueFactory<>("Description"));
          }    
    
}
