/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aglalrizal
 */
import java.util.ArrayList;
import java.util.Date;
import utils.DonasiDAO;

public class Personal extends User {
    private String pekerjaan;

    private ArrayList<Kampanye> riwayatKampanye = new ArrayList<>();
    private ArrayList<Donasi> riwayatDonasi = new ArrayList<>();
    private String tanggalLahir;
    public Personal(){
        super();
        this.role = "Personal";
    }
    public Personal(String nama, String username, String email, String noHp, String alamat, String password, String pekerjaan, String tanggalLahir){
        super(nama, username, email, noHp, alamat, password);
        this.role = "Personal";
        this.pekerjaan = pekerjaan;
        this.tanggalLahir = tanggalLahir;
    }
    
    public void donasi(long jml_sumbangan, Kampanye k){
        Donasi d = new Donasi(k, this, jml_sumbangan);
        DonasiDAO.saveDonasi(d);
    }
    
    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public ArrayList<Kampanye> getRiwayatKampanye() {
        return riwayatKampanye;
    }

    public void setRiwayatKampanye(ArrayList<Kampanye> riwayatKampanye) {
        this.riwayatKampanye = riwayatKampanye;
    }
    public void addRiwayatKampanye(Kampanye kampanye){
        this.riwayatKampanye.add(kampanye);
    }
    
    public void addRiwayatDonasi(Donasi donasi){
        this.riwayatDonasi.add(donasi);
    }
    
    public void showRiwayatKampanye(){
        
    }

    public ArrayList<Donasi> getRiwayatDonasi() {
        return riwayatDonasi;
    }

    public void setRiwayatDonasi(ArrayList<Donasi> riwayatDonasi) {
        this.riwayatDonasi = riwayatDonasi;
    }
        
    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    public void display(){
        System.out.println(this.toString());
    }
//    Personal(String username, String nama, String email, String noHp, String alamat, String password, String pekerjaan, Date tanggalLahir)
    public String toString() {
        return "UserId: "+getIdUser()+ "\n" +
                "Username: "+ getUsername()+ "\n" +
                "Nama: "+ getNama()+ "\n" +
                "Email: "+getEmail()+ "\n" +
                "Nomor Telepon: "+getNoHp()+ "\n" +
                "Alamat: "+getAlamat()+ "\n" +
                "Pekerjaan: "+getPekerjaan()+ "\n" +
                "Tanggal Lahir: "+getTanggalLahir();
    }
}