/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
import entities.service;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
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
    private TextField trr;
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
     
     
      FilteredList<reservation> filteredData = new FilteredList<>(list, b -> true);
		
		trr.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				//if (reservation.getReservation_Id().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					//return true; // Filter matches first name.
                                        // if (reservation.getDate_Debut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					//return true; // Filter matches last name.
				//}else if (reservation.getDate_Fin().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					//return true; // Filter matches first name.
				 if (reservation.getDuree().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (reservation.getInfos_Supp().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<reservation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tv.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tv.setItems(sortedData);
        tv.setRowFactory(tv -> new TableRow<reservation>() {
            
              // @Override
                protected void updateItem(service item, boolean empty){
                
                }
        });
        /**********************************pdf**************************/
         TableColumn<reservation, Void> gotobtn = new TableColumn("Action");
          Callback<TableColumn<reservation, Void>, TableCell<reservation, Void>> cellFactory
           = new Callback<TableColumn<reservation, Void>, TableCell<reservation, Void>>() {
          
            @Override
            public TableCell<reservation, Void> call(final TableColumn<reservation, Void> param) {
                final TableCell<reservation, Void> cell = new TableCell<reservation, Void>() {

                    private final Button btn = new Button("Pdf");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                            
                           
                                reservation data = getTableView().getItems().get(getIndex());
                                int a=data.getReservation_Id();
                                System.out.println(a);
                                reservation u=new reservation();
                                String duree=data.getDuree();
                                String info=data.getInfos_Supp();
                                Date dated=data.getDate_Debut();
                                Date datef=data.getDate_Fin();
                                
                                
                               
                                
                                Document doc =new Document();
                                
                                 try {
                                String file_name="C:\\Users\\farou\\Downloads\\Faroukproject\\JDBC\\src\\GUI//reservation.pdf";
                                PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                                doc.open();
                                doc.add(new Paragraph("reservation: "));
                               
                                doc.add(new Paragraph("infos supplémentaires: '"+info+"'"));
                                doc.add(new Paragraph("durée: '"+duree+"'"));
                                doc.add(new Paragraph("Date début: '"+dated+"'"));
                                doc.add(new Paragraph("Date fin: '"+datef+"'"));
                                
                                
                                doc.close();
                                Desktop.getDesktop().open(new File(file_name));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (DocumentException ex) {
                                Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           
                               
                            
         
                            
                        });
                       
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

       gotobtn.setCellFactory(cellFactory);

        tv.getColumns().add(gotobtn);
 }


 private void insertRecord(){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     String query = "INSERT INTO reservation VALUES ('" + id.getText()+ "','" +dd.getText() +"','" +df.getText() + "','"
             +du.getText() + "','" + is.getText()+"')";
     
     
         alert.setTitle("Inforamtion Dialog");
     alert.setHeaderText(null);
     alert.setContentText("Reservation ajouté avec succes !");
     alert.show();
     
     executeQuery(query);
     
       if(id.getText().isEmpty()){
         
         alert.setTitle("Informartion Dialog");
         alert.setHeaderText(null);
         alert.setContentText("veuillez insérer l'identifiant du Reservation !");
         alert.show();
     }
    else if (dd.getText().isEmpty()){
          alert.setTitle("Informartion Dialog");
         alert.setHeaderText(null);
         alert.setContentText("veuillez insérer la date de début du Reservation !");
         alert.show();
         
     }
      else if(df.getText().isEmpty()){
          alert.setTitle("Informartion Dialog");
         alert.setHeaderText(null);
         alert.setContentText("veuillez insérer la date du fin du Reservation !");
         alert.show();  
     }
       else if(du.getText().isEmpty()){
          alert.setTitle("Informartion Dialog");
         alert.setHeaderText(null);
         alert.setContentText("veuillez insérer la durée du Reservation !");
         alert.show();  
     }
        else  if(is.getText().isEmpty()){
          alert.setTitle("Informartion Dialog");
         alert.setHeaderText(null);
         alert.setContentText("veuillez insérer les infos supp du Reservation !");
         alert.show();  
     }
   
     
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
    private void handleMouseAction(MouseEvent event) {
       reservation reservation = tv.getSelectionModel().getSelectedItem();
        id.setText(""+ reservation.getReservation_Id());
        dd.setText("" +reservation.getDate_Debut());
        df.setText(""+reservation.getDate_Fin());
       du.setText(reservation.getDuree());
       is.setText(reservation.getInfos_Supp());
        
    }
    
      @FXML
      private void exitclick(){
          Alert alert = new Alert (Alert.AlertType.CONFIRMATION,"Etes  vous sur de fermer ?");
          alert.showAndWait().ifPresent(response-> {
              if (response==ButtonType.OK)
              {
                  System.out.println("en train de fermer ...");
                  Platform.exit();
              }
          });
      }
      
}




       