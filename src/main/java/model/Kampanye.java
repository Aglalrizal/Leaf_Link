/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Kampanye {
    private UUID idKampanye;
    private String nama;
    private String deskripsi;
    private ArrayList<Personal> volunteer = new ArrayList<>();
    private int targetVolunteer;
    private String lokasi;
    private long targetPendanaan;
    private long sumbangan;
    private Date tanggalPenanaman;
    private String jenisPohon;
    private Date batasDonasi;
    private byte[] dataGambar;
    private Organisasi penyelenggara;

    public Kampanye(UUID idKampanye, String nama, String deskripsi, int targetVolunteer, String lokasi, long targetPendanaan, Date tanggalPenanaman, String jenisPohon, Date batasDonasi, byte[] dataGambar, Organisasi penyelenggara) {
        this.idKampanye = idKampanye;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.targetVolunteer = targetVolunteer;
        this.lokasi = lokasi;
        this.targetPendanaan = targetPendanaan;
        this.tanggalPenanaman = tanggalPenanaman;
        this.jenisPohon = jenisPohon;
        this.batasDonasi = batasDonasi;
        this.dataGambar = dataGambar;
        this.penyelenggara = penyelenggara;
    }

    public Kampanye(String nama, String deskripsi, int targetVolunteer, String lokasi, long targetPendanaan, Date tanggalPenanaman, String jenisPohon, Date batasDonasi, byte[] dataGambar, Organisasi penyelenggara) {
        UUID uuid = UUID.randomUUID();
        setIdKampanye(uuid);
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.targetVolunteer = targetVolunteer;
        this.lokasi = lokasi;
        this.targetPendanaan = targetPendanaan;
        this.tanggalPenanaman = tanggalPenanaman;
        this.jenisPohon = jenisPohon;
        this.batasDonasi = batasDonasi;
        this.dataGambar = dataGambar;
        this.penyelenggara = penyelenggara;
    }
    
    private UUID setIdKampanye(UUID idKampanye){
        return this.idKampanye = idKampanye;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }

    public UUID getIdKampanye() {
        return idKampanye;
    }
    
    public void donasi(long jml_sumbangan){
        this.sumbangan += jml_sumbangan;
    }
    
    public String getNama() {
        return nama;
    }

    public ArrayList<Personal> getVolunteer() {
        return volunteer;
    }

    public int getTargetVolunteer() {
        return targetVolunteer;
    }

    public String getLokasi() {
        return lokasi;
    }

    public long getTargetPendanaan() {
        return targetPendanaan;
    }

    public long getSumbangan() {
        return sumbangan;
    }

    public void addVolunteer(Personal person){
        volunteer.add(person);
    }

    public Organisasi getPenyelenggara() {
        return penyelenggara;
    }

    public void setPenyelenggara(Organisasi penyelenggara) {
        this.penyelenggara = penyelenggara;
    }
    public void setSumbangan(long sumbangan){
        this.sumbangan = sumbangan;
    }

    public Date getTanggalPenanaman() {
        return tanggalPenanaman;
    }

    public void setTanggalPenanaman(Date tanggalPenanaman) {
        this.tanggalPenanaman = tanggalPenanaman;
    }

    public String getJenisPohon() {
        return jenisPohon;
    }

    public void setJenisPohon(String jenisPohon) {
        this.jenisPohon = jenisPohon;
    }

    public Date getBatasDonasi() {
        return batasDonasi;
    }

    public void setBatasDonasi(Date batasDonasi) {
        this.batasDonasi = batasDonasi;
    }

    public byte[] getDataGambar() {
        return dataGambar;
    }

    public void setDataGambar(byte[] dataGambar) {
        this.dataGambar = dataGambar;
    }

    public void setVolunteer(ArrayList<Personal> volunteer) {
        this.volunteer = volunteer;
    }

    public void setTargetVolunteer(int targetVolunteer) {
        this.targetVolunteer = targetVolunteer;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTargetPendanaan(long targetPendanaan) {
        this.targetPendanaan = targetPendanaan;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    public int getJmlVolunteer(){
        return this.volunteer.size();
    }
    
    @Override
    public String toString(){
        return "Id Kampanye: "+getIdKampanye()+
                "\nPenyenggara: "+getPenyelenggara().getNama()+
                "\nNama: "+getNama()+
                "\nLokasi: "+getLokasi()+
                "\nVolunteer yang dibutuhkan: "+getTargetVolunteer()+
                "\nJumlah Volunteer terdaftar: "+this.volunteer.size()+
                "\nTarget Pendanaan: "+getTargetPendanaan()+
                "\nUang Terkumpul: "+getSumbangan()+
                "\nDeskripsi: "+getDeskripsi()+"\n";
    }
}