/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    private Pane organisasi;
    @FXML
    private Pane personal;
    @FXML
    private ImageView tombol_back;
    @FXML
    private ImageView personal_gambar;
    @FXML
    private Label personal_label;
    @FXML
    private ImageView personal_gambar1;
    @FXML
    private Label personal_label1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    
    
    @FXML
    private void daftarPersonal(MouseEvent event) {
       try {
            Stage stage = (Stage) personal.getScene().getWindow();
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
            Stage stage = (Stage) organisasi.getScene().getWindow();
            URL url = new File("src/main/java/view/Organisasi.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch(HeadlessException | IOException e) {
            e.printStackTrace();
       }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) tombol_back.getScene().getWindow();
            URL url = new File("src/main/java/view/Landing.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
