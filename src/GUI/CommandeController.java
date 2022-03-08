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
import entities.Commande;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CommandeController implements Initializable {

    private TableColumn<Commande, Integer> nom_commande;
    private TableColumn<Commande, Date> date_commande;
    private TableColumn<Commande, String> pay_Commande;
    private TableColumn<Commande, Double> total_commande;
    @FXML
    private TableView<Commande> commandetable;
    @FXML
    private Button menuid;
    @FXML
    private TableColumn<?, ?> comcol;
    @FXML
    private TableColumn<?, ?> datecol;
    @FXML
    private TableColumn<?, ?> modecol;
    @FXML
    private TableColumn<?, ?> totalcol;
    @FXML
    private Button menuid1;
    @FXML
    private TextField comfield;
    @FXML
    private TextField datefield;
    @FXML
    private TextField modefield;
    @FXML
    private TextField totalfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ServiceCommande sc = new ServiceCommande();
        List Commandes = sc.afficher();
        ObservableList list = FXCollections.observableArrayList( Commandes);
        commandetable.setItems(list);
        nom_commande.setCellValueFactory(new PropertyValueFactory<>("Commande_Id"));
         date_commande.setCellValueFactory(new PropertyValueFactory<>("Date_C"));
         pay_Commande.setCellValueFactory(new PropertyValueFactory<>("Total"));
         total_commande.setCellValueFactory(new PropertyValueFactory<>("Mode_Paiement"));
         
         
         
    TableColumn<Commande, Void> gotobtn = new TableColumn("Action");
 Callback<TableColumn<Commande, Void>, TableCell<Commande, Void>> cellFactory
           = new Callback<TableColumn<Commande, Void>, TableCell<Commande, Void>>() {
 
                  @Override
            public TableCell<Commande, Void> call(final TableColumn<Commande, Void> param) {
                final TableCell<Commande, Void> cell = new TableCell<Commande, Void>() {

      
                          private final Button btn = new Button("Pdf");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Commande data = getTableView().getItems().get(getIndex());
                            int a=data.getCommande_Id();
                            System.out.println(a);
                            Commande u=new Commande();

                            String total=String.valueOf(data.getTotal());
                            String type=data.getMode_Paiement();
                            String nbproduit=String.valueOf(data.getNb_Produit());

                            String id=String.valueOf(a);
                            String dated=String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", data.getDate_C());

                            
                                    
                            Document doc =new Document();
                             
                            try {
                                String file_name="C:\\Users\\ASUS\\Documents\\NetBeansProjects\\GoFit\\src\\Commande.pdf";
                                PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                                doc.open();
                                doc.addTitle("Code de la commande: "+id);
                                doc.add(new Paragraph("Votre Total: '"+total+"'"));
                                doc.add(new Paragraph("Votre mode de paiement: '"+type+"'"));
                           
                                doc.add(new Paragraph("Le nombre de vos produits: '"+nbproduit+"'"));
                                doc.add(new Paragraph("Vous avez passer la commande le: '"+dated+"'"));

                                doc.close();
                                Desktop.getDesktop().open(new File(file_name));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (DocumentException ex) {
                                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
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

       commandetable.getColumns().add(gotobtn);
      
      
  }

    @FXML
    private void gotomenu(ActionEvent event) throws IOException {
                       Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
   
    
}
