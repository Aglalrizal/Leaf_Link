/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class DaftarSebagaiController implements Initializable {

    @FXML
    private AnchorPane page_daftarPilihan;
    @FXML
    private ImageView organisasi;
    @FXML
    private ImageView personal;
    @FXML
    private Button btnPersonal;
    @FXML
    private Button btnOrganisasi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void daftarPersonal(MouseEvent event) {
       try {
            Stage stage = (Stage) btnPersonal.getScene().getWindow();
            URL url = new File("src/main/java/view/Personal.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
       } catch (HeadlessException | IOException e) {
            e.printStackTrace();
       }
    }

    @FXML
    private void daftarOrganisasi(MouseEvent event) {
        try {
            Stage stage = (Stage) btnOrganisasi.getScene().getWindow();
            URL url = new File("src/main/java/view/Organisasi.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch(HeadlessException | IOException e) {
            e.printStackTrace();
       }
    }
    
}
