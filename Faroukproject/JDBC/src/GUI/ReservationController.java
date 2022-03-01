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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import entities.reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.Clock.system;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author farou
 */
public class ReservationController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField dd;
    @FXML
    private TextField df;
    @FXML
    private TextField du;
    @FXML
    private TextField is;
    @FXML
    private TableColumn<reservation, Integer> tvrI;
    @FXML
    private TableColumn<reservation, Date> tvdd;
    @FXML
    private TableColumn<reservation, Date> tvdf;
    @FXML
    private TableColumn<reservation, String> tvd;
    @FXML
    private TableColumn<reservation, String> tbis;
    @FXML
    private Button btnA;
    @FXML
    private Button btnM;
    @FXML
    private Button btnS;
    @FXML
    private TableView<reservation> tv;
    @FXML
    private void handleAddButtonAction(ActionEvent event){
        if(event.getSource() == btnA){
            insertRecord();
        }
    }
    
    @FXML
    private void handleModifyButtonAction(ActionEvent event){
        if(event.getSource() == btnM){
            modifyRecord(); 
        }
    }
    @FXML
    private void handledeleteButtonAction(ActionEvent event){
        if(event.getSource() == btnS){
            deleteRecord(); 
        }
    }
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showreservation();
    }    

    
 public ObservableList<reservation> getreservationList(){
     Connection cnx;
     ObservableList<reservation> reservationList = FXCollections.observableArrayList();
     cnx = MyDB.getInstance().getConnection();
      String query = "SELECT * FROM reservation ";
      
      
      Statement st ;
      ResultSet rs ;
      
      
      try{
          st = cnx.createStatement();
          rs = st.executeQuery(query);
          reservation reservation;
          while(rs.next()){
              reservation = new reservation(rs.getInt("Reservation_Id"), rs.getDate("Date_Debut"), rs.getDate("Date_Fin"), rs.getString("Duree"), rs.getString("Infos_Supp"));
              reservationList.add(reservation); 
          }
          }catch(Exception ex){
              ex.printStackTrace();
          }
  return reservationList;
 }
    
 public void showreservation(){
     ObservableList<reservation> list =getreservationList(); 
     
     
     tvrI.setCellValueFactory(new PropertyValueFactory<reservation, Integer>("Reservation_Id"));
     tvdd.setCellValueFactory(new PropertyValueFactory<reservation, Date>("Date_Debut"));
     tvdf.setCellValueFactory(new PropertyValueFactory<reservation, Date>("Date_Fin"));
     tvd.setCellValueFactory(new PropertyValueFactory<reservation, String>("Duree"));
     tbis.setCellValueFactory(new PropertyValueFactory<reservation, String>("Infos_Supp"));
    
     tv.setItems(list);
    
 }
 private void insertRecord(){
     String query = "INSERT INTO reservation VALUES ('" + id.getText()+ "','" +dd.getText() +"','" +df.getText() + "','"
             +du.getText() + "','" + is.getText()+"')";
     executeQuery(query);
     showreservation();
 }
 
  private void modifyRecord(){
      String query = "UPDATE reservation SET Date_Debut = '" + dd.getText() + "' ,Date_Fin= '" + df.getText() +"' ,Duree = '" 
             + du.getText()+"' ,Infos_Supp='" +is.getText() + "' WHERE Reservation_Id = " + id.getText() + "";
      executeQuery(query);
      showreservation();

 }
  private void deleteRecord(){
      String query  ="DELETE FROM reservation WHERE Reservation_Id =" + id.getText() + "";
      executeQuery(query);
      showreservation();
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

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
}



       