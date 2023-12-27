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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class UbahProfilController implements Initializable {

    @FXML
    private HBox header;
    @FXML
    private AnchorPane page_ubahProfil;
    @FXML
    private HBox butttonProfil_PageKampanye;
    @FXML
    private HBox butttonRiwayat_PageKampanye;
    @FXML
    private Label button_tentangKami;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private Button button_headerProfil;
    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private TextField ubah_email;
    @FXML
    private TextField ubah_namaOrganisasi;
    @FXML
    private TextField ubah_username;
    @FXML
    private TextField ubah_ttl;
    @FXML
    private TextField ubah_alamat;
    @FXML
    private TextField ubah_no;
    @FXML
    private TextField ubah_pekerjaan;
    @FXML
    private Button button_simpanPerubahan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
