/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiPromotion;

import gestionevenement.evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class ClientConsultController implements Initializable {

    @FXML
    private GridPane eventconsult;
private List<evenement> list;
    private VBox hbbox;
    private List<evenement> listeven ;
    @FXML
    private Button btnlogin;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int column = 0;
       int row = 1;
        listeven = new ArrayList<>(evente());
    for (evenement e :listeven) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("cardconsult.fxml"));
                VBox eventbox = fxmlloader.load();
                CardconsultController eventcont = fxmlloader.getController();
                eventcont.setData(e);
                if (column == 6){
               column = 0;
               row++;
           }
                eventconsult.add(eventbox, column++,row);
            GridPane.setMargin(eventbox, new Insets(10));
            } catch (IOException ex) {
                Logger.getLogger(ClientConsultController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    
     private List<evenement> evente (){
        List<evenement> ls = new ArrayList<>();
        evenement ev = new evenement();
        ev.setNom("new year party...");
        ev.setImagesrc("/images/party1.jpg");
        ev.setDescription("2022/2023");
        ev.setLieu("billionaire gammarth");
        ls.add(ev);
        
        ev = new evenement();
        ev.setNom("Carthage festival");
        ev.setImagesrc("/images/party2.jpg");
        ev.setDescription("nouba & fahmi riahi ");
        ev.setLieu("Cartage");
        ls.add(ev);
        
        ev = new evenement();
        ev.setNom("bizerte festival");
        ev.setImagesrc("/images/party3.jpg");
        ev.setDescription("nordo & janjoon ");
        ev.setLieu("Bizert");
        ls.add(ev);
        return ls;
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("../GuiUser/logininterface.fxml"));      
        Stage window = (Stage)btnlogin.getScene().getWindow();
        window.setScene(new Scene(root ,1000,750));
    }
}
