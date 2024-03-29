/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text; 
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import model.Kampanye;
import utils.KampanyeDAO;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class OrganisasiDashboardBuatKampanyeController implements Initializable {

    @FXML
    private AnchorPane page_profil;
    @FXML
    private HBox butttonProfil_PageKampanye;
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
    private Button saveBtn;
    @FXML
    private TextArea txtDeskripsi;
    @FXML
    private ImageView imgView;
    @FXML
    private Label labelImgView;
    @FXML
    private Button cancelAndBackBtn;
    @FXML
    private TextField nama;
    @FXML
    private Button uploadBtn;
    @FXML
    private TextField txtAlamat;
    @FXML
    private DatePicker tglTanam;
    @FXML
    private TextField txtJenisPohon;
    @FXML
    private TextField txtTargetVolunteer;
    @FXML
    private TextField txtTargetDonasi;
    @FXML
    private DatePicker tglBatasDonasi;
    @FXML
    private ImageView logout;
    @FXML
    private TextField txtJudul;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
     
    public boolean isInputValid(){
        return isNotEmpty(txtJenisPohon.getText())
               && isNotEmpty(txtJudul.getText())
               && isNotEmpty(txtAlamat.getText())
               && isNotEmpty(txtDeskripsi.getText())
               && isInteger(txtTargetVolunteer.getText())
               && isInteger(txtTargetDonasi.getText())
               && isDateValid(tglTanam.getValue())
               && isDateValid(tglBatasDonasi.getValue());
    }
    
    private boolean isNotEmpty(String text) {
        return !text.trim().isEmpty();
    }
    
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean isDateValid(LocalDate selectedDate) {
        LocalDate sevenDaysFromNow = LocalDate.now().plusDays(7);
        return selectedDate.isEqual(sevenDaysFromNow) || selectedDate.isAfter(sevenDaysFromNow);
    }
    
    public byte[] getImageData(ImageView imageView) {
        Image image = imageView.getImage();
        if (image != null) {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try {
                ImageIO.write(bufferedImage, "png", baos);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the IOException if needed
            }

            return baos.toByteArray();
        } else {
            return null;
        }
    }
    
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
    private void buatKampanye(ActionEvent event) throws IOException {
        byte[] dataGambar = getImageData(imgView);
        if(isInputValid()&& dataGambar!=null){
           try{
            //Kampanye(String nama, String deskripsi, int targetVolunteer, String lokasi, long targetPendanaan, 
            //Date tanggalPenanaman, String jenisPohon, Date batasDonasi, byte[] dataGambar, Organisasi penyelenggara)
            Kampanye k = new Kampanye(txtJudul.getText(), txtDeskripsi.getText(), Integer.parseInt(txtTargetVolunteer.getText()), txtAlamat.getText(),
                                      Long.parseLong(txtTargetDonasi.getText()), Date.valueOf(tglTanam.getValue()), txtJenisPohon.getText(), Date.valueOf(tglBatasDonasi.getValue()),
                                      dataGambar, MainController.o);
            KampanyeDAO.saveKampanye(MainController.o, k);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Berhasil!");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Yeay, Kampanye Berhasil dibuat!");
                    successAlert.showAndWait();
                try {
                    Stage stage = (Stage) saveBtn.getScene().getWindow();
                    URL url = new File("src/main/java/view/OrganisasiDashboardKampanye.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setTitle("Leaf Link");
                    stage.setScene(scene);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
           } catch(HeadlessException e) {
                e.printStackTrace();
                showErrorAlert("Error occurred during registration. Please try again.");
            }
        }else{
            showErrorAlert("Tolong semuanya diisi ya!");
        }
    }

    @FXML
    private void cancelAndBack(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Batal dan Kembali");
        alert.setContentText("Apakah kamu yakin?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        
        if (result == ButtonType.OK) {
            try {
            Stage stage = (Stage) logout.getScene().getWindow();
            URL url = new File("src/main/java/view/OrganisasiDashboardKampanye.fxml").toURI().toURL();
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
    private void uploadImage(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih gambar terbaik untuk Kampanyemu!");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Image","*.jpg"), new FileChooser.ExtensionFilter("PNG Image", "*.png"), new FileChooser.ExtensionFilter("All image files","*.jpg","*.png"));
        Stage stage = (Stage) uploadBtn.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null){
            labelImgView.setText("");
            nama.setText(selectedFile.getName());
            String imagePath = selectedFile.toURI().toURL().toString();
            Image image = new Image(imagePath);
            imgView.setImage(image);
        }else{
            System.out.println("No file has been selected");
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
    
}
