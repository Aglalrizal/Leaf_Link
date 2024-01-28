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
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artikel;
import model.Organisasi;
import utils.ArtikelDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class ArtikelHomeController implements Initializable {
    
    

    @FXML
    private ScrollPane page_home;
    @FXML
    private HBox header1;
    private Label buttonHome;
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
    private ImageView logout;
    @FXML
    private Pane dashboard;
    @FXML
    private TableView<Artikel> tabel;
    @FXML
    private Label button_home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
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
            Stage stage = (Stage) logout.getScene().getWindow();
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
            Stage stage = (Stage) logout.getScene().getWindow();
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
    
    private void fillTable(){
        ArrayList<Artikel> res = ArtikelDAO.getAll();
        
        tabel.getColumns().clear();
        tabel.getItems().clear();
        
        tabel.setRowFactory(tv -> {
        TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    Artikel rowData = row.getItem();
                    try {
                        Stage stage = (Stage) tabel.getScene().getWindow();
                        URL url = new File("src/main/java/view/ShowArtikel.fxml").toURI().toURL();
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
        
        TableColumn<Artikel, String> c2 = new TableColumn<>("Judul Artikel");
        c2.setCellValueFactory(new PropertyValueFactory<>("judul"));
        
        TableColumn<Artikel, String> c3 = new TableColumn<>("Penulis");
        c3.setCellValueFactory(data -> {
            Artikel artikel = data.getValue();
            if (artikel != null) {
                Organisasi organisasi = artikel.getAuthor();
                if (organisasi != null) {
                    return new SimpleStringProperty(organisasi.getNama());
                }
            }
            return new SimpleStringProperty("");
        });
        
        no.setPrefWidth(30);
        c2.setPrefWidth(570);
        c3.setPrefWidth(287);
        tabel.getColumns().add(no);
        tabel.getColumns().add(c2);
        tabel.getColumns().add(c3);

        // Add data to table
        for (Artikel a : res) {
            tabel.getItems().add(a);
        }
    }
    
    private void showArtikel(MouseEvent event) throws IOException {
//        try {
//            Stage stage = (Stage) imgArtikel.getScene().getWindow();
//            URL url = new File("src/main/java/view/ShowArtikel.fxml").toURI().toURL();
//            Parent root = FXMLLoader.load(url);
//            Scene scene = new Scene(root);
//            stage.setTitle("Leaf Link");
//            stage.setScene(scene);
//            } catch (MalformedURLException ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
