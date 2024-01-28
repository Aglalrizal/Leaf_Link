/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artikel;
import model.Volunteer;
import utils.VolunteerDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class PersonalDashboardRiwayatVolunteerController implements Initializable {

    @FXML
    private HBox button_profil;
    @FXML
    private HBox riwayatVolunteer;
    @FXML
    private Text butttonRiwayat_PageKampanye;
    
    @FXML
    private TableView<Volunteer> tabel;
   
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
    @FXML
    private AnchorPane page_riwayatVolunteer;
    @FXML
    private HBox riwayatDonasi;
    @FXML
    private Text butttonRiwayat_PageKampanye1;
    @FXML
    private Button backToHomeBtn;

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
    private void logout(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Logout");
        alert.setContentText("Apakah kamu yakin ingin logout?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        
        if (result == ButtonType.OK) {
            try {
            Stage stage = (Stage) logout.getScene().getWindow();
            URL url = new File("src/main/java/view/Landing.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void fillTable(){
        ArrayList<Volunteer> res = VolunteerDAO.getAllbyUser(MainController.p);
        
        tabel.getColumns().clear();
        tabel.getItems().clear();
        
        TableColumn<Volunteer, String> no = new TableColumn<>("#");
        no.setCellValueFactory(cellData -> {
            Integer indexValue = tabel.getItems().indexOf(cellData.getValue()) + 1;
            return new javafx.beans.property.SimpleStringProperty(indexValue.toString());
        });
        TableColumn<Volunteer, String> cl1 = new TableColumn<>("Nama Kampanye");
        cl1.setCellValueFactory(new PropertyValueFactory<>("namaKampanye"));
        
        no.setPrefWidth(50);
        cl1.setPrefWidth(650);
        no.getColumns().add(no);
        tabel.getColumns().add(cl1);

        // Add data to table
        for (Volunteer v : res) {
            tabel.getItems().add(v);
        }
    }

    @FXML
    private void goToProfil(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) button_profil.getScene().getWindow();
            URL url = new File("src/main/java/view/PersonalDashboardProfil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToRiwayatVolunteer(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) riwayatVolunteer.getScene().getWindow();
            URL url = new File("src/main/java/view/PersonalDashboardRiwayatVolunteer.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToRiwayatDonasi(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) riwayatDonasi.getScene().getWindow();
            URL url = new File("src/main/java/view/PersonalDashboardRiwayatDonasi.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backToHome(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) backToHomeBtn.getScene().getWindow();
            URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
