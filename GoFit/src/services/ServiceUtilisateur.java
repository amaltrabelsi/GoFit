/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author TRABELSI Amaal
 */
public class ServiceUtilisateur implements IService<Utilisateur>{

Connection cnx;

    public ServiceUtilisateur() {
        cnx = MyDB.getInstance().getConnection();
    }
    @Override
    public void ajout(Utilisateur t) {
        try {	

            String req = "insert into utilisateur (Nom,Prenom,Email,Date_de_naissance,Sexe,Region,Adresse,Role,Mdp,numero,reponse,question) values"
                    + " ('" + t.getNom() + "','" + t.getPrenom() + "','" + t.getEmail() + "','" + t.getDate_de_naissance() + "','" + t.getSexe() + "','" + t.getRegion() + "','" + t.getAdresse() + "' ,'" + t.getRole() + "','" + t.getMdp() + "','"+t.getNumero()+"','"+t.getReponse()+"','"+t.getQuestion()+"')";
                    Statement st = cnx.createStatement();
                    st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Utilisateur t) {
        try {
            String req = "update utilisateur set Nom=?,Prenom=?,Email=?,Date_de_naissance=?,Sexe=?,Region=?,Adresse=?,Role=?  , Mdp =? , numero =? , reponse =? ,question = ? where Utilisateur_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getDate_de_naissance()); 
            ps.setString(5, t.getSexe());
            ps.setString(6, t.getRegion());
            ps.setString(7, t.getAdresse());
            ps.setString(8, t.getRole());
            ps.setString(9, t.getMdp());
            ps.setString(10, t.getNumero());
             ps.setString(11, t.getReponse());
              ps.setString(12, t.getQuestion());
            ps.setInt(1, t.getUtilisateur_Id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int Utilisateur_Id) {
        try {
            String req = "delete from utilisateur where Utilisateur_Id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Utilisateur_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req ="select * from utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
        	      			
            while(rs.next()){
                Utilisateur s = new Utilisateur ();
                s.setUtilisateur_Id(rs.getInt(1));
                s.setNom(rs.getString("Nom"));
                s.setPrenom(rs.getString("Prenom"));
                s.setEmail(rs.getString("Email"));
                s.setDate_de_naissance(rs.getString("Date_de_naissance"));
                s.setSexe(rs.getString("Sexe"));
                s.setRegion(rs.getString("Region"));
                s.setAdresse(rs.getString("Adresse"));
                s.setRole(rs.getString("Role"));
                s.setMdp(rs.getString("Mdp"));
                 s.setNumero(rs.getString("numero"));
                 s.setReponse(rs.getString("reponse"));
                 s.setQuestion(rs.getString("question"));
                
                list.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
}
