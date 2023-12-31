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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.OrganisasiDAO;
import utils.PersonalDAO;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class LoginController implements Initializable {

    @FXML
    private RadioButton adminRadioBtn;

    @FXML
    private Text belumPunyaAkun;

    @FXML
    private Button btnSignUp;

    @FXML
    private Text label_email;

    @FXML
    private TextField login_email;

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

    @FXML
    private ImageView tombol_back;
    
    public static String selectedRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainController.a = null;
        MainController.p = null;
        MainController.o = null;
        selectedRole = null;
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
    void backToLandingPage(MouseEvent event) throws IOException {
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

    @FXML
    void openSignUpPage(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) tombol_back.getScene().getWindow();
            URL url = new File("src/main/java/view/DaftarSebagai.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void validateAndLogin(ActionEvent event) throws MalformedURLException, IOException {
        if(isInputValid()){
            try{
                if("personal".equals(selectedRole)){
                    MainController.p = PersonalDAO.validatePersonal(login_email.getText(), login_kataSandi.getText());
                }else if("organisasi".equals(selectedRole)){
                    MainController.o = OrganisasiDAO.validateOrganisasi(login_email.getText(), login_kataSandi.getText());
                }
                if (MainController.o != null|MainController.p != null) {
                    Stage stage = (Stage) login_masuk.getScene().getWindow();
                    URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setTitle("Leaf Link");
                    stage.setScene(scene);
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID EMAIL/KATA SANDI!!!");
                }
            }catch(HeadlessException e){
                e.printStackTrace();
            }
        }else{
            showErrorAlert("Tolong isi dengan data yang valid ya!");
        }
    }

}
