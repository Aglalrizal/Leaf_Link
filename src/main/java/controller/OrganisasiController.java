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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Organisasi;
import model.User;
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
    private TextField organisasi_deskripsi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void registerOrganisasi(ActionEvent event) throws IOException {
        //Organisasi(String nama, String username, String email, String noHp, String alamat, String password, String deskripsi)
        Organisasi o = new Organisasi(organisasi_namaOrganisasi.getText(), organisasi_username.getText(), organisasi_email.getText(),
                                            organisasi_no.getText(), organisasi_alamat.getText(), organisasi_kataSandi.getText(), 
                                            organisasi_deskripsi.getText());
        OrganisasiDAO.registerOrganisasi(o);
        JOptionPane.showMessageDialog(null, " Registered " + organisasi_username.getText() + " Successfully. Please Login!");
    }
    
}
