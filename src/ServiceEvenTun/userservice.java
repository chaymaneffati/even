/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceEvenTun;

import GestionUser.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import UtilData.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.JOptionPane;

/**
 *
 * @author chayma
 */
public class userservice implements service<User> {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public userservice() {
        cnx = DataSource.getConnection();
    }

    @Override
    public void adduser(User u) {

        try {
            pst = cnx.prepareStatement("insert into user ( login, pwd, telephone,email, role) values(?,?,?,?,?)");
            pst.setString(1, u.getLogin());
            pst.setString(2, u.getPwd());
            pst.setInt(3, u.getTelephone());
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getRole());

            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Account successfully registered");

    }


    @Override
    public ObservableList<User> readAll() {
        ObservableList<User> list =FXCollections.observableArrayList();
        try {
            String requete = "select * from user";

            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);

            while (rs.next()) {
                User u = new User();
                 u.setId(rs.getInt(1));
                  u.setLogin(rs.getString(2));
                  u.setPwd(rs.getString(3));
                   u.setTelephone(rs.getInt(4));
                    u.setEmail(rs.getString(5));
                     u.setRole(rs.getString(6));
               list.add(u);
                //rs.getInt("id"), rs.getString("login"), rs.getString("pwd"), rs.getInt("Telephone"), rs.getString("email"), rs.getString("role"));
//
//                list.add(u);

            }

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void deleteuser(User t) {

        try {
            pst = cnx.prepareStatement("Delete from user where id=?");

            ste = cnx.createStatement();
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean readById(User u) {
        try {

            pst = cnx.prepareStatement("select * from user where login=? ");
            ste = cnx.createStatement();
            pst.setString(1, u.getLogin());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "le nom deja existe");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void login(User u) {

        try {
            pst = cnx.prepareStatement("select * from user where login=? and pwd=?");
            ste = cnx.createStatement();
            pst.setString(1, u.getLogin());
            pst.setString(2, u.getPwd());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "login success");

            } else {

                JOptionPane.showMessageDialog(null, "login Failed");
            }

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean forgetpass(User t) {

        try {
            pst = cnx.prepareStatement("select login from user where login=?");
            ste = cnx.createStatement();
            pst.setString(1, t.getLogin());

            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("nom existe");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Error: nom  incorrect");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updatepass(User t) {
        try {
            ste = cnx.createStatement();
            String req = "UPDATE user set `pwd` = " + "'" + t.getPwd() + "'" + " WHERE login = '" + t.getLogin() + "'";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "la nouveau mot de passe a changé avec succée");
    }

    @Override
    public void upuser(User u) {

        try {
            pst = cnx.prepareStatement("UPDATE user set   `login` = " + "'" + u.getLogin() + "'" + ", `pwd` = " + "'" + u.getPwd() + "'" + ", `telephone` = " + "'" + u.getTelephone() + "'" + ", `email` = " + "'" + u.getEmail() + "'" + ", `role` = " + "'" + u.getRole() + "'" + " WHERE id = " + u.getId());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Account successfully updated");
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//      @Override
//    public void sendmail(User u) {
//
//        try {
//            pst = cnx.prepareStatement("UPDATE user set  `email` = " + "'" + u.getEmail() + "'" +  " WHERE id = " + u.getId());
//            pst.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, " send Email  successfully ");
//        } catch (SQLException ex) {
//            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    @Override
    public void addpub(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatepub(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletepub(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
