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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Acer OLED
 */
public class ProfilPageRiwayatKampanyeController implements Initializable {

    @FXML
    private HBox header;
    @FXML
    private AnchorPane page_riwayatKampanye;
    @FXML
    private HBox butttonProfil_PageKampanye;
    @FXML
    private Text butttonRiwayat_PageKampanye;
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
    private TableView<?> tabel;
    @FXML
    private TableColumn<?, ?> tabelNo;
    @FXML
    private TableColumn<?, ?> tabelJudul;
    @FXML
    private TableColumn<?, ?> tabelTanggal;
    @FXML
    private TableColumn<?, ?> tabelAksi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
