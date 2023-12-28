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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class HomeController implements Initializable {

    @FXML
    private HBox header;
    @FXML
    private Text homeName;
    @FXML
    private HBox boxSlide;
    @FXML
    private AnchorPane page_home;
    @FXML
    private Label button_tentangKami;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private Button button_headerProfil;
    @FXML
    private ImageView gambarPageHome;
    @FXML
    private HBox aksi1;
    @FXML
    private HBox aksi2;
    @FXML
    private HBox aksi3;
    @FXML
    private ImageView gambarAksi3;
    @FXML
    private HBox aksi4;
    @FXML
    private ImageView gambarAksi4;
    @FXML
    private ImageView prev;
    @FXML
    private ImageView next;
    @FXML
    private Label jml_donasi;
    @FXML
    private Label jml_volunteer;
    @FXML
    private Label jml_kampanye;
    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private Text homeName1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
