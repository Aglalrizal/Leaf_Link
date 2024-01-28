/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import static controller.HomeController.a;
import java.io.ByteArrayInputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artikel;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class ShowArtikelController implements Initializable {

    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private Text txtJudul;
    @FXML
    private ImageView imgView;
    @FXML
    private Text txtIsi;
    @FXML
    private Text txtAuthor;
    @FXML
    private HBox header1;
    @FXML
    private Label button_tentangKami1;
    @FXML
    private Label button_artikel1;
    @FXML
    private Label button_kampanye1;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        txtJudul.setText(HomeController.a.getJudul());
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(HomeController.a.getDataGambar());
//        Image image = new Image(inputStream);
//        imgView.setImage(image);
//        txtIsi.setText(HomeController.a.getIsi());
//        txtAuthor.setText(HomeController.a.getAuthor().getNama());
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
    private void back(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            URL url = new File("src/main/java/view/ArtikelHome.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setData(Artikel rowData) {
        txtJudul.setText(rowData.getJudul());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rowData.getDataGambar());
        Image image = new Image(inputStream);
        imgView.setImage(image);
        txtIsi.setText(rowData.getIsi());
        txtAuthor.setText(rowData.getAuthor().getNama());
    }

    @FXML
    private void goToHome(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
