/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
public class PersonalDashboardProfilController implements Initializable {

    @FXML
    private Button backToHomeBtn;


    @FXML
    private Button buttonProfil_ubah;

    @FXML
    private Label button_artikel;

    @FXML
    private Label button_kampanye;

    @FXML
    private Label button_tentangKami;

    @FXML
    private Text contactUs;

    @FXML
    private ImageView fb;

    @FXML
    private HBox header;

    @FXML
    private ImageView ig;

    @FXML
    private ImageView logout;

    @FXML
    private AnchorPane page_profil;

    @FXML
    private TextField profil_alamat;

    @FXML
    private TextField profil_email;

    @FXML
    private TextField profil_nama;

    @FXML
    private TextField profil_no;

    @FXML
    private TextField profil_pekerjaan;

    @FXML
    private TextField profil_tanggalLahir;

    @FXML
    private TextField profil_username;

    @FXML
    private ImageView tw;
    @FXML
    
    private HBox butttonProfil;
    @FXML
    private HBox riwayatVolunteer;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        profil_email.setText(MainController.p.getEmail());
        profil_username.setText(MainController.p.getUsername());
        profil_nama.setText(MainController.p.getNama());
        profil_alamat.setText(MainController.p.getAlamat());
        profil_no.setText(MainController.p.getNoHp());
        profil_pekerjaan.setText(MainController.p.getPekerjaan());
        profil_tanggalLahir.setText(MainController.p.getTanggalLahir().toString());
    }    

    @FXML
    private void backToHome(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) backToHomeBtn.getScene().getWindow();
            URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void goToRiwayatVolunteer(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) riwayatVolunteer.getScene().getWindow();
            URL url = new File("src/main/java/view/PersonalDashboardRiwayatVolunteer.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
