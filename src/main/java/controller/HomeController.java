/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.LoginController;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artikel;
import model.Kampanye;
import model.Volunteer;
import utils.ArtikelDAO;
import utils.DonasiDAO;
import utils.KampanyeDAO;
import utils.VolunteerDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class HomeController implements Initializable {
    
    public static Artikel a;
    public static Kampanye k;

    @FXML
    private ScrollPane page_home;
    @FXML
    private HBox header1;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private Text contactUs1;
    @FXML
    private ImageView fb1;
    @FXML
    private ImageView ig1;
    @FXML
    private ImageView tw1;
    @FXML
    private Label home_nama;
    @FXML
    private Label jml_donasi;
    @FXML
    private Label jml_volunteer;
    @FXML
    private Label jml_kampanye;
    @FXML
    private ImageView logout;
    @FXML
    private Pane dashboard;
    @FXML
    private ImageView imgArtikel;
    @FXML
    private Label txtJudulArtikel;
    
    @FXML
    private Label button_home;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(null != LoginController.selectedRole){
                switch (LoginController.selectedRole) {
                case "personal":
                    home_nama.setText("Hai, "+MainController.p.getUsername()+"!");
                    break;
                case "organisasi":
                    home_nama.setText("Hai, "+MainController.o.getUsername()+"!");
                    break;
                case "admin":
                    break;
                default:
                    break;
            }
        }
        k = null;
        a = ArtikelDAO.getLatest();
        txtJudulArtikel.setText(a.getJudul());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(a.getDataGambar());
        Image image = new Image(inputStream);
        imgArtikel.setImage(image);
        
        ArrayList<Kampanye> allKampanye = KampanyeDAO.getAll();
        ArrayList<Volunteer> allVolunteer = VolunteerDAO.getAll();
        
        jml_kampanye.setText(String.valueOf(allKampanye.size()));
        jml_donasi.setText(String.valueOf(DonasiDAO.totalDonasiAll()));
        jml_volunteer.setText(String.valueOf(allVolunteer.size())); 
        
        
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

    @FXML
    private void goToDashboard(MouseEvent event) throws IOException {
        if("personal".equals(LoginController.selectedRole)){
            try {
            Stage stage = (Stage) page_home.getScene().getWindow();
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
            Stage stage = (Stage) page_home.getScene().getWindow();
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

    @FXML
    private void showArtikel(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) imgArtikel.getScene().getWindow();
                        URL url = new File("src/main/java/view/ShowArtikel.fxml").toURI().toURL();
                        FXMLLoader loader = new FXMLLoader(url);
                        Parent root = loader.load();
                        ShowArtikelController controller = loader.getController();
                        controller.setData(a);
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
}
