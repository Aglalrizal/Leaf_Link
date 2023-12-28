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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Organisasi;
import utils.OrganisasiDAO;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class OrganisasiController implements Initializable {

    @FXML
    private AnchorPane page_organisasi;
    @FXML
    private TextField organisasi_email;
    @FXML
    private Button organisasi_daftar;
    @FXML
    private TextField organisasi_alamat;
    @FXML
    private TextField organisasi_no;
    @FXML
    private TextField organisasi_namaOrganisasi;
    @FXML
    private TextField organisasi_username;
    @FXML
    private PasswordField organisasi_kataSandi;
    @FXML
    private TextArea organisasi_deskripsi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    private boolean isInputValid() {
    return isEmailValid(organisasi_email.getText())
            && isNotEmpty(organisasi_alamat.getText())
            && isPhoneNumberValid(organisasi_no.getText())
            && isNotEmpty(organisasi_namaOrganisasi.getText())
            && isNotEmpty(organisasi_username.getText())
            && isNotEmpty(organisasi_kataSandi.getText())
            && isNotEmpty(organisasi_deskripsi.getText());
    }

    private boolean isEmailValid(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("[0-9]+") && phoneNumber.length() >= 8;
    }

    private boolean isNotEmpty(String text) {
        return !text.trim().isEmpty();
    }
    
    private void showErrorAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
    }
    
    private void switchToLoginPage() {
        try {
            Stage stage = (Stage) page_organisasi.getScene().getWindow();
            URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            showErrorAlert("Error occurred while loading login page.");
        }
    }
    
    @FXML
    private void registerOrganisasi(ActionEvent event) throws IOException {
        if (isInputValid()) {
            try {
                if(OrganisasiDAO.checkEmail(organisasi_email.getText())) {
                    showErrorAlert("Pendaftaran gagal! Email sudah terdaftar!");
                } else {
                    Organisasi o = new Organisasi(organisasi_namaOrganisasi.getText(), organisasi_username.getText(), organisasi_email.getText(),
                                                    organisasi_no.getText(), organisasi_alamat.getText(), organisasi_kataSandi.getText(), 
                                                    organisasi_deskripsi.getText());
                    OrganisasiDAO.registerOrganisasi(o);
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Yeay, Berhasil mendaftar!");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Silahkan login!");
                    successAlert.showAndWait();
                    switchToLoginPage();
                }
            } catch(HeadlessException e) {
                e.printStackTrace();
                showErrorAlert("Error occurred during registration. Please try again.");
            }
        } else {
            showErrorAlert("Tolong isi dengan data yang valid ya!");
        }
    }
}
