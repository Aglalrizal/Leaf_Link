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
    private int targetPendanaan;
    private int sumbangan;
    private Organisasi organisasi;
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
    public Kampanye(String nama, String lokasi, String deskripsi, int targetPendanaan, int jumlahVolunteer, Organisasi organisasi){
        UUID uuid = UUID.randomUUID();
        setIdKampanye(uuid);
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.targetPendanaan = targetPendanaan;
        this.jumlahVolunteer = jumlahVolunteer;
        this.organisasi = organisasi;
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

    public int getTargetPendanaan() {
        return targetPendanaan;
    }

    public int getSumbangan() {
        return sumbangan;
    }

    public void addVolunteer(Personal person){
        volunteer.add(person);
    }
    public void sumbangan(int sumbangan){
        this.sumbangan = sumbangan;
    }
    public String toString(){
        return "Id Kampanye: "+getIdKampanye()+
                "\nNama: "+getNama()+
                "\nLokasi: "+getLokasi()+
                "\nTarget Pendanaan: "+getTargetPendanaan()+
                "\nUang Terkumpul: "+getSumbangan()+
                "\nDeskripsi: "+getDeskripsi();
    }
}