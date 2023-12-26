/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Kampanye {
    private UUID idKampanye;
    private String nama;
    private String deskripsi;
    private List<Personal>volunteer = new ArrayList<>();
    private int jumlahVolunteer;
    private String lokasi;
    private long targetPendanaan;
    private long sumbangan;
    private Organisasi penyelenggara;
    public Kampanye(){
        Scanner scanner = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();
        setIdKampanye(uuid);
        System.out.println("Nama: ");
        this.nama = scanner.nextLine();
        System.out.println("Lokasi: ");
        this.lokasi = scanner.nextLine();
        System.out.println("Deskripsi: ");
        this.deskripsi = scanner.nextLine();
        System.out.println("Target Pendanaan: ");
        this.targetPendanaan = scanner.nextInt();
        System.out.println("Jumlah Volunteer");
        this.jumlahVolunteer = scanner.nextInt();
    }
    
    public Kampanye(UUID uuid, String nama, String lokasi, String deskripsi, long targetPendanaan, long sumbangan, int jumlahVolunteer, Organisasi penyelenggara){
        setIdKampanye(uuid);
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.targetPendanaan = targetPendanaan;
        this.sumbangan = sumbangan;
        this.jumlahVolunteer = jumlahVolunteer;
        this.penyelenggara = penyelenggara;
    }
    
    public Kampanye(UUID uuid, String nama, String lokasi, String deskripsi, long targetPendanaan, int jumlahVolunteer, Organisasi penyelenggara){
        setIdKampanye(uuid);
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.targetPendanaan = targetPendanaan;
        this.jumlahVolunteer = jumlahVolunteer;
        this.penyelenggara = penyelenggara;
    }
    
    public Kampanye(String nama, String lokasi, String deskripsi, long targetPendanaan, int jumlahVolunteer, Organisasi penyelenggara){
        UUID uuid = UUID.randomUUID();
        setIdKampanye(uuid);
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.targetPendanaan = targetPendanaan;
        this.jumlahVolunteer = jumlahVolunteer;
        this.penyelenggara = penyelenggara;
    }

    public Kampanye(String nama, String deskripsi, int jumlahVolunteer, String lokasi, long targetPendanaan) {
        UUID uuid = UUID.randomUUID();
        setIdKampanye(uuid);
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlahVolunteer = jumlahVolunteer;
        this.lokasi = lokasi;
        this.targetPendanaan = targetPendanaan;
        this.sumbangan = sumbangan;
    }
    
    public UUID setIdKampanye(UUID idKampanye){
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

    public List<Personal> getVolunteer() {
        return volunteer;
    }

    public int getJumlahVolunteer() {
        return jumlahVolunteer;
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
    @Override
    public String toString(){
        return "Id Kampanye: "+getIdKampanye()+
                "\nPenyenggara: "+getPenyelenggara().getNama()+
                "\nNama: "+getNama()+
                "\nLokasi: "+getLokasi()+
                "\nTarget Pendanaan: "+getTargetPendanaan()+
                "\nUang Terkumpul: "+getSumbangan()+
                "\nDeskripsi: "+getDeskripsi()+"\n";
    }
}