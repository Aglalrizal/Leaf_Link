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
    private Organisasi author;
    
    public Artikel(UUID uuid, String judul, String konten, Organisasi author) {
        setIdArtikel(uuid);
        this.judul = judul;
        this.isi = konten;
        this.author = author;
    }
    
    public Artikel(String judul, String konten) {
        UUID uuid = UUID.randomUUID();
        setIdArtikel(uuid);
        this.judul = judul;
        this.isi = konten;
    }

    public Artikel(Organisasi author) {
        Scanner scanner = new Scanner(System.in);
        setIdArtikel(idArtikel);
        System.out.println("Judul: ");
        this.judul = scanner.nextLine();
        System.out.println("Judul: ");
        this.isi = scanner.nextLine();;
        this.author = author;
    }
    
    public Artikel(Organisasi author, String judul, String konten) {
        UUID uuid = UUID.randomUUID();
        setIdArtikel(uuid);
        this.judul = judul;
        this.isi = konten;
        this.author = author;
    }

    public Artikel(Organisasi author, String judul) {
        UUID uuid = UUID.randomUUID();
        setIdArtikel(uuid);
        this.judul = judul;
        this.author = author;
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

    public void setAuthor(Organisasi author) {
        this.author = author;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    
    public Organisasi getAuthor(){
        return author;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }


    private UUID setIdArtikel(UUID idArtikel){
        return this.idArtikel=idArtikel;
    }

    @Override
    public String toString(){
        return  "ArtikelId: "+getIdArtikel()+ "\n" +
                "Author: "+getAuthor().nama + "\n" +
                "Judul: "+getJudul()+ "\n" +
                "Konten: "+getIsi()+"\n";
    }
}