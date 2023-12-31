/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Volunteer;
import utils.VolunteerDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class PersonalDashboardRiwayatVolunteerController implements Initializable {

    @FXML
    private AnchorPane page_riwayatKampanye;
    @FXML
    private HBox button_profil;
    @FXML
    private HBox riwayatVolunteer;
    @FXML
    private Text butttonRiwayat_PageKampanye;
    
    @FXML
    private TableView<Volunteer> tabel;
   
    @FXML
    private TableColumn<Volunteer, String> tabelJudul;

    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private HBox header;
    @FXML
    private Label button_tentangKami;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private ImageView logout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
    }    

    @FXML
    private void logout(MouseEvent event) {
    }
    
    private void fillTable(){
        ArrayList<Volunteer> res = VolunteerDAO.getAllbyUser(MainController.p);
        
        tabel.getColumns().clear();
        tabel.getItems().clear();
        
        tabelJudul.setCellValueFactory(new PropertyValueFactory<>("namaKampanye"));
        
        for (Volunteer v: res) {
            System.out.println("Nama: "+v.getNamaKampanye());
            tabel.getItems().add(v);
        }
    }
}
