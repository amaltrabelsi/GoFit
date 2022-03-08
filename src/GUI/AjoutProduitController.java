/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Image;
import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutProduitController implements Initializable {

    @FXML
    private TextField Code_Produit;
    @FXML
    private TextField quantite;
    @FXML
    private TextArea Description_Produit;
    @FXML
    private TextField Nom_Produit;
    @FXML
    private Button AjouterProduit;
   
    @FXML
    private TextField categorie;
    ServiceProduit sp = new ServiceProduit () ;
    private FileChooser filechooser= new FileChooser();
    @FXML
    private Button ajoutetimagebt;
    @FXML
    private ImageView imageView;
    @FXML
    private Button menupage;
    @FXML
    private TextField imgUrl;
    @FXML
    private TextField Prix_U;
    
    

    /**
     * Initializes the controller class.
     */
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void browse(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", ".JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

       
            File file = filechooser.showOpenDialog(null);
            WritableImage img = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            imageView.setImage(img);
               if (file != null) {
                String cwd = System.getProperty("user.dir");
                String path = new File(cwd).toURI().relativize(file.toURI()).getPath();
                imgUrl.setText(file.getPath());
                System.out.println(path);


               
    }
    }

 
    @FXML
    private void AjouterProduit(ActionEvent event) {
        Produit p = new Produit(); 
        p.setCategorie(categorie.getText());
        String pu=Prix_U.getText();
        p.setNom_Produit(Nom_Produit.getText());
        p.setPath_Image(imgUrl.getText());
        p.setRef_P(Code_Produit.getText());
        String quant =quantite.getText();
        int intquantit=Integer.parseInt(quant);
        Double doubleprix=Double.parseDouble(pu);
         
          p.setQuantite(intquantit);
          
          
          
           p.setDescription(Description_Produit.getText());
          sp.ajout(p);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Produit");
			alert.setHeaderText("Ajout du produit");
			alert.setContentText("produit ajouté avec succès !");
			alert.showAndWait();
         
             
             
    }

    @FXML
    private void menupage(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
    
}
