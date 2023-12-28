/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Personal;
import utils.PersonalDAO;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class PersonalController implements Initializable {

    @FXML
    private AnchorPane page_personal;
    @FXML
    private TextField personal_email;
    @FXML
    private Button personal_daftar;
    @FXML
    private TextField personal_alamat;
    @FXML
    private TextField personal_nama;
    @FXML
    private TextField personal_username;
    @FXML
    private TextField personal_no;
    @FXML
    private TextField personal_pekerjaan;
    @FXML
    private PasswordField personal_kataSandi;
    @FXML
    private DatePicker personal_tanggalLahir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private boolean isInputValid() {
    return isEmailValid(personal_email.getText())
            && isNotEmpty(personal_alamat.getText())
            && isPhoneNumberValid(personal_no.getText())
            && isNotEmpty(personal_nama.getText())
            && isNotEmpty(personal_username.getText())
            && isNotEmpty(personal_kataSandi.getText())
            && isDOBValid(personal_tanggalLahir.getValue())
            && isNotEmpty(personal_pekerjaan.getText());
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
    public boolean isDOBValid(LocalDate selectedDate) {
    LocalDate seventeenYearsAgo = LocalDate.now().minusYears(17);
    return selectedDate.isBefore(seventeenYearsAgo);
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
            Stage stage = (Stage) page_personal.getScene().getWindow();
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
    private void daftarPersonal(ActionEvent event) {
            if (isInputValid()) {
            try {
                if(PersonalDAO.checkEmail(personal_email.getText())) {
                    showErrorAlert("Pendaftaran gagal! Email sudah terdaftar!");
                } else {
                    //constructor class Personal ->Personal(String username, String nama, String email, String noHp, String alamat, String password, String pekerjaan, Date tanggalLahir)
                    Personal p = new Personal(personal_username.getText(), personal_nama.getText(), personal_email.getText(),
                                                    personal_no.getText(), personal_alamat.getText(), personal_kataSandi.getText(), 
                                                    personal_pekerjaan.getText(), Date.valueOf(personal_tanggalLahir.getValue()));
                    PersonalDAO.registerPersonal(p);
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
