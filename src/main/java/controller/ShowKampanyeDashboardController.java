/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.ByteArrayInputStream;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Kampanye;
import utils.VolunteerDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class ShowKampanyeDashboardController implements Initializable {
    

    @FXML
    private AnchorPane halamanKampanye1;
    @FXML
    private Text namaKampanye;
    @FXML
    private Text penyelenggaraKampanye;
    @FXML
    private Text deskripsiKampanye;
    @FXML
    private Button donasiKampanye;
    @FXML
    private Button volunteerKampanye;
    @FXML
    private Label lokasiKampanye;
    @FXML
    private Label pohonKampanye;
    @FXML
    private Label pelaksanaanKampanye;
    @FXML
    private Label batasDonasiKampanye;
    @FXML
    private Label donasiTerkumpul;
    @FXML
    private Label volunteerTerdaftar;
    @FXML
    private Label showAllKampanye;
    @FXML
    private ImageView gambarKampanye;
    @FXML
    private HBox header;
    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private ImageView tombol_back;
    @FXML
    private Label button_home;
    @FXML
    private Label button_kampanye;
    @FXML
    private Label button_artikel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if("organisasi".equals(LoginController.selectedRole)){
            volunteerKampanye.setDisable(true);
            volunteerKampanye.setVisible(false);
        }
    }    

    @FXML
    private void donasi(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) halamanKampanye1.getScene().getWindow();
            URL url = new File("src/main/java/view/Donasi.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            stage.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mendaftarVolunteer(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Daftar Volunteer");
        alert.setContentText("Apakah kamu yakin?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {
            MainController.p.volunteer(HomeController.k);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Volunteer");
            successAlert.setContentText("Yeay, Berhasil mendaftar!");
            successAlert.showAndWait();
            try {
                        Stage stage = (Stage) volunteerKampanye.getScene().getWindow();
                        URL url = new File("src/main/java/view/ShowKampanye.fxml").toURI().toURL();
                        FXMLLoader loader = new FXMLLoader(url);
                        Parent root = loader.load();
                        ShowKampanyeDashboardController controller = loader.getController();
                        controller.setData(HomeController.k);
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   @FXML
    private void goToHome(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) button_home.getScene().getWindow();
            URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToArtikel(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) button_artikel.getScene().getWindow();
            URL url = new File("src/main/java/view/ArtikelHome.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToKampanye(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) button_kampanye.getScene().getWindow();
            URL url = new File("src/main/java/view/KampanyeHome.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link"); 
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void back(MouseEvent event) throws IOException {
        if("personal".equals(LoginController.selectedRole)){
            try {
            Stage stage = (Stage) tombol_back.getScene().getWindow();
            URL url = new File("src/main/java/view/PersonalDashboardProfil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("organisasi".equals(LoginController.selectedRole)){
            try {
            Stage stage = (Stage) tombol_back.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardProfil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void setData(Kampanye rowData) {
        HomeController.k = rowData;
       
        if(VolunteerDAO.isRegistered(MainController.p.getIdUser().toString(), HomeController.k.getIdKampanye().toString())){
            volunteerKampanye.setDisable(true);
            volunteerKampanye.setText("Sudah Mendaftar!");
            volunteerKampanye.setPrefWidth(150);
        }
        namaKampanye.setText(rowData.getNama());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(rowData.getDataGambar());
        Image image = new Image(inputStream);
        gambarKampanye.setImage(image);
        deskripsiKampanye.setText(rowData.getDeskripsi());
        lokasiKampanye.setText(rowData.getLokasi());
        pohonKampanye.setText(rowData.getJenisPohon());
        pelaksanaanKampanye.setText(rowData.getTanggalPenanaman().toString());
        batasDonasiKampanye.setText(rowData.getBatasDonasi().toString());
        donasiTerkumpul.setText(String.valueOf(rowData.getSumbangan()));
        volunteerTerdaftar.setText(String.valueOf(rowData.getJmlVolunteer()));
    }
}
