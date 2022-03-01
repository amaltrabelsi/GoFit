/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.reservation;
import entities.service;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author farou
 */
public class ServiceController implements Initializable {

    @FXML
    private TextField Sid;
    @FXML
    private TextField Sref;
    @FXML
    private TextField Stype;
    @FXML
    private TextField Snom;
    @FXML
    private TextField Sdes;
    @FXML
    private TextField Sdispo;
    @FXML
    private TextField Shor;
    @FXML
    private TextField Scate;
    @FXML
    private TableColumn<service,Integer> id1;
    @FXML
    private TableColumn<service, String> ref2;
    @FXML
    private TableColumn<service, String> typ3;
    @FXML
    private TableColumn<service, String> nom4;
    @FXML
    private TableColumn<service, String> des5;
    @FXML
    private TableColumn<service, String> dis6;
    @FXML
    private TableColumn<service, String> hor7;
    @FXML
    private TableColumn<service, String> cat8;
    @FXML
    private TableView<service> tableview2;
    @FXML
    private Button ajout;
    @FXML
    private Button modifier;
    @FXML
    private Button supp;
    
    @FXML
    private void handleajoutButtonAction(ActionEvent event){
        if(event.getSource() == ajout){
            ajoutRecord();
        }
    }
    @FXML
    private void handleModifierButtonAction(ActionEvent event){
        if(event.getSource() == modifier){
            modifierRecord(); 
        }
    }
    @FXML
    private void handleSupprimerButtonAction(ActionEvent event){
        if(event.getSource() == supp){
            supprimmerRecord(); 
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showservice();
    }
        
     public  ObservableList<service> getserviceList(){
     Connection cnx;
     ObservableList<service> serviceList = FXCollections.observableArrayList();
     cnx = MyDB.getInstance().getConnection();
      String query = "SELECT * FROM service ";
     
      
      
      Statement st ;
      ResultSet rs ;
      try{
          st = cnx.createStatement();
          rs = st.executeQuery(query);
          service service;
          while(rs.next()){
              service = new service(rs.getInt("Service_Id"), rs.getString("Ref_S"), rs.getString("Type_S"), rs.getString("Nom_Service"), rs.getString("Description"), rs.getString("Disponibilite"), rs.getString("Horaire"), rs.getString("Categorie"));
             serviceList.add(service); 
          }
          }catch(Exception ex){
              ex.printStackTrace();
          }
  return serviceList;
 }
    
 public void showservice(){
     ObservableList<service> list =getserviceList(); 
     
     
     id1.setCellValueFactory  (new PropertyValueFactory<service, Integer>("Service_Id"));
     ref2.setCellValueFactory(new PropertyValueFactory<service, String>("Ref_S"));
     typ3.setCellValueFactory(new PropertyValueFactory<service, String>("Type_S"));
     nom4.setCellValueFactory(new PropertyValueFactory<service, String>("Nom_Service"));
     des5.setCellValueFactory(new PropertyValueFactory<service, String>("Description"));
     dis6.setCellValueFactory(new PropertyValueFactory<service, String>("Disponibilite"));
     hor7.setCellValueFactory(new PropertyValueFactory<service, String>("Horaire"));
     cat8.setCellValueFactory(new PropertyValueFactory<service, String>("Categorie"));
    
     tableview2.setItems(list);
    
 }
 private void ajoutRecord(){
     String query = "INSERT INTO service VALUES ('" + Sid.getText()+ "','" +Sref.getText() +"','" +Stype.getText() + "','"
             +Snom.getText() + "','" + Sdes.getText()+ "','" + Sdispo.getText() + "','" + Shor.getText() +"','" + Scate.getText()+"')";
     executeQuery(query);
     showservice();
 }
 
  private void modifierRecord(){
      String query = "UPDATE service SET Ref_S = '" + Sref.getText() + "' ,Type_S= '" + Stype.getText() +"' ,Nom_Service = '" 
             + Snom.getText() +
              "' ,Description='" + 
              Sdes.getText() +
              "' ,Disponibilite ='"
              +Sdispo.getText() + 
              "' ,Horaire='" 
              + Shor.getText() +
              "' ,Categorie='" +
              Scate.getText()+
              "' WHERE Service_Id = " + Sid.getText() + "";
             
      executeQuery(query);
      showservice();

 }
  private void supprimmerRecord (){
      String query  ="DELETE FROM service WHERE Service_Id =" + Sid.getText() + "";
      executeQuery(query);
      showservice();
              }
              
              
    private void executeQuery(String query) {
        Connection cnx;
       cnx = MyDB.getInstance().getConnection();
       Statement st;
       try{
           st = cnx.createStatement();
           st.executeUpdate(query);
       }catch(Exception ex){
           ex.printStackTrace();
           
           
       }
    }

}

