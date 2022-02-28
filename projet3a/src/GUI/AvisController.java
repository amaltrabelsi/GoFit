/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import services.ServicesAvis;
import entites.Avis ;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import utils.connexion;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class AvisController implements Initializable {
Connection cnx;

    @FXML
    private ImageView dislike;
    @FXML
    private ImageView like;
    @FXML
    private ToggleButton no;
    @FXML
    private ToggleButton yes;
    
     Image Im1 = new  Image(getClass().getResourceAsStream("../Images/like.png"));
     Image Im2 = new  Image(getClass().getResourceAsStream("../Images/dislike.png"));
    Image Im3 = new  Image(getClass().getResourceAsStream("../Images/dislike done.png"));
    Image Im4 = new  Image(getClass().getResourceAsStream("../Images/like done.png"));
    
    ServicesAvis avi = new  ServicesAvis  () ;
    @FXML
    private PieChart PieChart;
    @FXML
    private BarChart<?, ?> BarChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private LineChart<?, ?> LineChart;
    private AreaChart<?, ?> AreaChart;
    private StackedBarChart<?, ?> StackedBarChart;
    @FXML
    private BarChart<?, ?> BarChart1;
    @FXML
    private NumberAxis y1;
    @FXML
    private CategoryAxis x1;
    @FXML
    private Label notext;
    @FXML
    private Label yestext;
    @FXML
    private Label review;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cnx = connexion.getInstance().getConnection();
         DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         System.out.println(dft.format(now));
         Statement st;
          try {
        st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
             String s = ("select Valeur,count(*) as count FROM Avis  where  Valeur = 'like' ");
             ResultSet rc =st.executeQuery(s);
             rc.next();
             int count = rc.getInt("count");
             
               String s2 = ("select Valeur,count(*) as count FROM Avis  where  Valeur = 'Dislike' ");
             ResultSet rc2 =st.executeQuery(s2);
             rc2.next();
             int c = rc2.getInt("count");
             System.out.println(c);
             notext.setText(""+c);
             XYChart.Series se1 =new XYChart.Series <>();
             se1.getData().add(new XYChart.Data(date(),c)); 
            BarChart1.getData().add(se1);
            BarChart1.setTitle("les statistiques de dislikes ");
           LineChart.getData().add(se1);
            System.out.println(count);
             yestext.setText(""+count);
             XYChart.Series se12 =new XYChart.Series <>();
            se1.getData().add(new XYChart.Data(dft.format(now),count)); 
            BarChart.setTitle("les statistiques des likes");
            BarChart.getData().add(se12);
            LineChart.getData().add(se12);
           float somme = count+c ; 
           // System.out.println("somme est "+somme);
            double porlike = Math.floor(((count /somme)*100)*100)/100;
            
           // System.out.println("count est"+count);
           // System.out.println("% est "+porlike);
           
           review.setText(""+porlike +"personne qui ont recommendé ce produit");
 
    } catch (SQLException ex) {
        Logger.getLogger(AvisController.class.getName()).log(Level.SEVERE, null, ex);
    } 
     

           
    }
    
    
    @FXML
    private void no( ActionEvent event) throws SQLException {
        if (no.isSelected())
        {  yes.setVisible(false);
            dislike.setImage(Im3);
            Avis v = new Avis ();
            v.setValeur("Dislike");
            avi.ajout(v);
      } else {
        
          Statement st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st = cnx.createStatement();
           ResultSet rs = st.executeQuery("select @@IDENTITY From Avis ");
             while (rs.next()){
            int val = rs.getInt(1);
            System.out.println(val);
        avi.supprimer(val);  
          dislike.setImage(Im2);
          yes.setVisible(true);
             }
    } Statement st;
    try {
         st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
             String s = ("select Valeur,count(*) as count FROM Avis  where  Valeur = 'like' ");
             ResultSet rc =st.executeQuery(s);
             rc.next();
             int count = rc.getInt("count");
             
               String s2 = ("select Valeur,count(*) as count FROM Avis  where  Valeur = 'Dislike' ");
             ResultSet rc2 =st.executeQuery(s2);
             rc2.next();
             int c = rc2.getInt("count");
             XYChart.Series se1 =new XYChart.Series <>();
            se1.getData().add(new XYChart.Data(date(),c)); 
            BarChart1.getData().add(se1);
             LineChart.getData().add(se1);
               float somme = count+c ; 
           // System.out.println("somme est "+somme);
            double porlike = Math.floor(((count /somme)*100)*100)/100;
            
           // System.out.println("count est"+count);
           // System.out.println("% est "+porlike);
           
           review.setText(""+porlike +"personne qui ont recommendé ce produit");
      
 
    } catch (SQLException ex) {
        Logger.getLogger(AvisController.class.getName()).log(Level.SEVERE, null, ex);
    } 

    }

    @FXML
    private void yes(ActionEvent event) throws SQLException {
            if (yes.isSelected())
        {   no.setVisible(false);
            like.setImage(Im4);
            Avis v = new Avis ();
            v.setValeur("like");
            avi.ajout(v);
      } else {
           
           Statement st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
           ResultSet rs = st.executeQuery("select @@IDENTITY From Avis ");
             while (rs.next()){
            int val = rs.getInt(1);
            System.out.println(val);
        avi.supprimer(val);  
        like.setImage(Im1);
        no.setVisible(true);

    }
    }  Statement st;
    try {
        st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
             String s = ("select Valeur,count(*) as count FROM Avis  where  Valeur = 'like' ");
             ResultSet rc =st.executeQuery(s);
             rc.next();
             int count = rc.getInt("count");
             System.out.println(count);
              st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
             String s2 = ("select Valeur,count(*) as count FROM Avis  where  Valeur = 'Dislike' ");
             ResultSet rc2 =st.executeQuery(s2);
             rc2.next();
             int c = rc2.getInt("count");
             XYChart.Series se1 =new XYChart.Series <>();
            se1.getData().add(new XYChart.Data(date(),count)); 
            BarChart.getData().add(se1);
           LineChart.getData().add(se1);
           yestext.setText(""+count);
             float somme = count+c ; 
           // System.out.println("somme est "+somme);
            double porlike = Math.floor(((count /somme)*100)*100)/100;
            
           // System.out.println("count est"+count);
           // System.out.println("% est "+porlike);
           
           review.setText(""+porlike +"personne qui ont recommendé ce produit");
           
    } catch (SQLException ex) {
        Logger.getLogger(AvisController.class.getName()).log(Level.SEVERE, null, ex);
    } }

    /**
     *
     * @return
     */
    public String date ()
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         System.out.println(dft.format(now));
         return dft.format(now) ;
    }
    }
    

    

   