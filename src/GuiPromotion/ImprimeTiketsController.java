/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiPromotion;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;



/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class ImprimeTiketsController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Button imprime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public  void imprimerticket() throws IOException{
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc,new FileOutputStream("ticket.pdf"));
            doc.open();
            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("C:\\Users\\SALIM\\Downloads\\EvenTun\\src\\images\\tic.PNG");
            img.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
            doc.add(img);
            doc.close();
            Desktop.getDesktop().open(new File("ticket.pdf"));
        } catch (FileNotFoundException | DocumentException e){
            e.printStackTrace();
        }
    }
}
