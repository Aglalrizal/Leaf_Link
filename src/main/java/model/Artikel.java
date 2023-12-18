/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author aglalrizal
 */
public class Artikel {
    private UUID idArtikel;
    private String judul;
    private String isi;
    private Organisasi organisasi;
    public static int indexArtikel = 0;

    public Artikel(Organisasi organisasi) {
        Scanner scanner = new Scanner(System.in);
        setIdArtikel(idArtikel);
        System.out.println("Judul: ");
        this.judul = scanner.nextLine();
        System.out.println("Judul: ");
        this.isi = scanner.nextLine();;
        this.organisasi = organisasi;
    }
    public Artikel(Organisasi organisasi, String judul, String konten) {
        UUID uuid = UUID.randomUUID();
        setIdArtikel(uuid);
        this.judul = judul;
        this.isi = konten;
        this.organisasi = organisasi;
    }

    public Artikel(Organisasi organisasi, String judul) {
        UUID uuid = UUID.randomUUID();
        setIdArtikel(uuid);
        this.judul = judul;
        this.organisasi = organisasi;
    }
    public UUID getIdArtikel() {
        return idArtikel;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public Organisasi getAuthor(){
        return organisasi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }


    private UUID setIdArtikel(UUID idArtikel){
        return this.idArtikel=idArtikel;
    }

    @Override
    public String toString(){
        return  "UserId: "+getIdArtikel()+ "\n" +
                "Author: "+getAuthor() + "\n" +
                "Judul: "+getJudul()+ "\n" +
                "Konten: "+getIsi()+"\n";
    }
}