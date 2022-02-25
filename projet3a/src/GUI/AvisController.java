/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


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
    @FXML
    private BarChart<?, ?> likedislike;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private PieChart PieChart;
    @FXML
    private LineChart<?, ?> LineChart;
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
       XYChart.Series se1 =new XYChart.Series <>();
    se1.getData().add(new XYChart.Data("je n'aime",count));
    likedislike.getData().add(se1);
      
       
     ObservableList<PieChart.Data> piechart = FXCollections.observableArrayList(new PieChart.Data("Je n'aime pas", count));
    PieChart.getData().addAll(piechart);
   
    }

    @FXML
    private void like(ActionEvent event) {
        
        { count1 ++ ; 
         message1.setText( "" + count1 + " J'aime "  );
        XYChart.Series se1 =new XYChart.Series <>();
      se1.getData().add(new XYChart.Data("j'aime",count1));
      likedislike.getData().add(se1);}
       int C= 0 ;
       C=+count ;
     
      ObservableList<PieChart.Data> piechart = FXCollections.observableArrayList(new PieChart.Data("J'aime", C));
    PieChart.getData().addAll(piechart);
    }

    
  }


 

