/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    
}
