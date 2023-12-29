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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Admin;
import model.Organisasi;
import model.Personal;
import model.User;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class MainController implements Initializable {
    
    public static User user;
    public static Organisasi o;
    public static Personal p;
    public static Admin a;
    
    @FXML
    private Label button_tentangKami;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private Button button_masuk;
    @FXML
    private Button button_daftar;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = null;
        o = null;
        p = null;
        a = null;
    }    

    @FXML
    private void openLoginPage(ActionEvent event) {
        try {
            Stage stage = (Stage) button_masuk.getScene().getWindow();
            URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
       } catch (HeadlessException | IOException e) {
            e.printStackTrace();
       }
    }

    @FXML
    private void openSignUp(ActionEvent event) {
        try {
            Stage stage = (Stage) button_daftar.getScene().getWindow();
            URL url = new File("src/main/java/view/DaftarSebagai.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch(HeadlessException | IOException e) {
            e.printStackTrace();
       }
    }
}
