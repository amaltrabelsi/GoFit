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
import entities.Avis ;
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
import utils.MyDB;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;

/**
 * FXML Controller class
 *
 * @author HP 840 G3
 */
public class avissController implements Initializable {
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
  
    private LineChart<?, ?> LineChart;
    @FXML
    private Label notext;
    @FXML
    private Label yestext;
    @FXML
    private Label review;
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cnx = MyDB.getInstance().getConnection();
         Statement st;
          try {
        st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
             String s = ("select Valeur,count(*) as countlike FROM Avis  where  Valeur = 'like' ");
             ResultSet rc =st.executeQuery(s);
             rc.next();
             int countlike = rc.getInt("countlike");
             String s2 = ("select Valeur,count(*) as countdislike FROM Avis  where  Valeur = 'Dislike' ");
             ResultSet rc2 =st.executeQuery(s2);
             rc2.next();
             int countdislike = rc2.getInt("countdislike");
             System.out.println("dislike"+countdislike);
             notext.setText(""+countdislike);
             // count => like // c => dislike 
             XYChart.Series se1 =new XYChart.Series <>();
             se1.getData().add(new XYChart.Data(date(),countdislike));  
//             LineChart1.getData().add(se1);
  //           LineChart1.setLegendVisible(false);
            System.out.println("like"+countlike);
             yestext.setText(""+countlike);
             XYChart.Series se12 =new XYChart.Series <>();
            se12.getData().add(new XYChart.Data(date(),countlike));
    //        x.setLabel("date");
       //     y.setLabel("Nombre de personnes");
         //   X.setLabel("date");
           // Y.setLabel("Nombre de personnes");
            //LineChart.getData().add(se12);
            //LineChart.setLegendVisible(false);
           
           float somme = countlike+countdislike ; 
           System.out.println("somme est "+somme);
           if (somme ==0){
                review.setText("0 % des clients recommandent ce produit"); 
           } else {
            double porlike = Math.floor(((countlike /somme)*100)*100)/100;
             review.setText(""+porlike +"% des clients recommandent ce produit"); }
     
           // System.out.println("count est"+count);
           // System.out.println("% est "+porlike);
           

    } catch (SQLException ex) {
        Logger.getLogger(avissController.class.getName()).log(Level.SEVERE, null, ex);
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
            //System.out.println(val);
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
            // LineChart1.getData().add(se1);
               float somme = count+c ; 
           // System.out.println("somme est "+somme);
            double porlike = Math.floor(((count /somme)*100)*100)/100;
            
           // System.out.println("count est"+count);
           // System.out.println("% est "+porlike);
           
           review.setText(""+porlike +"% des clients recommandent ce produit");
      notext.setText(""+c);
 
    } catch (SQLException ex) {
        Logger.getLogger(avissController.class.getName()).log(Level.SEVERE, null, ex);
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
            se1.getData().add(new XYChart.Data(date(),count)); //date X , count Y
//           LineChart.getData().add(se1);
           yestext.setText(""+count);
             float somme = count+c ; 
            double porlike = Math.floor(((count /somme)*100)*100)/100;
 review.setText(""+porlike +"% des clients recommandent ce produit");

    } catch (SQLException ex) {
        Logger.getLogger(avissController.class.getName()).log(Level.SEVERE, null, ex);
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
    

    

   