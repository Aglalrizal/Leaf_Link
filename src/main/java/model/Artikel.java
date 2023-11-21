/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author aglalrizal
 */
public class Artikel {
    private String idArtikel;
    private String judul;
    private String konten;
    private Organisasi organisasi;
    public static int indexArtikel = 0;

    public Artikel(Organisasi organisasi) {
        Scanner scanner = new Scanner(System.in);
        setIdArtikel();
        System.out.println("Judul: ");
        this.judul = scanner.nextLine();
        System.out.println("Judul: ");
        this.konten = scanner.nextLine();;
        this.organisasi = organisasi;
    }
    public Artikel(Organisasi organisasi, String judul, String konten) {
        setIdArtikel();
        this.judul = judul;
        this.konten = konten;
        this.organisasi = organisasi;
    }

    public Artikel(Organisasi organisasi, String judul) {
        setIdArtikel();
        this.judul = judul;
        this.organisasi = organisasi;
    }
    public String getIdArtikel() {
        return idArtikel;
    }

    public String getJudul() {
        return judul;
    }

    public String getKonten() {
        return konten;
    }

    public Organisasi getAuthor(){
        return organisasi;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }


    private void setIdArtikel(){
        indexArtikel++;
        this.idArtikel="artikel"+indexArtikel;
    }

    @Override
    public String toString(){
        return  "UserId: "+getIdArtikel()+ "\n" +
                "Author: "+getAuthor() + "\n" +
                "Judul: "+getJudul()+ "\n" +
                "Konten: "+getKonten()+"\n";
    }
}