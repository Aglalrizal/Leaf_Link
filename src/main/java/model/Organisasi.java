/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aglalrizal
 */

public class Organisasi extends User {
    private String namaKetua;
    private List<Kampanye> listKampanye = new ArrayList<>();
    private List<Artikel> listArtikel = new ArrayList<>();
    public Organisasi(){
        super();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nama ketua: ");
        this.namaKetua = scanner.nextLine();
        this.role = "Organisasi";
    }
    public Organisasi(String nama, String username, String email, String noHp, String password, String namaKetua, String deskripsi){
        super(nama, username, email, noHp, password);
        this.namaKetua = namaKetua;
    }

    public void addArtikel(Artikel artikel){
        listArtikel.add(artikel);
    }
}