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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class SceneeventController implements Initializable {

    @FXML
    private Button signout;
    @FXML
    private HBox cardlayout;
    @FXML
    private GridPane eventcontanair;

    private List<evenement> list;
    private List<evenement> listeven ;
    @FXML
    private Label eve;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         list = new ArrayList<>(newevent());
       listeven = new ArrayList<>(evente());
       int column = 0;
       int row = 1;
        try {
        for (evenement ev : list) {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("card.fxml"));
            HBox cardbox = fxmlloader.load();
            CardController cardcont = fxmlloader.getController();
            cardcont.setData(ev);
            cardlayout.getChildren().add(cardbox);
               // HBox cardBox = fxmlloader.load();
            } 
            for (evenement e :listeven) {
                 FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("eventaffiche.fxml"));
            VBox eventbox = fxmlloader.load();
           EventafficheController eventcont = fxmlloader.getController();
            eventcont.setData(e);
           if (column == 6){
               column = 0;
               row++;
           }
            eventcontanair.add(eventbox, column++,row);
            GridPane.setMargin(eventbox, new Insets(10));
            }
            }catch (Exception e) {
                e.printStackTrace();
        }
        
    }  
     private List<evenement> newevent (){
        List<evenement> ls = new ArrayList<>();
        evenement ev = new evenement();
        ev.setNom("new year party...");
        ev.setImagesrc("/images/party1.jpg");
        ev.setDescription("2022/2023");
        ls.add(ev);
        
        ev = new evenement();
        ev.setNom("Carthage festival");
        ev.setImagesrc("/images/party2.jpg");
        ev.setDescription("nouba & fahmi riahi ");
        ls.add(ev);
        
        ev = new evenement();
        ev.setNom("bizerte festival");
        ev.setImagesrc("/images/party3.jpg");
        ev.setDescription("nordo & janjoon ");
        ls.add(ev);
        return ls;
    }
    
    private List<evenement> evente(){
        List<evenement> ls = new ArrayList<>();
        evenement ev = new evenement();
        ev.setNom("new year party...");
        ev.setImagesrc("/images/party1.jpg");
        ev.setDescription("2022/2023");
        ls.add(ev);
         
        
        ev = new evenement();
        ev.setNom("Carthage festival");
        ev.setImagesrc("/images/party2.jpg");
        ev.setDescription("nouba & fahmi riahi ");
        ls.add(ev);
        
        ev = new evenement();
        ev.setNom("bizerte festival");
        ev.setImagesrc("/images/party3.jpg");
        ev.setDescription("nordo & janjoon ");
        ls.add(ev);
         ev = new evenement();
        ev.setNom("Théâtre municipal");
        ev.setImagesrc("/images/party4.jpg");
        ev.setDescription("13 decemebre live ");
        ls.add(ev);
        
        ev = new evenement();
        ev.setNom("ANNECY 2022");
        ev.setImagesrc("/images/party5.jpg");
        ev.setDescription("festivale internationnal de film annimation");
        ls.add(ev);
         ev = new evenement();
        ev.setNom("LAYA 2022");
        ev.setImagesrc("/images/party6.jpg");
        ev.setDescription("festival capturing  dance");
        ls.add(ev);
       
        return ls;
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("logout");
        alert.setHeaderText("deconnexion");
        alert.setContentText("do you want really to logout ");
        if (alert.showAndWait().get()== ButtonType.OK){
              Parent root=FXMLLoader.load(getClass().getResource("../GuiUser/logininterface.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
    }

    @FXML
    private void addevent(MouseEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
                
            Scene scene = new Scene(root);
            Stage stage = new Stage();  
            stage.setScene(scene);
            stage.show();
    }

    

   
    
}