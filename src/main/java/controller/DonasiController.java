/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class DonasiController implements Initializable {

    @FXML
    private AnchorPane page_Donasi;
    @FXML
    private Button button_kirimDonasi;
    @FXML
    private TextField nominalDonasi;
    @FXML
    private ImageView img_uang300;
    @FXML
    private ImageView img_uang200;
    @FXML
    private ImageView img_uang100;
    @FXML
    private ImageView img_uang50;
    @FXML
    private ImageView img_uang20;
    
    private long jml_donasi;
    @FXML
    private HBox header;
    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private ImageView tombol_back;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public static boolean isAngka(String input) {
            
        if (input == null || input.isEmpty()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true; 
    }

    @FXML
    private void add300(MouseEvent event) {
      nominalDonasi.setText("300000");
    }

    @FXML
    private void add200(MouseEvent event) {
      nominalDonasi.setText("200000");  
    }

    @FXML
    private void add100(MouseEvent event) {
        nominalDonasi.setText("100000");
    }

    @FXML
    private void add50(MouseEvent event) {
        nominalDonasi.setText("50000");
    }

    @FXML
    private void add20(MouseEvent event) {
        nominalDonasi.setText("20000");
    }

    @FXML
    private void kirimDonasi(ActionEvent event) {
        if(isAngka(nominalDonasi.getText())){
        jml_donasi = Long.parseLong(nominalDonasi.getText());
        MainController.p.donasi(jml_donasi, HomeController.k);
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Donasi");
            successAlert.setContentText("Yeay, Donasi Berhasil!");
            successAlert.showAndWait();
        }
    }

    @FXML
    private void nominalDonasi(ActionEvent event) {
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) page_Donasi.getScene().getWindow();
        URL url = new File("src/main/java/view/ShowKampanye.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        ShowKampanyeController controller = loader.getController();
        controller.setData(HomeController.k);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
}
