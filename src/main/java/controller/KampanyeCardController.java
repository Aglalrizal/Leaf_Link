/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Kampanye;

/**
 * FXML Controller class
 *
 * @author rizal
 */
public class KampanyeCardController{

    @FXML
    private ImageView imgView;
    @FXML
    private Text txtOwner;
    @FXML
    private Text txtJmlHari;
    @FXML
    private Text txtJudul;
    
    LocalDate today = LocalDate.now();
    
    public void setData(Kampanye k){
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(k.getDataGambar());
//        Image image = new Image(inputStream);
        
        //imgView.setImage(image);
        txtJudul.setText(k.getNama());
        txtOwner.setText("Penyelenggara: " + k.getPenyelenggara().getNama());

        // Mendapatkan tanggal dari atribut tanggalPelaksanaan (misalkan date adalah tipe java.util.Date)
        java.util.Date date = k.getTanggalPenanaman();

        // Mengonversi java.util.Date menjadi LocalDate
        LocalDate tanggalPelaksanaan = new java.sql.Date(date.getTime()).toLocalDate();

        // Menghitung selisih antara tanggal hari ini dan tanggalPelaksanaan
        long selisihHari = ChronoUnit.DAYS.between(today, tanggalPelaksanaan);
        txtJmlHari.setText(selisihHari + "Hari lagi!");
    }
}
