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
import model.Kampanye;
import utils.KampanyeDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class OrganisasiDashboardKampanyeController implements Initializable {

    @FXML
    private AnchorPane page_profil;
    @FXML
    private HBox buttonProfil;
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
    private TableView<Kampanye> table;
    @FXML
    private Button buatKampanyeBtn;

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
    private void goToBuatKampanyePage(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) buatKampanyeBtn.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardBuatKampanye.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("Leaf Link");
            stage.setScene(scene);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillTable(){
        ArrayList<Kampanye> res = KampanyeDAO.getAllbyOrganisasi(MainController.o);
        
        table.getColumns().clear();
        table.getItems().clear();
        
        table.setRowFactory(tv -> {
        TableRow<Kampanye> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    Kampanye rowData = row.getItem();
                    try {
                        HomeController.k = rowData;
                        Stage stage = (Stage) table.getScene().getWindow();
                        URL url = new File("src/main/java/view/ShowKampanyeDashboard.fxml").toURI().toURL();
                        FXMLLoader loader = new FXMLLoader(url);
                        Parent root = loader.load();
                        ShowKampanyeDashboardController controller = loader.getController();
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
        
        TableColumn<Kampanye, String> no = new TableColumn<>("#");
        no.setCellValueFactory(cellData -> {
            Integer indexValue = table.getItems().indexOf(cellData.getValue()) + 1;
            return new javafx.beans.property.SimpleStringProperty(indexValue.toString());
        });
        
        TableColumn<Kampanye, String> c2 = new TableColumn<>("Judul Kampanye");
        c2.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Kampanye, String> c3 = new TableColumn<>("Lokasi");
        c3.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        TableColumn<Kampanye, String> c4 = new TableColumn<>("Target Pendanaan");
        c4.setCellValueFactory(new PropertyValueFactory<>(String.valueOf("targetPendanaan")));
        TableColumn<Kampanye, String> c5 = new TableColumn<>("Volunteer yang dibutuhkan");
        c5.setCellValueFactory(new PropertyValueFactory<>(String.valueOf("targetVolunteer")));
        
//        TableColumn<Kampanye, String> c4 = new TableColumn<>("Penulis");
//        c3.setCellValueFactory(data -> {
//            Kampanye artikel = data.getValue();
//            if (artikel != null) {
//                Organisasi organisasi = artikel.getAuthor();
//                if (organisasi != null) {
//                    return new SimpleStringProperty(organisasi.getNama());
//                }
//            }
//            return new SimpleStringProperty("");
//        });
        
        no.setPrefWidth(30);
        c2.setPrefWidth(370);
        c3.setPrefWidth(157);
        c4.setPrefWidth(200);
        c5.setPrefWidth(200);
        table.getColumns().add(no);
        table.getColumns().add(c2);
        table.getColumns().add(c3);
        table.getColumns().add(c4);
        table.getColumns().add(c5);

        // Add data to table
        for (Kampanye a : res) {
            table.getItems().add(a);
        }
    }
}
