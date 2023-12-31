/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.LoginController;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class HomeController implements Initializable {

    @FXML
    private ScrollPane page_home;
    @FXML
    private HBox header1;
    @FXML
    private Label button_tentangKami;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private Text contactUs1;
    @FXML
    private ImageView fb1;
    @FXML
    private ImageView ig1;
    @FXML
    private ImageView tw1;
    @FXML
    private Label home_nama;
    @FXML
    private ImageView imgHome_artikel;
    @FXML
    private VBox box_frame1;
    @FXML
    private ImageView frame1;
    @FXML
    private Text judlFrame1;
    @FXML
    private Text penyelenggaraFrame2;
    @FXML
    private Text hariFrame1;
    @FXML
    private VBox box_frame2;
    @FXML
    private ImageView frame2;
    @FXML
    private Text judulFrame2;
    @FXML
    private Text hariFrame2;
    @FXML
    private VBox box_frame3;
    @FXML
    private ImageView frame3;
    @FXML
    private Text judulFrame3;
    @FXML
    private Text penyelenggaraFrame3;
    @FXML
    private Text hariFrame3;
    @FXML
    private VBox box_frame4;
    @FXML
    private ImageView frame4;
    @FXML
    private Text judulFrame4;
    @FXML
    private Text penyelenggaraFrame4;
    @FXML
    private Text hariFrame4;
    @FXML
    private ImageView prev;
    @FXML
    private ImageView next;
    @FXML
    private Label jml_donasi;
    @FXML
    private Label jml_volunteer;
    @FXML
    private Label jml_kampanye;
    @FXML
    private ImageView logout;
    @FXML
    private Pane dashboard;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(null != LoginController.selectedRole)
            switch (LoginController.selectedRole) {
            case "personal":
                home_nama.setText("Hai, "+MainController.p.getUsername()+"!");
                break;
            case "organisasi":
                home_nama.setText("Hai, "+MainController.o.getUsername()+"!");
                break;
            case "admin":
                break;
            default:
                break;
        }
    }    

    @FXML
    private void logout(MouseEvent event) throws IOException {   
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Logout");
        alert.setContentText("Apakah kamu yakin ingin logout?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {
            try {
            Stage stage = (Stage) logout.getScene().getWindow();
            URL url = new File("src/main/java/view/Landing.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @FXML
    private void goToDashboard(MouseEvent event) throws IOException {
        if("personal".equals(LoginController.selectedRole)){
            try {
            Stage stage = (Stage) logout.getScene().getWindow();
            URL url = new File("src/main/java/view/PersonalDashboardProfil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("organisasi".equals(LoginController.selectedRole)){
            try {
            Stage stage = (Stage) logout.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardProfil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("admin".equals(LoginController.selectedRole)){
            
        }
    }
}
