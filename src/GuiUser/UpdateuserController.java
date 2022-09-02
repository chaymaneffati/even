/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.User;
import UtilData.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.userservice;


/**
 * FXML Controller class
 *
 * 
 * @author panda
 */
public class UpdateuserController implements Initializable {
    private Connection cnx;

    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
     @FXML
    private Button btnback;

    @FXML
    private Button btnmodifier;

    @FXML
    private ComboBox<String> cmbrole;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtlogin;

    @FXML
    private TextField txtpwd;

    @FXML
    private TextField txttelf;
   // private User u;
    
    public UpdateuserController() {
          cnx = DataSource.getConnection();
    }
        ObservableList<String> RoleBoxList = FXCollections.observableArrayList("User","event Manager","advertising manager");

    /**
     * Initializes the controller class.
     */
      public void update(ActionEvent event) throws SQLException{
          
        try{ 
        User u = new User();
        String email=txtemail.getText();
        String login=txtlogin.getText();
        String telephone = txttelf.getText();
        String password = txtpwd.getText();
        String role= cmbrole.getSelectionModel().getSelectedItem();
        // id =u.getId();
        if (email.equals("") || login.equals("") || telephone.equals("") || role.equals("Choose your role") || password.equals(""))
            
              JOptionPane.showMessageDialog(null,"please complete all the fills");
        
         else {
               if (telephone.length()<8){
                  
                   JOptionPane.showMessageDialog(null,"telephone  is too weak, please choose 8 characters");
               }
        else {
                 
           

           pst = cnx.prepareStatement("UPDATE user set   `login` = " +"'"+u.getLogin()+"'" +", `pwd` = " +"'"+ u.getPwd()+"'" +", `telephone` = "+"'"+u.getTelephone()+"'"+", `email` = "+"'"+u.getEmail()+"'"+", `role` = "+"'"+u.getRole()+"'"+" WHERE id_produit = "+u.getId() );
             
             u.setLogin(login);
             u.setPwd(password);
             u.setTelephone((Integer.parseInt(telephone)));
             u.setEmail(email);
          //   u.setId(id);
             pst.executeUpdate();
      
            JOptionPane.showMessageDialog(null,"Account successfully updated");
         
        }
        
    }} catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    cmbrole.setValue("Choose your role");
    cmbrole.setItems(RoleBoxList); 
    }    
    
}
