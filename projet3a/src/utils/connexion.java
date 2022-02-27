/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP 840 G3
 */
public class connexion {
    
    private String url ="jdbc:mysql://localhost/3a12"; 
    private String user ="root";
    private String pass ="";
    private Connection connection;
    static connexion instance;
    
    private connexion(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static connexion getInstance(){
        if(instance == null)
            instance = new connexion();
       return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
}
