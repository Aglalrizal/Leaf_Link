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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.User;
import model.Admin;
import model.Personal;
import model.Organisasi;
import utils.OrganisasiDAO;
import utils.PersonalDAO;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class LoginController implements Initializable {
    
    public Admin admin;
    public Organisasi org;
    public Personal pers;

     @FXML
    private RadioButton adminRadioBtn;

    @FXML
    private Text belumPunyaAkun;

    @FXML
    private Text loginEmail;

    @FXML
    private PasswordField login_kataSandi;

    @FXML
    private Button login_masuk;

    @FXML
    private Text lupaKataSandi;

    @FXML
    private RadioButton organisasiRadioBtn;

    @FXML
    private AnchorPane page_login;

    @FXML
    private RadioButton personalRadioBtn;

    @FXML
    private ToggleGroup role;
    
    private String selectedRole;
    @FXML
    private TextField login_email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        admin = null;
        org = null;
        pers = null;
    }    
    
    private boolean isInputValid() {
        return isEmailValid(login_email.getText())
            && isNotEmpty(login_kataSandi.getText());
    }
    
    private boolean isEmailValid(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
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
    
    @FXML
    private void chooseRole(ActionEvent event) {
        if (personalRadioBtn.isSelected()) {
            selectedRole = "personal";
        }else if (organisasiRadioBtn.isSelected()) {
            selectedRole = "organisasi";
        }else{
            selectedRole = "admin";
        }
    }

    @FXML
    private void login(ActionEvent event) throws MalformedURLException, IOException {
        if(isInputValid()){
            try{
                if("personal".equals(selectedRole)){
                    pers = PersonalDAO.validatePersonal(login_email.getText(), login_kataSandi.getText());
                }else if("organisasi".equals(selectedRole)){
                    org = OrganisasiDAO.validateOrganisasi(login_email.getText(), login_kataSandi.getText());
                }
                if (org != null|pers != null) {
                    Stage stage = (Stage) login_masuk.getScene().getWindow();
                    URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID USERNAME/PASSWORD!!!");
                }
            }catch(HeadlessException e){
                e.printStackTrace();
            }
        }else{
            showErrorAlert("Tolong isi dengan data yang valid ya!");
        }
    }
}
