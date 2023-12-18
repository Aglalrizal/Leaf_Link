/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Artikel;
import utils.OrganisasiDAO;

/**
 *
 * @author aglalrizal
 */

public class Organisasi extends User {
    private List<Kampanye> listKampanye = new ArrayList<>();
    private List<Artikel> listArtikel = new ArrayList<>();
    public Organisasi(){
        super();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nama ketua: ");
//        this.namaKetua = scanner.nextLine();
        this.role = "Organisasi";
    }
    public Organisasi(String nama, String username, String email, String noHp, String password){
        super(nama, username, email, noHp, password);
//        this.namaKetua = namaKetua;
        this.role = "Organisasi";
    }

    public Organisasi(String nama, String username, String email, String noHp, String password, String deskripsi){
        super(nama, username, email, noHp, password, deskripsi);
//        this.namaKetua = namaKetua;
        this.role = "Organisasi";
    }
    public void addArtikel(Artikel artikel){
        listArtikel.add(artikel);
    }
    public void buatArtikel(String judul, String isi){
        Artikel artikel = new Artikel(this, judul, isi);
        OrganisasiDAO.saveArtikel(this, artikel);
    }
    public void addKampanye(Kampanye k){
        listKampanye.add(k);
    }
    
    public void buatKampanye(String n, String l, String des, int t, int v){
        Kampanye k = new Kampanye(n, l, des, t, v, this);
        OrganisasiDAO.saveKampanye(this, k);
    }
}