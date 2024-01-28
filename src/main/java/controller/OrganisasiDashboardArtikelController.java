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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artikel;
import model.Kampanye;
import utils.ArtikelDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class OrganisasiDashboardArtikelController implements Initializable {

    @FXML
    private AnchorPane page_profil;
    @FXML
    private HBox daftarKampanye;
    @FXML
    private Button backToHomeBtn;
    @FXML
    private HBox daftarArtikel;
    @FXML
    private HBox header;
    @FXML
    private Label button_tentangKami;
    @FXML
    private Label button_artikel;
    @FXML
    private Label button_kampanye;
    @FXML
    private Text contactUs;
    @FXML
    private ImageView fb;
    @FXML
    private ImageView ig;
    @FXML
    private ImageView tw;
    @FXML
    private ImageView logout;
    @FXML
    private Button buatArtikelBtn;
    @FXML
    private HBox buttonProfil;
    @FXML
    private TableView<Artikel> tabel;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HomeController.a = null;
        fillTable();
    }    

    @FXML
    private void goToProfil(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) buttonProfil.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardProfil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToDaftarKampanye(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) daftarKampanye.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardKampanye.fxml").toURI().toURL();
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

    @FXML
    private void goToDaftarArtikel(MouseEvent event) throws IOException {
        try {
            Stage stage = (Stage) daftarArtikel.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardArtikel.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void goToBuatArtikel(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) buatArtikelBtn.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardBuatArtikel.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleButtonEvent(ActionEvent event) throws IOException {
        if (event.getSource() == deleteBtn) {
            try {
                Artikel a= tabel.getSelectionModel().getSelectedItem();
                ArtikelDAO.deleteArtikel(a);
                fillTable();
            } catch (HeadlessException e) {
                e.printStackTrace();
            }

        }
        if (event.getSource() == editBtn) {
            try {
                HomeController.a =  tabel.getSelectionModel().getSelectedItem();
                try {
                    Stage stage = (Stage) buatArtikelBtn.getScene().getWindow();
                    URL url = new File("src/main/java/view/OrganisasiDashboardEditArtikel.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setTitle("Leaf Link");
                    stage.setScene(scene);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (HeadlessException e) {
                e.printStackTrace();
            }

        }
    }

    
    private void fillTable() {
        ArrayList<Artikel> res = ArtikelDAO.getAllbyOrganisasi(MainController.o);
        
        tabel.getColumns().clear();
        tabel.getItems().clear();
        
        tabel.setRowFactory(tv -> {
        TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    Artikel rowData = row.getItem();
                    try {
                        Stage stage = (Stage) tabel.getScene().getWindow();
                        URL url = new File("src/main/java/view/ShowArtikelDashboard.fxml").toURI().toURL();
                        FXMLLoader loader = new FXMLLoader(url);
                        Parent root = loader.load();
                        ShowArtikelController controller = loader.getController();
                        controller.setData(rowData);
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        //stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });
        
        TableColumn<Artikel, String> no = new TableColumn<>("#");
        no.setCellValueFactory(cellData -> {
            Integer indexValue = tabel.getItems().indexOf(cellData.getValue()) + 1;
            return new javafx.beans.property.SimpleStringProperty(indexValue.toString());
        });
        TableColumn<Artikel, String> cl1 = new TableColumn<>("Judul Artikel");
        cl1.setCellValueFactory(new PropertyValueFactory<>("judul"));
        
        no.setPrefWidth(50);
        cl1.setPrefWidth(650);
        tabel.getColumns().add(no);
        tabel.getColumns().add(cl1);
        

        // Add data to table
        for (Artikel a : res) {
            tabel.getItems().add(a);
        }
    }

}
