/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.io.ByteArrayInputStream;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artikel;
import utils.ArtikelDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class OrganisasiDashboardEditArtikelController implements Initializable {

    @FXML
    private AnchorPane editArtikelPage;
    @FXML
    private HBox buttonProfil;
    @FXML
    private HBox daftarKampanye;
    @FXML
    private Button backToHomeBtn;
    @FXML
    private HBox daftarArtikel;
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
    private Button saveBtn;
    @FXML
    private TextArea txtIsi;
    @FXML
    private ImageView imgView;
    @FXML
    private Label labelImgView;
    @FXML
    private Button cancelAndBackBtn;
    @FXML
    private ImageView logout;
    @FXML
    private TextField txtJudul;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtJudul.setText(HomeController.a.getJudul());
        txtIsi.setText(HomeController.a.getIsi());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(HomeController.a.getDataGambar());
        Image image = new Image(inputStream);
        imgView.setImage(image);
    }

    public boolean isInputValid(){
        return isNotEmpty(txtIsi.getText())
               && isNotEmpty(txtJudul.getText());
    }
    
    private boolean isNotEmpty(String text) {
        return !text.trim().isEmpty();
    }

    @FXML
    private void goToProfil(MouseEvent event) throws IOException {
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
    }

        private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToDaftarKampanye(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) daftarKampanye.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardKampanye.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void goToDaftarArtikel(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) daftarArtikel.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardKampanye.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @FXML
    private void saveArtikel(ActionEvent event) throws IOException {
        if(isInputValid()){
           try{
            ArtikelDAO.updateArtikel(txtJudul.getText(), txtIsi.getText(), HomeController.a);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Berhasil!");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Yeay, Berhasil Mengedit Artikel!");
                    successAlert.showAndWait();
                try {
                    Stage stage = (Stage) saveBtn.getScene().getWindow();
                    URL url = new File("src/main/java/view/OrganisasiDashboardArtikel.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setTitle("Leaf Link");
                    stage.setScene(scene);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
           } catch(HeadlessException e) {
                e.printStackTrace();
                showErrorAlert("Error occurred during registration. Please try again.");
            }
        }else{
            showErrorAlert("Tolong semuanya diisi ya!");
        }
    }

    @FXML
    private void cancelAndBack(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Batal dan Kembali");
        alert.setContentText("Apakah kamu yakin?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        
        if (result == ButtonType.OK) {
            try {
            Stage stage = (Stage) logout.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardArtikel.fxml").toURI().toURL();
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
}
