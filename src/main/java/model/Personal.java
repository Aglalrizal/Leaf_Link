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
import java.util.UUID;
import utils.DonasiDAO;
import utils.VolunteerDAO;

public class Personal extends User {
    private String pekerjaan;

    private ArrayList<Kampanye> riwayatVolunteer = new ArrayList<>();
    private ArrayList<Donasi> riwayatDonasi = new ArrayList<>();
    private Date tanggalLahir;
    
    public Personal(){
        super();
        this.role = "Personal";
    }
    
    public Personal(String nama, String username, String email, String noHp, String alamat, String password, String pekerjaan, Date tanggalLahir){
        super(nama, username, email, noHp, alamat, password);
        this.role = "Personal";
        this.pekerjaan = pekerjaan;
        this.tanggalLahir = tanggalLahir;
    }
    
    public Personal(UUID idUser, String nama, String username, String email, String noHp, String alamat, String password, String pekerjaan, Date tanggalLahir){
        super(idUser,nama, username, email, noHp, alamat, password);
        this.role = "Personal";
        this.pekerjaan = pekerjaan;
        this.tanggalLahir = tanggalLahir;
    }
     
    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
    
    public void volunteer(Kampanye k){
        Volunteer v = new Volunteer(this, k);
        VolunteerDAO.saveVolunteer(v);
    }
    
    public ArrayList<Kampanye> getRiwayatVolunteer() {
        return riwayatVolunteer;
    }

    public void setRiwayatVolunteer(ArrayList<Kampanye> riwayatVolunteer) {
        this.riwayatVolunteer = riwayatVolunteer;
    }
    public void addRiwayatVolunteer(Kampanye kampanye){
        this.riwayatVolunteer.add(kampanye);
    }
    
    public void addRiwayatDonasi(Donasi donasi){
        this.riwayatDonasi.add(donasi);
    }
    
    public void showRiwayatVolunteer(){
        for(Kampanye k : this.getRiwayatVolunteer()){
            System.out.println("Nama Kampanye: " + k.getNama());
        }
    }
    
    public void donasi(long jml_sumbangan, Kampanye k){
        Donasi d = new Donasi(k, this, jml_sumbangan);
        DonasiDAO.saveDonasi(d);
    }

    public ArrayList<Donasi> getRiwayatDonasi() {
        return riwayatDonasi;
    }

    public void setRiwayatDonasi(ArrayList<Donasi> riwayatDonasi) {
        this.riwayatDonasi = riwayatDonasi;
    }
    
    public void showRiwayatDonasi(){
        for(Donasi d : this.riwayatDonasi){
            System.out.println(d.toString());
        }
    }
    
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
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